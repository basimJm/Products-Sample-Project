package com.dgcash.products.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.dgcash.products.R
import com.dgcash.products.databinding.FragmentProductsBinding
import com.dgcash.products.presentation.ui.adapter.ProductsAdapter
import com.dgcash.products.presentation.ui.vm.ProductsViewModel
import com.dgcash.products.presentation.utils.Constants
import com.dgcash.products.presentation.utils.ProductEvents
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsFragment : Fragment(), ProductEvents {

    private lateinit var binding: FragmentProductsBinding
    private lateinit var productsAdapter: ProductsAdapter
    private val viewModel: ProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_products, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.productList.collectLatest { products ->
                if (products.isNotEmpty()) {
                    productsAdapter = ProductsAdapter(products, this@ProductsFragment)
                    binding.rvProducts.adapter = productsAdapter
                }

                viewModel.isLoading.collectLatest { isLoading ->
                    binding.pbLoading.isVisible = isLoading
                }
            }
        }
    }

    override fun onProductClicked(id: String) {
        val bundle = Bundle()
        bundle.putString(Constants.PRODUCT_ID, id)

        val productDetailsFragment = ProductDetailsFragment()
        productDetailsFragment.arguments = bundle

        findNavController().navigate(R.id.productDetailsFragment, bundle)
    }
}