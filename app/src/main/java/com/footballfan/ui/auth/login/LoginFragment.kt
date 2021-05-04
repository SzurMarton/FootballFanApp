package com.footballfan.ui.auth.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import co.zsmb.rainbowcake.base.OneShotEvent
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import com.footballfan.R
import com.footballfan.ui.BlankFragment
import com.footballfan.ui.auth.register.RegisterFragment
import com.footballfan.ui.main.MainFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : RainbowCakeFragment<LoginViewState,LoginViewModel>(){
    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_login

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnLogin.setOnClickListener{
            val email = etEmailAddress.text.toString()
            val password = etPassword.text.toString()
            viewModel.login(email, password)
        }

        textRegister.setOnClickListener{
            navigator?.add(RegisterFragment())
        }
    }

    override fun onEvent(event: OneShotEvent) {
        when(event){
            is LoginViewModel.LoginSuccessEvent -> navigator?.add(MainFragment())
            is LoginViewModel.LoginFailedEvent -> Toast.makeText(activity, event.errorMessages,Toast.LENGTH_SHORT).show()
        }
    }

    override fun render(viewState: LoginViewState) {
        when(viewState){
            ViewReady -> {}
        }
    }

}