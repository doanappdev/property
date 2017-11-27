package com.doanappdev.propertyexercise

import android.content.Context
import com.doanappdev.propertyexercise.di.AppComponent


fun Context.getAppComponent(): AppComponent = (applicationContext as PropertyApp).appComponent
