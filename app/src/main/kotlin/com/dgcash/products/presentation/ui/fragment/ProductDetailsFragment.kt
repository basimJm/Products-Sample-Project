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
import com.dgcash.products.R
import com.dgcash.products.databinding.FragmentProductDetailsBinding
import com.dgcash.products.presentation.ui.vm.ProductDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding
    private val viewModel: ProductDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.product.collectLatest { product ->
                if (product != null) {
                    binding.product = product
                }

                viewModel.isLoading.collectLatest { isLoading ->
                    updateVisibility(isLoading)
                }
            }
        }
    }

    private fun updateVisibility(isLoading: Boolean) {
        binding.pbLoading.isVisible = isLoading
        binding.clContent.isVisible = !isLoading
    }
}