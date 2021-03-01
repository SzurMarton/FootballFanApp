package com.footballfan.ui.register

import android.os.Bundle
import android.view.View
import android.widget.Toast
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.footballfan.R
import com.footballfan.ui.BlankFragment
import com.footballfan.ui.BlankViewState
import com.footballfan.ui.register.ViewReady
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.etEmailAddress
import kotlinx.android.synthetic.main.fragment_register.etPassword

class RegisterFragment : RainbowCakeFragment<RegisterViewState,RegisterViewModel>(){
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_register

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnRegister.setOnClickListener {
            val email = etEmailAddress.text.toString()
            val password = etPassword.text.toString()
            val username = etUsername.text.toString()
            viewModel.saveUser(email,password,username)
        }
    }


    override fun onEvent(event: OneShotEvent) {
        when(event){
            is RegisterViewModel.InputFailureEvent -> Toast.makeText(activity,"Wrong input",Toast.LENGTH_SHORT).show()
            is RegisterViewModel.NavigateSuccessEvent -> navigator?.replace(BlankFragment())
            is RegisterViewModel.NavigateFailureEvent -> Toast.makeText(activity,event.errorMessage,Toast.LENGTH_SHORT).show()
        }
    }

    override fun render(viewState: RegisterViewState) {
        when(viewState){
            ViewReady -> {}
        }
    }
}