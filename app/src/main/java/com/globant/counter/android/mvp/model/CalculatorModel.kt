package com.globant.counter.android.mvp.model

class CalculatorModel(var count: Int = 0) {

    fun clear() {
        count = 0
    }
}
