package com.example.data.repository.findidpassword.datasource

import com.example.data.base.BaseDataSource
import com.example.data.base.BaseResponse
import com.example.data.entity.findpassword.request.PasswordChangeRequest
import com.example.data.entity.findpassword.request.PasswordMailRequest
import com.example.data.entity.findpassword.response.PasswordChangeResponse
import com.example.data.entity.findpassword.response.PasswordMailCodeResponse
import com.example.data.network.service.FindIdPasswordService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class FindPasswordDataSourceImpl @Inject constructor(
    override val service: FindIdPasswordService

) : BaseDataSource<FindIdPasswordService>(),
    FindPasswordDataSource{

    override suspend fun postPassword(request: PasswordMailRequest): Single<BaseResponse>
    {
        return service.postMailAndUserName(request)
    }


    override suspend fun getCode(code : String): Single<PasswordMailCodeResponse>
            = service.getMailCode(code)

    override suspend fun putChangePassword(request: PasswordChangeRequest): Single<PasswordChangeResponse>
            = service.putPasswordChange(request)
}