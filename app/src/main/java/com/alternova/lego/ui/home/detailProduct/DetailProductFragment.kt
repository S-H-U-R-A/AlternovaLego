package com.alternova.lego.ui.home.detailProduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.alternova.lego.databinding.FragmentDetailProductBinding
import com.alternova.lego.domain.model.ProductDomain
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class DetailProductFragment : Fragment() {

    private var _binding: FragmentDetailProductBinding? = null
    private val binding: FragmentDetailProductBinding get() = _binding!!

    private val args by navArgs<DetailProductFragmentArgs>()

    private val viewModel: DetailProductViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        _binding = FragmentDetailProductBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
        initObservers()

    }

    private fun initComponents() {
        viewModel.getAllProducts(args.idProduct)
    }

    private fun initObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiState.collect{ uiState ->
                    handleDataProduct( uiState.product )
                }
            }
        }
    }

    private fun handleDataProduct(product: ProductDomain?) {
        product?.let {
            with(binding){
                mtvTitle.text = it.name
                Glide.with(requireContext())
                    .load( it.image )
                    .into( binding.ivProduct )
                mtvUnitPrice.text = "$ ${ it.unitPrice } "
                mtvStock.text = it.stock.toString()
                mtvDescription.text = it.description

                binding.clContent.isVisible = true

                binding.btnAddCar.setOnClickListener {
                    viewModel.addProductToCar(product){
                        Toast.makeText(requireContext(), "Se ha añadido el producto con éxito", Toast.LENGTH_LONG).show()
                        val action: NavDirections = DetailProductFragmentDirections.actionDetailProductFragmentToProductsFragment()
                        findNavController().navigate(action)
                    }
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}