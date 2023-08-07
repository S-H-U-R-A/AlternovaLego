package com.alternova.lego.ui.login.signIn

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alternova.lego.core.enums.UserMessages
import com.alternova.lego.domain.useCases.login.SignInUserUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUserUseCase: SignInUserUseCase
) : ViewModel() {

    //STATE OBSERVER FROM UI
    private var _uiState: MutableStateFlow<SignInUiState> = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> get() = _uiState.asStateFlow()

    fun signInUser(email: String, passWord: String, action: () -> Unit){
        viewModelScope.launch {
            val user: FirebaseUser? = signInUserUseCase(email, passWord)
            if(user!=null){
                action()
            }else{
                sendMessageUser(UserMessages.USER_NOT_VALID_LOGIN.code, "Usuario o contraseña incorrecta" )
            }
        }
    }

    fun sendMessageUser(code: Int, message: String){
        _uiState.update { actualState: SignInUiState ->
            //CREATE MESSAGE TO USER
            val messageUser: Map<Int, String> = mutableMapOf(code to message)
            //ADD MESSAGE THE LIST
            val messageError: List<Map<Int, String>> = actualState.messagesUser + messageUser
            //UPDATE STATE
            actualState.copy(
                messagesUser = messageError
            )
        }
    }

    fun deleteMessageUser(code: Int){
        _uiState.update { actualState ->
            val newListWithOutMessage =
                actualState.messagesUser.filterNot {
                    it.containsKey(code)
                }
            actualState.copy(
                messagesUser = newListWithOutMessage
            )
        }
    }

}

data class SignInUiState(
    val isLoading: Boolean = false,
    val messagesUser: List<Map<Int, String>> = emptyList()
)