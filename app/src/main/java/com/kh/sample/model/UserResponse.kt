package com.kh.sample.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val code: Int,
    val data: List<DataUser>,
    val meta: Meta
)

@Serializable
data class DataUser(
    val email: String,
    val gender: String,
    val id: Int,
    val name: String,
    val status: String,
)

@Serializable
data class Meta(
    val pagination: Pagination
)

@Serializable
data class Pagination(
    val limit: Int,
    val page: Int,
    val pages: Int,
    val total: Int
)