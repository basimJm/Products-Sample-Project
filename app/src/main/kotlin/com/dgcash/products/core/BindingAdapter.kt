package com.dgcash.products.core

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter(CoreConstants.IMAGE_LOADER)
fun imageLoader(view: ImageView, url: String?) {
    url?.let { view.load(it) }
}


@BindingAdapter(CoreConstants.PRICE_TEXT)
fun priceText(view: TextView, price: Double?) {
    price?.let {
        val price = "$ $it"
        view.text = price
    }
}