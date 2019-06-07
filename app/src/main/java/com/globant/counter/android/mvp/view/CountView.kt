package com.globant.counter.android.mvp.view

import android.app.Activity
import com.globant.counter.android.util.bus.RxBus
import com.globant.counter.android.util.bus.observers.CountButtonUpBusObserver
import com.globant.counter.android.util.bus.observers.ResetButtonObserver
import kotlinx.android.synthetic.main.activity_main.*

class CountView(private val activitys: Activity): ActivityView(activitys) {

    fun setCount(count: String){
        activitys.count_label.text = count
    }

    fun countButtonPressed(){
        RxBus.post(CountButtonUpBusObserver.CountButtonUp())
    }

    fun resetButtonPressed(){
        RxBus.post(ResetButtonObserver.ResetButtonPressed())
    }

}
