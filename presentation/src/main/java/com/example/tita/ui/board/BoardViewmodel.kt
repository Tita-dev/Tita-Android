package com.example.tita.ui.board

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.BoardEntity
import com.example.domain.usecase.GetBoardPostUseCase
import com.example.domain.usecase.PostMailUseCase
import com.example.tita.base.BaseViewModel
import com.example.tita.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

@HiltViewModel
class BoardViewmodel @Inject constructor(
    private val getPostUserCase: GetBoardPostUseCase
) : BaseViewModel(){

    val TAG : String = "baord"

    private val _boardData = MutableLiveData<List<Any>>()
    val password: LiveData<List<Any>> get() = _boardData

    private val _isSuccess = MutableLiveData<Event<String>>()
    val isSuccess: LiveData<Event<String>> = _isSuccess

    private val _isFailure = MutableLiveData<Event<String>>()
    val isFailure: LiveData<Event<String>> = _isFailure

    suspend fun getPost(postLocation : String) {

        try {
            getPostUserCase.buildUseCaseObservable(GetBoardPostUseCase.Params(postLocation))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                     _boardData.value =  data.data

                    Log.d("cocopam",_boardData.value.toString())

                    _isSuccess.value = Event(data.msg)
                }, {
                    _isFailure.value = Event(it.message ?: "")
                })
        } catch (e: Exception) {
            _isFailure.value = Event(e.toString())
        }
    }

}