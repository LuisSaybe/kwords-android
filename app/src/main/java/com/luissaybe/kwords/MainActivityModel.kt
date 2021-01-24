package com.luissaybe.kwords

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainActivityModel() : ViewModel() {
    val playPauseButtonId = MutableLiveData<Int>(R.drawable.play)
}