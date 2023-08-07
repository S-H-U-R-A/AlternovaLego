package com.alternova.lego.domain.useCases.login

import com.alternova.lego.domain.repository.login.LoginRepository
import com.alternova.lego.domain.model.UserDomain
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(
    private val loginRepository: LoginRepository
){
    suspend operator fun invoke(user: UserDomain) = loginRepository.insertUser(user)
}