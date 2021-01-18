package com.luissaybe.kwords

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class SettingsViewModel(app: Application) : AndroidViewModel(app) {
    val playSpeedSpinnerPosition = MutableLiveData(0)
}
