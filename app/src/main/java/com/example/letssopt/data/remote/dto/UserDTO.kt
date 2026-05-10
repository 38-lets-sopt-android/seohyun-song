package com.example.letssopt.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetUserResponse(
    @SerialName("success")
    val success: Boolean,
    @SerialName("status")
    val status: Int,
    @SerialName("message")
    val message: String,
    @SerialName("code")
    val code: String,
    @SerialName("data")
    val data: UserData,
    @SerialName("meta")
    val meta: MetaData? = null
)

@Serializable
data class UserData(
    @SerialName("id")
    val id: Int,
    @SerialName("loginId")
    val loginId: String,
    @SerialName("name")
    val name: String,
    @SerialName("email")
    val email: String,
    @SerialName("age")
    val age: Int,
    @SerialName("part")
    val part: String
)

@Serializable
data class MetaData(
    @SerialName("path")
    val path: String,
    @SerialName("timestamp")
    val timestamp: String
)