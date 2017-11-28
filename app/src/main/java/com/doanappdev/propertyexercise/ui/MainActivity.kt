package com.doanappdev.propertyexercise.ui

import android.os.Bundle
import android.util.Log
import com.doanappdev.propertyexercise.model.Listings
import com.doanappdev.propertyexercise.R
import com.doanappdev.propertyexercise.base.ui.BaseActivity
import javax.inject.Inject
import android.os.PersistableBundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ListAdapter
import com.doanappdev.propertyexercise.base.adapter.ViewType
import com.doanappdev.propertyexercise.ui.list.ListingsAdapter
import com.doanappdev.propertyexercise.ui.list.PremiumItem
import com.doanappdev.propertyexercise.ui.list.StandardItem
import io.reactivex.internal.operators.maybe.MaybeIsEmpty
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class MainActivity : BaseActivity(), MainView {

    private val TAG: String = MainActivity::class.java.simpleName

    private val KEY_ONE: String = "key_one"
    private val KEY_TWO: String = "key_two"

    @Inject lateinit var presenter: MainPresenter

    private var testValue1 = "Test Value"
    private var testValue2 = "Some Test Value"


    override fun getLayoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent?.inject(this)
        presenter.bind(this)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            clearOnScrollListeners()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.getSearchResponse()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle, persistentState: PersistableBundle) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.i(TAG, "onRestoreInstanceState called!!")
        testValue1 = savedInstanceState.getString(KEY_ONE)
        testValue2 = savedInstanceState.getString(KEY_TWO)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.i(TAG, "onSaveInstanceState called!")
        outState.putString(KEY_ONE, testValue1)
        outState.putSerializable(KEY_TWO, testValue2)
        //outState.putStringArrayList(KEY_TWO, testValue2)
    }



    override fun setAdapter(listings: List<Listings>) {
        val viewTypes = ArrayList<ViewType>()
        var photo: String
        var logoUrl: String
        for (lr in listings) {
            Log.i(TAG, "Listing: adId = ${lr.adId}")
            Log.i(TAG, "Listing: agencyColour = ${lr.agencyColour}")
            Log.i(TAG, "Listing: isElite = ${lr.isElite}")

            if (lr.agencyContactPhoto.isNullOrEmpty()) {
                photo = ""
            } else {
                photo = lr.agencyContactPhoto!!
            }

            if (lr.agencyColour.isNullOrEmpty()) {
                logoUrl = ""
            } else {
                logoUrl = lr.agencyLogoUrl!!
            }

            viewTypes.add(StandardItem(
                    lr.adId,
                    lr.agencyColour,
                    photo,
                    lr.agencyId,
                    logoUrl,
                    lr.isElite))
        }

       if (recyclerView.adapter == null) {
           Log.d(TAG, "list size = ${viewTypes.size}")
           recyclerView.adapter = ListingsAdapter(viewTypes)
       }
    }

    override fun onSearchError() {
        Log.e(TAG, "onSearchError")
        toast("Error fetching Listings data!")
    }

//    private fun checkStringNull(isEmpty: Boolean, listing: Listings): String = when(isEmpty) {
//            true -> ""
//            false -> listing.agencyContactPhoto!!
//    }
}
