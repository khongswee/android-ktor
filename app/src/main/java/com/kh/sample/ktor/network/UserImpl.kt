package com.kh.sample.ktor.network

import com.kh.sample.ktor.model.UserResponse
import io.ktor.client.*
import io.ktor.client.request.*

class UserImpl(private val client: HttpClient) : UserApi {
    override suspend fun getUser(page: String): UserResponse {
        return client.get { url("") }
    }
    companion object {
        fun create(): UserApi {
            return UserImpl(RemoteClient.ktorHttpClient)
        }
    }
}