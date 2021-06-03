package com.example.practice1.API

import com.example.practice1.model.Post
import com.example.practice1.model.Users
import com.example.practice1.model.UsersItem
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {
    @GET("users/nilaymaru")
    suspend fun getPost(): Response<Post>

    @GET("users")
    suspend fun getUser(): Response<List<UsersItem>>
}