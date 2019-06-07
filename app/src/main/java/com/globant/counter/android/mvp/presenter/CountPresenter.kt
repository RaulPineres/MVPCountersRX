package com.globant.counter.android.mvp.presenter

import android.util.Log
import com.globant.counter.android.mvp.model.CalculatorModel
import com.globant.counter.android.mvp.view.CountView
import com.globant.counter.android.util.bus.RxBus

class CountPresenter(private val model: CalculatorModel, private val view: CountView) {

    fun onAddButtonPressed(input: Int) {
        model.set(input)
        view.setNum("")
    }

    fun onEqualButtonPressed(input: Int){
        val total = model.getNum() + input
        model.set(total)
        view.setNum(model.getNum().toString())
    }

    fun onClearButtonPressed() {
        model.clear()
        view.setNum("")
    }

    fun register() {
        view.buttonAddSubject
                .subscribe {
                    onAddButtonPressed(it)
                }

        view.buttonEqualSubject
                .subscribe {
                    onEqualButtonPressed(it)
                }

        view.buttonClearSubject
                .subscribe {
                    onClearButtonPressed()
                }
    }

    fun unregister() {
        val activity = view.getActivity() ?: return
        RxBus.clear(activity)
    }
}
