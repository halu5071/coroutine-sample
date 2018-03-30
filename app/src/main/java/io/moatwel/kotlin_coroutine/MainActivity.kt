package io.moatwel.kotlin_coroutine

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)

        val haluText: TextView = findViewById(R.id.halu)

        viewModel.halu.observe(this, Observer {
            haluText.text = it?.name
        })

        viewModel.loadUser()
        viewModel.loadMany()
    }
}
