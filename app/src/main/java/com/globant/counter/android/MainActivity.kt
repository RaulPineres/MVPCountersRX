package com.globant.counter.android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.globant.counter.android.mvp.model.CalculatorModel
import com.globant.counter.android.mvp.presenter.CountPresenter
import com.globant.counter.android.mvp.view.CountView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: CountPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countViews = CountView(this)
        presenter = CountPresenter(CalculatorModel(), countViews)

        add_button.setOnClickListener {
            val number = calc_screen.text.toString()
            countViews.addButtonPressed(number.toInt())
        }

        equal_button.setOnClickListener {
            val number = calc_screen.text.trim().toString()
            countViews.equalButtonPressed(number.toInt())
        }

        clear_button.setOnClickListener {
            countViews.clearButtonPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.register()
    }

    override fun onPause() {
        super.onPause()
        presenter.unregister()
    }
}
