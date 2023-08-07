package com.alternova.lego.ui.home.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.alternova.lego.R
import com.alternova.lego.databinding.FragmentProductsBinding
import com.alternova.lego.domain.model.ProductDomain
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsFragment : Fragment() {

    private var _binding: FragmentProductsBinding? = null
    private val binding: FragmentProductsBinding get() = _binding!!

    private val viewModel: ProductsViewModel by viewModels()

    //ADAPTER
    private lateinit var productAdapter: ProductsListAdapter

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProductsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initComponents()
        initObservers()

    }

    private fun initComponents() {
        //VALIDATE SESSION ACTIVE
        viewModel.getCurrentSession()
        viewModel.getAllProducts()

        //SET ADAPTER
        productAdapter = ProductsListAdapter()
        binding.rvProducts.adapter = productAdapter

    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState.collect{ uiState ->
                    handleSessionNavigation( uiState.isCurrentSessionActive )
                    handleProductList( uiState.productsList )
                }
            }
        }
    }

    private fun handleProductList(productsList: List<ProductDomain>) {
        productAdapter.submitList(productsList)
    }

    private fun handleSessionNavigation(currentSessionActive: Boolean) {
        if(!currentSessionActive){
            findNavController().navigate(R.id.signInFragment)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}