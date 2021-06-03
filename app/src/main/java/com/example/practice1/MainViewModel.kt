package com.example.practice1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practice1.Repository.Repository
import com.example.practice1.model.Post
import com.example.practice1.model.Users
import com.example.practice1.model.UsersItem
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myUsers: MutableLiveData<Response<List<UsersItem>>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }
    fun getUsers(){
        viewModelScope.launch {
            val response = repository.getUsers()
            myUsers.value = response
        }
    }
}