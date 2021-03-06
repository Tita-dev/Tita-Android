package com.example.domain.usecase

import android.util.Log
import com.example.domain.base.ParamsUseCase
import com.example.domain.entity.PostPasswordMailEntity
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.FindIdAndPasswordRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PostPasswordUseCase @Inject constructor(private val repository: FindIdAndPasswordRepository) :
    ParamsUseCase<PostPasswordUseCase.Params, Single<PostPasswordMailEntity>>() {

    override suspend fun buildUseCaseObservable(params: Params): Single<PostPasswordMailEntity> {
        return repository.postPasswordEmail(
            username = params.username,
            email = params.email
        )
    }

    data class Params(
        val username: String,
        val email: String
    )


}