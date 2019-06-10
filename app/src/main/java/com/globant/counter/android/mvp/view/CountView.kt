package com.globant.counter.android.mvp.view

import android.app.Activity
import android.text.TextUtils
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_main.*

class CountView(private val activityMain: Activity) : ActivityView(activityMain) {

    val buttonAddSubject: PublishSubject<String> = PublishSubject.create()
    val buttonEqualSubject: PublishSubject<String> = PublishSubject.create()
    val buttonClearSubject: PublishSubject<Unit> = PublishSubject.create()

    val BLANK_SPACE = ""

    fun setNumber(count: String) {
        activityMain.editText_calculator_input.setText(count)
    }

    fun addButtonPressed(input: String) {
        if(!TextUtils.isEmpty(input)){
            buttonAddSubject.onNext(input)
        }
    }

    fun equalButtonPressed(input: String) {
        if(!TextUtils.isEmpty(input)){
            buttonEqualSubject.onNext(input)
        }
    }

    fun clearButtonPressed() {
        buttonClearSubject.onNext(Unit)
    }

    fun clearField(){
        activityMain.editText_calculator_input.setText(BLANK_SPACE)
    }
}
