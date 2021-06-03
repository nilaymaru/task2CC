package com.example.practice1.Repository

import com.example.practice1.API.RetrofitInstance
import com.example.practice1.model.Post
import com.example.practice1.model.Users
import com.example.practice1.model.UsersItem
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
    suspend fun getUsers(): Response<List<UsersItem>> {
        return RetrofitInstance.api.getUser()
    }
}