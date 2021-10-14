package com.kh.sample.ktor.network

import com.kh.sample.ktor.model.UserResponse
import com.kh.sample.ktor.network.HttpRoute.GET_USER
import io.ktor.client.*
import io.ktor.client.request.*

class UserImpl(private val client: HttpClient) : UserApi {
    override suspend fun getUser(user: String): UserResponse {
        return client.get { url("${GET_USER}${user}") }
    }
    companion object {
        fun create(): UserApi {
            return UserImpl(RemoteClient.ktorHttpClient)
        }
    }
}