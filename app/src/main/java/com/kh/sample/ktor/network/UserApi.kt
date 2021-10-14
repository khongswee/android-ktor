package com.kh.sample.ktor.network

import com.kh.sample.ktor.model.UserResponse

interface UserApi {
    suspend fun getUser(users: String): UserResponse
}