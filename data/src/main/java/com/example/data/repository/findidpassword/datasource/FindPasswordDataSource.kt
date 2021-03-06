package com.example.data.repository.findidpassword.datasource

import com.example.data.base.FindIdPasswordBaseResponse
import com.example.data.base.SignUpBaseResponse
import com.example.data.entity.findpassword.request.PasswordChangeRequest
import com.example.data.entity.findpassword.request.PasswordMailRequest
import com.example.data.entity.findpassword.response.PasswordChangeResponse
import com.example.data.entity.findpassword.response.PasswordMailCodeResponse
import io.reactivex.rxjava3.core.Single

interface FindPasswordDataSource{
    suspend fun postPassword(request: PasswordMailRequest) : Single<FindIdPasswordBaseResponse>
    suspend fun getCode(code : String) : Single<PasswordMailCodeResponse>
    suspend fun putChangePassword(request: PasswordChangeRequest) : Single<PasswordChangeResponse>
}