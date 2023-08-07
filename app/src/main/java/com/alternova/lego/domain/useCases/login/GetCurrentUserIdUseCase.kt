package com.alternova.lego.domain.useCases.login

import com.alternova.lego.domain.repository.login.LoginRepository
import javax.inject.Inject

class GetCurrentUserIdUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke() : String? = loginRepository.getCurrentUserId()

}