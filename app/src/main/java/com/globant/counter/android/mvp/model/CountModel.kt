package com.globant.counter.android.mvp.model

data class CountModel(var count: Int = 0) {

    fun reset(){
        count = 0
    }

    fun inc(){
        count += 1
    }

    fun getCounts(): Int{
        return  count
    }
}
