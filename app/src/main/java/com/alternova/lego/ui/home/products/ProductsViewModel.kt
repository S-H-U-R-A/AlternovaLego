package com.alternova.lego.ui.home.products

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alternova.lego.domain.model.ResponseLegoDomain
import com.alternova.lego.domain.model.ProductDomain
import com.alternova.lego.domain.useCases.login.GetCurrentSessionUseCase
import com.alternova.lego.domain.useCases.products.GetAllProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getCurrentSessionUseCase: GetCurrentSessionUseCase,
    private val getAllProductsUseCase: GetAllProductsUseCase
) : ViewModel(){

    private var _uiState: MutableStateFlow<ProductsUiState> = MutableStateFlow(ProductsUiState())
    val uiState: StateFlow<ProductsUiState> = _uiState.asStateFlow()

    fun getCurrentSession(){
        viewModelScope.launch {
            val isCurrentSession: Boolean = getCurrentSessionUseCase()
            _uiState.update { uiActualState ->
                uiActualState.copy(
                    isCurrentSessionActive = isCurrentSession
                )
            }
        }
    }

    fun getAllProducts(){
        viewModelScope.launch {
            getAllProductsUseCase().collect{ listProducts: ResponseLegoDomain ->
                _uiState.update { uiState ->
                    uiState.copy(
                        productsList = listProducts.products
                    )
                }
            }
        }
    }

}

data class ProductsUiState(
    val isLoading: Boolean = false,
    val isCurrentSessionActive: Boolean = true,
    val productsList: List<ProductDomain> = emptyList()
)