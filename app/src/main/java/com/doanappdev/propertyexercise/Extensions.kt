package com.doanappdev.propertyexercise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.doanappdev.propertyexercise.di.AppComponent


fun Context.getAppComponent(): AppComponent = (applicationContext as PropertyApp).appComponent

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}
