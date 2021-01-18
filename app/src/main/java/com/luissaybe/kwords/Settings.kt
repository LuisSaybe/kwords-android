package com.luissaybe.kwords

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.luissaybe.kwords.databinding.ActivitySettingsBinding

class Settings : AppCompatActivity() {
    val settingsModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val binding: ActivitySettingsBinding = DataBindingUtil.setContentView(this, R.layout.activity_settings)
        binding.lifecycleOwner = this
        binding.viewmodel = settingsModel

        settingsModel.playSpeedSpinnerPosition.observe(this, { value ->
            Log.d("Settings", value.toString() + " = position")
        })

        // var spinner = this.findViewById<Spinner>(R.id.play_speed_spinner)

        Log.d("Settings", settingsModel.playSpeedSpinnerPosition.value.toString() + " = position")
    }

    fun onBackClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
    }
}