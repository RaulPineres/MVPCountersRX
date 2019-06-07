package com.globant.counter.android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.globant.counter.android.mvp.model.CountModel
import com.globant.counter.android.mvp.presenter.CountPresenter
import com.globant.counter.android.mvp.view.CountView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: CountPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countViews = CountView(this)
        presenter = CountPresenter(CountModel(), countViews)

        count_button.setOnClickListener {
            countViews.countButtonPressed()
        }

        reset_button.setOnClickListener {
            countViews.resetButtonPressed()
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
