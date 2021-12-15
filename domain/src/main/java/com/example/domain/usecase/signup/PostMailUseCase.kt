package com.example.domain.usecase.signup

import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.signup.GetMailEntity
import com.example.domain.repository.SignUpRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PostMailUseCase @Inject constructor(private val repository: SignUpRepository):
    ParamsUseCase<PostMailUseCase.Params, Single<GetMailEntity>>() {


    override suspend fun buildUseCaseObservable(params: Params): Single<GetMailEntity> {
        return repository.getMail(params.mail)
    }
    data class Params(
        val mail: String
    )

}