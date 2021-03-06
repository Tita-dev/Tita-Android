package com.example.tita.di


import com.example.data.network.service.*
import com.example.data.util.ApiClient.BASE_USER_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
// Singleton, Provides 쓸때 private 말고 public 으로 해야한다.
object NetworkModule {

    const val SCHOOL_BASE_URL = "https://open.neis.go.kr/"

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            //서버로부터의 응답까지의 시간이 읽기 시간 초과보다 크면 요청 실패로 판단한다.
            .readTimeout(10, TimeUnit.SECONDS)
            //서버로 요청을 시작한 후 15초가 지날 때 까지 데이터가 안오면 에러로 판단한다.
            .connectTimeout(10, TimeUnit.SECONDS)
            // 얼마나 빨리 서버로 데이터를 받을 수 있는지 판단한다.
            .writeTimeout(15, TimeUnit.SECONDS)
            .// 이 클라이언트를 통해 오고 가는 네트워크 요청/응답을 로그로 표시하도록 합니다.
            addInterceptor(getLoggingInterceptor())
            .build()

    }

    @Named("main")
    @Singleton
    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_USER_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            //json 변화기 Factory
            .client(provideHttpClient())
            .addConverterFactory(gsonConverterFactory)
            .build()

    }

    @Named("school")
    @Singleton
    @Provides
    fun provideSchoolRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(SCHOOL_BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            //json 변화기 Factory
            .client(provideHttpClient())
            .addConverterFactory(gsonConverterFactory)
            .build()

    }

    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideApiService(@Named("main") retrofit: Retrofit): SignUpService {
        return (retrofit.create(SignUpService::class.java))
    }
    @Provides
    @Singleton
    fun provideFindIdService(@Named("main") retrofit: Retrofit): FindIdPasswordService {
        return (retrofit.create(FindIdPasswordService::class.java))
    }

    @Provides
    @Singleton
    fun provideLoginService(@Named("main") retrofit: Retrofit): LoginService {
        return (retrofit.create(LoginService::class.java))
    }


    @Provides
    @Singleton
    fun provideSchoolApiService(@Named("school") retrofit: Retrofit): SchoolService {
        return (retrofit.create(SchoolService::class.java))
    }


    @Provides
    @Singleton
    fun provideBoardService(@Named("main")retrofit: Retrofit): BoardService {
        return (retrofit.create(BoardService::class.java))
    }

    // 서버로 부터 받아온 데이터 log 찍기
    private fun getLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }


}

