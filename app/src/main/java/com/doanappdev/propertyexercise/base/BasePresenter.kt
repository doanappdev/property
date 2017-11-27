package com.doanappdev.propertyexercise.base

import com.doanappdev.propertyexercise.base.ui.BaseMvpView
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T : BaseMvpView> {

    protected val disposables = CompositeDisposable()
    protected var view: T? = null

    fun bind(view: T) {
        this.view = view
    }

    fun unbind() {
        this.view = null
    }

    fun destroy() {
        disposables.clear()
        unbind()
    }

}
