package com.mvvmexercises.simple_mvvm.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    val username = MutableLiveData<String>()

    init {
        username.value = "Mohd"
    }

    fun updateUsername(newName: String) {
        username.value = newName
    }
}