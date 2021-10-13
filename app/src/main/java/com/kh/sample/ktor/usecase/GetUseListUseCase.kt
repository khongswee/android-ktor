package com.kh.sample.ktor.usecase

import com.kh.sample.ktor.model.UserResponse
import com.kh.sample.ktor.network.UserApi
import kotlinx.coroutines.CoroutineDispatcher

class GetUseListUseCase(ioDispatcher: CoroutineDispatcher, private val userApi: UserApi) :
    CoroutineUseCase<String, UserResponse>(ioDispatcher) {
    override suspend fun execute(parameters: String): UserResponse {
        return userApi.getUser(parameters)
    }
}