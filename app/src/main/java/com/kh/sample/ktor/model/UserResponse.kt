package com.kh.sample.ktor.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val data: DataUser
)

@Serializable
data class DataUser(
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String,
)