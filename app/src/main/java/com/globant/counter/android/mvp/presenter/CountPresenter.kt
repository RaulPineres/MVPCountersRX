package com.globant.counter.android.mvp.presenter

import com.globant.counter.android.mvp.model.CountModel
import com.globant.counter.android.mvp.view.CountView
import com.globant.counter.android.util.bus.RxBus
import com.globant.counter.android.util.bus.observers.CountButtonUpBusObserver
import com.globant.counter.android.util.bus.observers.ResetButtonObserver

class CountPresenter(private val model: CountModel, private val view: CountView) {

    fun onCountButtonPressed() {
        model.count++
        view.showCount(model.count.toString())
    }

    fun onResetButtonPressed() {
        model.reset()
        view.resetCount(model.count.toString())
    }

    fun register() {
        val activity = view.getActivity() ?: return

        RxBus.subscribe(activity, object : CountButtonUpBusObserver() {
            override fun onEvent(value: CountButtonUp?) {
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
        val activity = view.getActivity() ?: return
        RxBus.clear(activity)
    }
}
