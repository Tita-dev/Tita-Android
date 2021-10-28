package com.example.tita.di

import com.example.data.repository.findidpassword.repository.FindPasswordRepositoryImpl
import com.example.data.repository.findidpassword.datasource.FindPasswordDataSource
import com.example.data.repository.findidpassword.datasource.FindPasswordDataSourceImpl
import com.example.domain.repository.AuthRepository
import com.example.data.repository.login.datasource.LoginDataSourceImpl
import com.example.data.repository.login.repository.LoginRepositoryImpl
import com.example.domain.repository.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(authDataSourceImpl: FindPasswordDataSourceImpl): AuthRepository {
        return FindPasswordRepositoryImpl(authDataSourceImpl)
    }
    @Provides
    @Singleton
   fun provideLoginRepository(loginDataSourceImpl: LoginDataSourceImpl) : LoginRepository{
    return LoginRepositoryImpl(loginDataSourceImpl)
   }

}