package com.doanappdev.propertyexercise.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import com.doanappdev.propertyexercise.R
import com.doanappdev.propertyexercise.base.ui.BaseActivity
import javax.inject.Inject
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.doanappdev.propertyexercise.base.adapter.ViewType
import com.doanappdev.propertyexercise.ui.list.PropertiesViewModel
import com.doanappdev.propertyexercise.ui.list.ListingsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class MainActivity : BaseActivity(), MainView {

    private val TAG: String = MainActivity::class.java.simpleName

    private val KEY_GET_LISTINGS: String = "key_get_listings"
    private var isGetListings = true

    private var propertiesViewModel: PropertiesViewModel = PropertiesViewModel()

    @Inject lateinit var presenter: MainPresenter

    override fun getLayoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent?.inject(this)
        presenter.bind(this)

        propertiesViewModel = ViewModelProviders.of(this)[PropertiesViewModel::class.java]


        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            clearOnScrollListeners()
        }

        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_GET_LISTINGS)) {
            isGetListings = savedInstanceState.get(KEY_GET_LISTINGS) as Boolean
            Log.d(TAG, "onCreate : isGetListings : $isGetListings")
        }
    }

    override fun onResume() {
        super.onResume()
        if (isGetListings) {
            displayProgressBar(true)
            presenter.getSearchResponse()
        } else {
            recyclerView.adapter = ListingsAdapter(propertiesViewModel.viewTypes)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        isGetListings = savedInstanceState!!.getBoolean(KEY_GET_LISTINGS)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState!!.putBoolean(KEY_GET_LISTINGS, isGetListings)
    }

    override fun setAdapter(viewTypes: List<ViewType>) {
        displayProgressBar(false)
       if (recyclerView.adapter == null) {
           Log.d(TAG, "list size = ${viewTypes.size}")
           recyclerView.adapter = ListingsAdapter(viewTypes)
           propertiesViewModel.viewTypes = viewTypes
           isGetListings = false
       }
    }

    override fun onSearchError() {
        displayProgressBar(false)
        Log.e(TAG, "onSearchError")
        toast("Error fetching Listing data!")
        isGetListings = true
    }

    override fun displayProgressBar(isDisplay: Boolean) {
        when(isDisplay) {
            true -> {
                progressBar.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            }
            false -> {
                recyclerView.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
            }
        }
    }
}
