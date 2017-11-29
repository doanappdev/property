package com.doanappdev.propertyexercise.ui.list

import android.graphics.Bitmap
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.doanappdev.propertyexercise.R
import com.doanappdev.propertyexercise.base.adapter.ViewType
import com.doanappdev.propertyexercise.base.adapter.ViewTypeDelegateAdapter
import com.doanappdev.propertyexercise.inflate
import kotlinx.android.synthetic.main.item_standard_view.view.*

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
            setPropertyImage(photo, item.urlStrings[0])
            rowOne.text = item.agencyId.toString()
            rowTwo.text = item.agencyColour
            rowThree.text = item.agencyContactPhoto
        }

        private fun setPropertyImage(imgView: ImageView, url: String) {
            Glide.with(imgView.context)
                    .load(url)
                    .asBitmap().centerCrop()
                    .into(object : BitmapImageViewTarget(imgView) {
                        override fun setResource(resource: Bitmap) {
                            val bitmapDrawable = RoundedBitmapDrawableFactory.create(
                                    itemView.resources,
                                    resource)
                            //bitmapDrawable.isCircular = true
                            imgView.setImageDrawable(bitmapDrawable)
                        }
                    })

        }

    }

}
