package com.globant.counter.android.mvp.view

import android.app.Activity
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_main.*

class CountView(private val activityMain: Activity) : ActivityView(activityMain) {

    val buttonAddSubject: PublishSubject<Int> = PublishSubject.create()
    val buttonEqualSubject: PublishSubject<Int> = PublishSubject.create()
    val buttonClearSubject: PublishSubject<Unit> = PublishSubject.create()

    fun setNum(count: String) {
        activityMain.calc_screen.setText(count)
    }

    fun addButtonPressed(input: Int) {
        buttonAddSubject.onNext(input)
    }

    fun equalButtonPressed(input: Int) {
        buttonEqualSubject.onNext(input)
    }

    fun clearButtonPressed() {
        buttonClearSubject.onNext(Unit)
    }
}
