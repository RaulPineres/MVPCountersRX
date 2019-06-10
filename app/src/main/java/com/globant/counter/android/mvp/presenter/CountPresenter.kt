package com.globant.counter.android.mvp.presenter

import android.util.Log
import com.globant.counter.android.mvp.model.CountModel
import com.globant.counter.android.mvp.view.CountView
import com.globant.counter.android.util.bus.RxBus
import com.globant.counter.android.util.bus.observers.CountButtonUpBusObserver
import com.globant.counter.android.util.bus.observers.ResetButtonObserver

class CountPresenter(val model: CountModel, val views: CountView) {

    fun onCountButtonPressed() {
        model.count++
        views.setCount(model.count.toString())
    }

    fun onResetButtonPressed() {
        model.reset()
        views.setCount(model.count.toString())
    }

    fun register() {
        val activity = views.getActivity() ?: return

        RxBus.subscribe(activity, object : CountButtonUpBusObserver() {
            override fun onEvent(value: CountButtonUp?) {
                Log.e(this.javaClass.simpleName, "onCountButtonPressed clicked: ")
                onCountButtonPressed()
            }

        })

        RxBus.subscribe(activity, object : ResetButtonObserver() {
            override fun onEvent(value: ResetButtonPressed?) {
                onResetButtonPressed()
            }

        })
    }

    fun unregister() {
        val activity = views.getActivity() ?: return
        RxBus.clear(activity)
    }
}
