package com.luissaybe.kwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.luissaybe.kwords.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val model: MainActivityModel by viewModels()
    private val backgroundObserver = Observer<Int> { id ->
        val button: Button = findViewById(R.id.play_pause)
        button.background = ContextCompat.getDrawable(this, id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.model = model
        model.playPauseButtonId.observe(this, backgroundObserver)
    }

    override fun onResume() {
        super.onResume()
        val button: Button = findViewById(R.id.play_pause)
        button.background = ContextCompat.getDrawable(this, model.playPauseButtonId.value!!)
        overridePendingTransition(0, 0)
    }

    fun onSettingsClick(view: View) {
        val intent = Intent(this, Settings::class.java)
            .addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        startActivity(intent)
    }

    fun onPreviousClick(view: View) {

    }

    fun onNextClick(view: View) {

    }

    fun onPlayPauseClick(view: View) {
        if (model.playPauseButtonId.value == R.drawable.play) {
            model.playPauseButtonId.setValue(R.drawable.pause)
        } else {
            model.playPauseButtonId.setValue(R.drawable.play)
        }
    }
}