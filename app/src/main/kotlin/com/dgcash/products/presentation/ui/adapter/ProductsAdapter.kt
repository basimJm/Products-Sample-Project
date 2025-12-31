package com.dgcash.products.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dgcash.products.databinding.ProductRowItemBinding
import com.dgcash.products.domain.entity.ProductItemModel
import com.dgcash.products.presentation.utils.ProductEvents

class ProductsAdapter(
    private val products: List<ProductItemModel>,
    private val productEvents: ProductEvents
) :
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
        val currentProduct = products[position]
        holder.bind(currentProduct)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    inner class ProductsViewHolder(private val binding: ProductRowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductItemModel) {
            binding.product = product

            binding.root.setOnClickListener {
                productEvents.onProductClicked(product.id.toString())
            }

            binding.executePendingBindings()
        }
    }
}