package com.footballfan.ui.register

sealed class RegisterViewState

object Loading : RegisterViewState()

data class RegisterReady(val data: String = "") : RegisterViewState()
