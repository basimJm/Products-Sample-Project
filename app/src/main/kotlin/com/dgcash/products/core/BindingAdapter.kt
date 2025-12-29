package com.dgcash.products.core

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load


@BindingAdapter("imageLoader")
fun imageLoader(view: ImageView, url: String) {
    view.load(url)
}


@BindingAdapter("priceText")
fun priceText(view: TextView, price: Double) {
    val price = "$$price"
    view.text = price
}

