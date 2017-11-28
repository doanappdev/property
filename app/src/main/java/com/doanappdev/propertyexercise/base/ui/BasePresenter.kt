package com.doanappdev.propertyexercise.base.ui

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T : BaseView> {

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
