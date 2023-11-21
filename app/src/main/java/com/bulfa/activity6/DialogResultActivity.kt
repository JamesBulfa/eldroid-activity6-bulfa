package com.bulfa.activity6

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bulfa.activity6.databinding.ActivityDialogResultBinding

class DialogResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDialogResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.resultTextView.text = "${intent.getStringExtra("alertDialogResult")},\n${intent.getStringExtra("datePickerDialogResult")},\n${intent.getStringExtra("timePickerDialogResult")},"

        binding.backButton.setOnClickListener { finish() }

    }
}