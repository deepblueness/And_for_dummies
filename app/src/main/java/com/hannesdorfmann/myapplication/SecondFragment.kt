package com.hannesdorfmann.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_2.*

class SecondFragment : Fragment() {

     var counter = 0

    companion object {
        fun newInstance(counter : Int) : SecondFragment{
            val f = SecondFragment()
            val b = Bundle()
            b.putInt("key_foo", counter)
            f.arguments = b
            f.counter = counter
            return f
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        counter_value.text = arguments!!.getInt("key_foo", -1).toString()
    }
}