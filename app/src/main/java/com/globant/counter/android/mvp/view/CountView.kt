package com.globant.counter.android.mvp.view

import android.app.Activity
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_main.*

class CountView(private val activityMain: Activity): ActivityView(activityMain) {

    val buttonUpSubject : PublishSubject<Unit> = PublishSubject.create()
    val buttonResetSubject: PublishSubject<Unit> = PublishSubject.create()

    fun setCount(count: String) {
        activityMain.count_label.text = count
    }

    fun countButtonPressed() {
        buttonUpSubject.onNext(Unit)
    }

    fun resetButtonPressed() {
        buttonResetSubject.onNext(Unit)
    }
}
