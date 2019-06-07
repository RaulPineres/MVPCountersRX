package com.globant.counter.android.mvp.presenter

import com.globant.counter.android.mvp.model.CountModel
import com.globant.counter.android.mvp.view.CountView
import com.globant.counter.android.util.bus.RxBus

class CountPresenter(private val model: CountModel, private val view: CountView) {

    fun onCountButtonPressed() {
        model.inc()
        view.setCount(model.getCounts().toString())
    }

    fun onResetButtonPressed() {
        model.reset()
        view.setCount(model.getCounts().toString())
    }

    fun register() {
        view.buttonUpSubject
                .subscribe {
                    onCountButtonPressed()
                }

        view.buttonResetSubject
                .subscribe {
                    onResetButtonPressed()
                }
    }

    fun unregister() {
        val activity = view.getActivity() ?: return
        RxBus.clear(activity)
    }
}
