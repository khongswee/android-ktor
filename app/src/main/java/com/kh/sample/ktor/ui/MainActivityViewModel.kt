package com.kh.sample.ktor.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kh.sample.ktor.model.DataUser
import com.kh.sample.ktor.usecase.APIResult
import com.kh.sample.ktor.usecase.GetUseListUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel(private val getUseListUseCase: GetUseListUseCase) : ViewModel() {

    private val _profileUser : MutableLiveData<DataUser> = MutableLiveData()
    val profileUser : LiveData<DataUser> get() = _profileUser

    private val _error : MutableLiveData<Throwable> = MutableLiveData()
    val error : LiveData<Throwable> get() = _error

    fun loadUseList() {
        viewModelScope.launch {
            val result = getUseListUseCase("9")
            when (result) {
                is APIResult.Success -> {
                    Log.d("ViewModel", result.data.data.toString())
                    _profileUser.postValue(result.data.data)
                }
                is APIResult.Error -> {
                    Log.d("ViewModel", result.exception.message ?: "error")
                    _error.postValue(result.exception)
                }
            }
        }
    }
}