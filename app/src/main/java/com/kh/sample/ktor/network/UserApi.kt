package com.kh.sample.ktor.network

import com.kh.sample.ktor.model.UserResponse

interface UserApi {
    suspend fun getUser(page: String = "1"): UserResponse
}