package com.dgcash.products.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dgcash.products.R
import com.dgcash.products.core.base.BaseAdapter
import com.dgcash.products.databinding.ProductRowItemBinding
import com.dgcash.products.domain.entity.ProductItemModel
import com.dgcash.products.presentation.utils.ProductEvents

class ProductsAdapter(
    private val products: List<ProductItemModel>,
    private val productEvents: ProductEvents
) : BaseAdapter<ProductItemModel>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseAdapter<ProductItemModel>.BaseViewHolder {
        val binding = ProductRowItemBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return ProductsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun getItemForPosition(position: Int): ProductItemModel {
        return products[position]
    }

    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.product_row_item
    }

    inner class ProductsViewHolder(private val binding: ProductRowItemBinding) :
        BaseViewHolder(binding) {

        override fun bind(item: ProductItemModel) {
            binding.product = item

            binding.root.setOnClickListener {
                productEvents.onProductClicked(item.id.toString())
            }

            binding.executePendingBindings()
        }
    }
}