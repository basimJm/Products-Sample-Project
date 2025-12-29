package com.dgcash.products.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dgcash.products.databinding.FragmentProductsBinding
import com.dgcash.products.databinding.ProductRowItemBinding
import com.dgcash.products.domain.entity.ProductItemModel

class ProductsAdapter(private val products: List<ProductItemModel>) :
    RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {

    lateinit var binding: ProductRowItemBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductsViewHolder {
        binding =
            ProductRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ProductsViewHolder,
        position: Int
    ) {
        binding.product = products[position]
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ProductsViewHolder(binding: ProductRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}