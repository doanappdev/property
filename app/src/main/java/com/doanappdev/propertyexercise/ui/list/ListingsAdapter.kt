package com.doanappdev.propertyexercise.ui.list

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.doanappdev.propertyexercise.LOADING
import com.doanappdev.propertyexercise.PREMIUM_VIEW
import com.doanappdev.propertyexercise.STANDARD_VIEW
import com.doanappdev.propertyexercise.base.adapter.LoadingDelegateAdapter
import com.doanappdev.propertyexercise.base.adapter.ViewType
import com.doanappdev.propertyexercise.base.adapter.ViewTypeDelegateAdapter

class ListingsAdapter(var items: List<ViewType>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var viewTypes: ArrayList<ViewType> = ArrayList()
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = LOADING
    }


    init {
        //delegateAdapters.put(LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(STANDARD_VIEW, StandardDelegateAdapter())
        delegateAdapters.put(PREMIUM_VIEW, PremiumDelegateAdapter())
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent!!)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder!!, items[position])
    }


    override fun getItemCount(): Int = items.size
    override fun getItemViewType(position: Int) = items[position].getViewType()

    fun setViewTypes(items: List<ViewType>) {
        this.items = items
    }
}
