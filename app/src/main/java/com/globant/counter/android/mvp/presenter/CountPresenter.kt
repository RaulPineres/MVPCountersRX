package com.globant.counter.android.mvp.presenter

import android.text.TextUtils
import butterknife.internal.Utils
import com.globant.counter.android.mvp.model.CalculatorModel
import com.globant.counter.android.mvp.view.CountView
import com.globant.counter.android.util.bus.RxBus

class CountPresenter(private val model: CalculatorModel, private val view: CountView) {

    fun onAddButtonPressed(input: String) {
            model.count = input.toInt()
            view.clearField()
    }

    fun onEqualButtonPressed(input: String) {
            model.count += input.toInt()
            view.setNumber(model.count.toString())
    }

    fun onClearButtonPressed() {
        model.clear()
        view.clearField()
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
