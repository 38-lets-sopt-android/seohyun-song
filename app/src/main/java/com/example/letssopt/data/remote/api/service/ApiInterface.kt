package com.example.letssopt.data.remote.api.service

import com.example.letssopt.data.remote.dto.GetUserResponse
import com.example.letssopt.data.remote.dto.LoginRequest
import com.example.letssopt.data.remote.dto.LoginResponse
import com.example.letssopt.data.remote.dto.SignUpRequest
import com.example.letssopt.data.remote.dto.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @POST("api/v1/auth/signup")
    suspend fun signUp(@Body request: SignUpRequest): Response<SignUpResponse>

    @POST("api/v1/auth/signin")
    suspend fun signIn(@Body request: LoginRequest): Response<LoginResponse>

    @GET("/api/v1/users/{userId}")
    suspend fun getUser(
        @Path("userId") userId: Int
    ): GetUserResponse
}