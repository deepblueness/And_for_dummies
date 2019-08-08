package com.hannesdorfmann.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.fragment_counter.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null){

            val f = CounterFragment()

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, f)
                .addToBackStack(null)
                .commit()
        }
    }
}
