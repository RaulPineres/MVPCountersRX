package com.globant.counter.android.mvp.model

class CountModel(var count: Int = 0) {

    fun reset(){
        count = 0
    }
}
