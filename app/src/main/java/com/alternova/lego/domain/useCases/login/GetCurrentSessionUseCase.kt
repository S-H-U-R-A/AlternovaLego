package com.alternova.lego.domain.useCases.login

import com.alternova.lego.domain.repository.login.LoginRepository
import javax.inject.Inject

class GetCurrentSessionUseCase @Inject constructor(
    private val loginRepository: LoginRepository
){
    suspend operator fun invoke() : Boolean = loginRepository.isCurrentSession()
}