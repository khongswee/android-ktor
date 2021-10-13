package com.kh.sample.ktor.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kh.sample.ktor.usecase.APIResult
import com.kh.sample.ktor.usecase.GetUseListUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel(private val getUseListUseCase: GetUseListUseCase) : ViewModel() {
    fun loadUseList() {
        viewModelScope.launch {
            val result = getUseListUseCase("1")
            when (result) {
                is APIResult.Success -> {
                    Log.d("ViewModel", result.data.data.toString())
                }
                is APIResult.Error -> {
                    Log.d("ViewModel", result.exception.message ?: "error")
                }
            }
        }
    }
}