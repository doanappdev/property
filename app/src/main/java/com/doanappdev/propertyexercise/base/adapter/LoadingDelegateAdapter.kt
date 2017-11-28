package com.doanappdev.propertyexercise.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.doanappdev.propertyexercise.R
import com.doanappdev.propertyexercise.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.item_loading)
    )
}
