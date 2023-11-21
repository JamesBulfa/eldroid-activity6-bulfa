package com.bulfa.activity6

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.bulfa.activity6.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, DialogResultActivity::class.java)

        binding.alertDialogButton.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("Receive updates?")
                .setPositiveButton("YES") { _, _ ->
                    intent.putExtra("alertDialogResult", "Will Receive update: YES")
                }
                .setNegativeButton("NO") { _, _ ->
                    intent.putExtra("alterDialogResult", "Will Receive update: NO")
                }
                .create()

            alertDialog.show()
        }

        binding.datePickerDialogButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
                intent.putExtra("datePickerDialogResult", "Date selected: $selectedYear-$selectedMonth-$selectedDay")
            }, year, month, day)

            datePickerDialog.show()
        }

        binding.timePickerDialogButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
                intent.putExtra("timePickerDialogResult", "Time selected: $selectedHour:$selectedMinute")
            }, hour, minute, true)

            timePickerDialog.show()
        }

        binding.resultButton.setOnClickListener {
            startActivity(intent)
        }

    }
}