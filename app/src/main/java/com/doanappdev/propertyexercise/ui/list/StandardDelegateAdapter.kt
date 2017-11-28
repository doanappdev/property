package com.doanappdev.propertyexercise.ui.list

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.doanappdev.propertyexercise.R
import com.doanappdev.propertyexercise.base.adapter.ViewType
import com.doanappdev.propertyexercise.base.adapter.ViewTypeDelegateAdapter
import com.doanappdev.propertyexercise.inflate
import kotlinx.android.synthetic.main.item_standard_view.view.*
import org.jetbrains.anko.imageResource

class StandardDelegateAdapter : ViewTypeDelegateAdapter {


    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return StandardViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as StandardViewHolder
        holder.bind(item as StandardItem)
    }

    inner class StandardViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(parent.inflate(R.layout.item_standard_view)) {
        fun bind(item: StandardItem) = with(itemView) {
            //photo.imageResource = item.agencyLogoUrl
            rowOne.text = item.agencyId.toString()
            rowTwo.text = item.agencyColour
            rowThree.text = item.agencyContactPhoto
        }

    }

}
