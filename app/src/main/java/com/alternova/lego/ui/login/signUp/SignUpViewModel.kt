package com.alternova.lego.ui.login.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alternova.lego.core.enums.UserMessages
import com.alternova.lego.domain.model.UserDomain
import com.alternova.lego.domain.useCases.login.InsertUserUseCase
import com.alternova.lego.domain.useCases.login.SignUpUserUseCase
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUserUseCase: SignUpUserUseCase,
    private val insertUserUseCase: InsertUserUseCase
) : ViewModel() {

    //STATE OBSERVER FROM UI
    private var _uiState: MutableStateFlow<SignUpUiState> = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> get() = _uiState.asStateFlow()

    fun signUpUser(email: String, passWord: String, action: () -> Unit){
        viewModelScope.launch {
            val user: FirebaseUser? = signUpUserUseCase(email, passWord)
            if(user!=null){
                insertDataBaseUser( user.uid, user.email!!, passWord)
                action()
            }else{
                sendMessageUser(UserMessages.USER_NOT_VALID_LOGIN.code, "Usuario o contraseña incorrecta" )
            }
        }
    }

    fun sendMessageUser(code: Int, message: String){
        _uiState.update { actualState: SignUpUiState ->
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

    private suspend fun insertDataBaseUser(id:String, email: String, passWord: String){
        val user: UserDomain = UserDomain( id, email, passWord )
        insertUserUseCase(user)
    }

}

data class SignUpUiState(
    val isLoading: Boolean = false,
    val messagesUser: List<Map<Int, String>> = emptyList()
)