package com.example.rrulepractice.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rrulepractice.R
import com.example.rrulepractice.utils.Helper


class LibOccurrenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lib_occurrence)
        val helper = Helper()
        helper.getScheduled("FREQ=DAILY;COUNT=90;WKST=SU;BYDAY=MO,WE,SA")
//        Log.d("TAG", "onCreate: ${lib.getScheduled("FREQ=DAILY;COUNT=90;WKST=SU;BYDAY=MO,WE,SA")}")
    }
}