package com.dgcash.products.core.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>() : RecyclerView.Adapter<BaseAdapter<T>.BaseViewHolder>() {

    abstract override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseAdapter<T>.BaseViewHolder

    override fun onBindViewHolder(holder: BaseAdapter<T>.BaseViewHolder, position: Int) {
        val currentItem = getItemForPosition(position)
        holder.bind(currentItem)
    }

    abstract override fun getItemCount(): Int

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    abstract fun getItemForPosition(position: Int): T

    abstract fun getLayoutIdForPosition(position: Int): Int

    abstract inner class BaseViewHolder(binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        abstract fun bind(item: T)
    }
}
