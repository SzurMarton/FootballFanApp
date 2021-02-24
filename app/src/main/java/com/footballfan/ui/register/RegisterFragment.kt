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
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : RainbowCakeFragment<RegisterViewState,RegisterViewModel>(){
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_register

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnRegister.setOnClickListener {
            val email = etEmailAddress.text.toString()
            val password = etPassword.text.toString()
            viewModel.saveUser(email,password)
        }
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun onEvent(event: OneShotEvent) {
        when(event){
            is RegisterViewModel.NavigateSuccessEvent -> navigator?.replace(BlankFragment())
            is RegisterViewModel.NavigateFailureEvent -> Toast.makeText(activity,event.errorMessage,Toast.LENGTH_SHORT).show()
        }
    }

    override fun render(viewState: RegisterViewState) {
        // TODO Render state
    }
}