package com.example.amazonclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonclone.adapter.EssentialAdapter
import com.example.amazonclone.model.Essential

class MainActivity : AppCompatActivity() {
    lateinit var rv_essential: RecyclerView
    lateinit var ll_fashion: LinearLayout
    lateinit var ll_popular: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        ll_fashion = findViewById(R.id.ll_fashion)
        ll_popular = findViewById(R.id.ll_popular)
        rv_essential = findViewById(R.id.rv_essential)
        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_essential.setLayoutManager(manager)

        refreshAdapter(getEssential())
        setLinearHeight(ll_popular)
        setLinearHeight(ll_fashion)
    }

    private fun setLinearHeight(layout: LinearLayout) {
         val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        var widthPixel = displayMetrics.widthPixels

        val params: ViewGroup.LayoutParams = layout.layoutParams
        params.height = widthPixel
        layout.layoutParams = params
    }

    private fun refreshAdapter(items: ArrayList<Essential>) {
        val adapter = EssentialAdapter(this, items)
        rv_essential!!.adapter = adapter
    }

    fun getEssential(): ArrayList<Essential>{
        val items: ArrayList<Essential> = ArrayList<Essential>()

        items.add(Essential("Oculus", R.drawable.oculus))
        items.add(Essential("Mobile", R.drawable.mobile))
        items.add(Essential("Gamer", R.drawable.gamer))
        items.add(Essential("Reading", R.drawable.book))
        items.add(Essential("Sport", R.drawable.sport))
        items.add(Essential("Home", R.drawable.home))

        return items
    }
}