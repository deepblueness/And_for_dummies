package com.hannesdorfmann.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_counter.*

class CounterFragment : Fragment() {

    var counter : Int =  0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        counter = savedInstanceState?.getInt("counterState") ?: 0

        super.onCreate(savedInstanceState)
        Log.d("Lifecycle", "onCreate $this")

        minus.setOnClickListener {

            val f = SecondFragment.newInstance(counter)

            activity!!.supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, f)
                .addToBackStack(null)
                .commit()

        }
        add.setOnClickListener {
            counter++
            count.text =counter.toString() }

        count.text =counter.toString()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counterState", counter)
    }



    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy $this")
    }
}