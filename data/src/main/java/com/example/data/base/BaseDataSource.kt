package com.example.data.base


// RE에 remote를 넣어준다.
abstract class BaseDataSource<RE> {
    abstract val service: RE
}