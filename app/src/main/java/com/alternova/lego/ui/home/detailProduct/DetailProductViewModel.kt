package com.alternova.lego.ui.home.detailProduct

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alternova.lego.domain.model.ProductDomain
import com.alternova.lego.domain.model.ShoppingCarDomain
import com.alternova.lego.domain.useCases.login.GetCurrentUserIdUseCase
import com.alternova.lego.domain.useCases.products.AddProductToCarUseCase
import com.alternova.lego.domain.useCases.products.GetProductByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailProductViewModel @Inject constructor(
    private val getProductByIdUseCase: GetProductByIdUseCase,
    private val getCurrentUserIdUseCase: GetCurrentUserIdUseCase,
    private val addProductToCarUseCase: AddProductToCarUseCase
) : ViewModel(){

    private var _uiState: MutableStateFlow<DetailProductUiState> = MutableStateFlow(DetailProductUiState())
    val uiState: StateFlow<DetailProductUiState> = _uiState.asStateFlow()

    fun getAllProducts(id: Int){
        viewModelScope.launch {
            getProductByIdUseCase(id).collect{ product ->
                _uiState.update { uiState ->
                    uiState.copy(
                        product = product
                    )
                }
            }
        }
    }

    fun addProductToCar(product: ProductDomain, action: () ->Unit ){
        viewModelScope.launch {
            val idUser:String? = getCurrentUserIdUseCase()
            idUser?.let {
                val productShoppingCar = ShoppingCarDomain(
                    product.id,
                    product.name,
                    product.unitPrice,
                    product.stock,
                    product.image,
                    it
                )
                addProductToCarUseCase(productShoppingCar)
                action()
            }
        }
    }


}

data class DetailProductUiState(
    val isLoading: Boolean = false,
    val product: ProductDomain? = null
)