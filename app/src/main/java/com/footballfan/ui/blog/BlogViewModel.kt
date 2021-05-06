package com.footballfan.ui.blog

import android.content.ContentValues.TAG
import android.util.Log
import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import com.footballfan.domain.RegisterInteractor
import com.footballfan.ui.blog.model.BlogPost
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class BlogViewModel @Inject constructor(
        private val blogpresenter: BlogPresenter
) : RainbowCakeViewModel<BlogViewState>(Initial) {
    private var posts : ArrayList<BlogPost?> = ArrayList()

    fun getPosts() {
        viewState = Loading
        FirebaseDatabase.getInstance().getReference("/blogposts").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                viewState = Error
                Log.w(TAG, "loadPost:onCancelled", error.toException())
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (postSnapshot in snapshot.children){
                        var post = postSnapshot.getValue(BlogPost::class.java)
                        post?.uid = postSnapshot.key
                        posts.add(post)
                    }
                    viewState = BlogPostsReady(posts)
                }
                else{
                    viewState = Error
                }
            }

        }
        )
    }

    fun savePost(blogPost: BlogPost) {
        FirebaseDatabase.getInstance().reference.child("/blogposts").
            push().setValue(blogPost).addOnCompleteListener{ task ->
            if (task.isSuccessful){
                Log.d("asd","save succesfull")
            }
            else{
                Log.d("asd","save fail")
            }
        }
    }
}