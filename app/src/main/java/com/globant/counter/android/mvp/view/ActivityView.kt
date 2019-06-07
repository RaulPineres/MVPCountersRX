package com.globant.counter.android.mvp.view

import android.app.Activity
import java.lang.ref.WeakReference

open class ActivityView(activity: Activity) {

    private var activityRef: WeakReference<Activity> = WeakReference(activity)

    fun getActivity(): Activity? {
        return activityRef.get()
    }
}

