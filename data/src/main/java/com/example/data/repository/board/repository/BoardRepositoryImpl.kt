package com.example.data.repository.board.repository

import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.data.repository.board.datasource.BoardDataSource
import com.example.data.repository.findidpassword.datasource.FindPasswordDataSource
import com.example.domain.entity.BoardEntity
import com.example.domain.entity.BoardFreePost
import com.example.domain.entity.BoardFreePostEntity
import com.example.domain.repository.BoardRepository
import com.example.domain.repository.FindIdAndPasswordRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class BoardRepositoryImpl  @Inject constructor(
    private val dataSourceImpl: BoardDataSource
    ) : BoardRepository{

    override suspend fun getPost(postLocation: String): Single<BoardEntity> {
        return dataSourceImpl.getPost(postLocation).map { it.toDomain() }
    }

    override suspend fun boardFreePost(
        boardLocation: String,
        boardFreePostRequest: BoardFreePostEntity
    ): Single<BoardFreePost> {
        return dataSourceImpl.boardFreePost(boardLocation,boardFreePostRequest.toEntity()).map { it.toDomain() }
    }
}