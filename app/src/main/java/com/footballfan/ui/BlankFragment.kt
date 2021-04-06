package com.footballfan.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import com.footballfan.R

class BlankFragment : RainbowCakeFragment<BlankViewState, BlankViewModel>(){

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_blank

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blank,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO Setup views
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: BlankViewState) {
        // TODO Render state
    }



}
