package com.doanappdev.propertyexercise.ui.list

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.doanappdev.propertyexercise.R
import com.doanappdev.propertyexercise.base.adapter.ViewType
import com.doanappdev.propertyexercise.base.adapter.ViewTypeDelegateAdapter
import com.doanappdev.propertyexercise.inflate
import kotlinx.android.synthetic.main.item_premium_view.view.*

class PremiumDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return PremiumViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as PremiumViewHolder
        holder.bind(item as PremiumItem)
    }

    inner class PremiumViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_premium_view)) {
        fun bind(item: PremiumItem) = with(itemView) {
            setPropertyImage(leftPhoto, item.retinaDisplayThumbUrl)
            setPropertyImage(rightPhoto, item.secondThumbUrl)
            rowOne.text = item.displayPrice
            rowTwo.text = item.getRowTwoString()
            rowThree.text = item.displayableAddress

            agencyBtn.setBackgroundColor(Color.parseColor(item.agencyColour))
        }

        private fun setPropertyImage(imgView: ImageView, url: String?) {
            Glide.with(imgView.context)
                    .load(url)
                    .placeholder(R.drawable.ic_sync_black_24px)
                    .into(imgView)
        }

    }

}
