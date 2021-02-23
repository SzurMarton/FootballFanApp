package com.footballfan.ui

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class BlankPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
