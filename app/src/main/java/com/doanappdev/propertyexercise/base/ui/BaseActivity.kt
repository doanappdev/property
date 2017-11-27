package com.doanappdev.propertyexercise.base.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.doanappdev.propertyexercise.di.AppComponent
import com.doanappdev.propertyexercise.getAppComponent

abstract class BaseActivity : AppCompatActivity() {
    protected var appComponent: AppComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        appComponent = getAppComponent()
    }

    override fun onDestroy() {
        appComponent = null
        super.onDestroy()
    }

    protected abstract fun getLayoutResId(): Int
}
