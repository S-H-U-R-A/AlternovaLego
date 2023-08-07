package com.alternova.lego.domain.useCases.login

import com.alternova.lego.data.repository.login.LoginRepository
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class SignInUserUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(email: String, password:String) : FirebaseUser? {
        return loginRepository.signInUser(email,password)
    }

}