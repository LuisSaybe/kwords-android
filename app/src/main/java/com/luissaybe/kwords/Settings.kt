package com.luissaybe.kwords

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.luissaybe.kwords.databinding.ActivitySettingsBinding

class Settings : AppCompatActivity() {
    private val settingsModel: SettingsViewModel by viewModels()

    override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        setContentView(R.layout.activity_settings)
        val binding: ActivitySettingsBinding = DataBindingUtil.setContentView(this, R.layout.activity_settings)
        binding.lifecycleOwner = this
        binding.viewmodel = settingsModel
    }

    override fun onResume() {
        super.onResume()
        overridePendingTransition(0, 0)
    }

    fun onBackClick(view: View) {
        val intent = Intent(this, MainActivity::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
    }
}