package com.example.letssopt.data.remote.api.service

import com.example.letssopt.data.remote.dto.GetUserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("api/v1/users/{userId}")
    suspend fun getUser(
        @Path("userId") userId: Int
    ): GetUserResponse
}