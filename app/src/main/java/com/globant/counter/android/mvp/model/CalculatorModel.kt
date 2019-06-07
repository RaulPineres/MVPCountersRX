package com.globant.counter.android.mvp.model

data class CalculatorModel(var count: Int = 0) {

    fun clear() {
        count = 0
    }

    fun set(num: Int) {
        count = num
    }

    fun getNum(): Int {
        return count
    }
}