package com.mvvmexercises.simple_mvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mvvmexercises.databinding.ActivitySimpleMvvmBinding
import com.mvvmexercises.simple_mvvm.viewmodels.UserViewModel
import kotlin.random.Random

class SimpleMvvmActivity : AppCompatActivity() {

    lateinit var binding: ActivitySimpleMvvmBinding
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize ViewModel
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // Observe changes in userName and update the UI
        userViewModel.username.observe(this, { newName -> binding.usernameTv.text = newName })

        // Button click to update user's name
        binding.updateBtn.setOnClickListener {
            val newName = "user_${Random.nextInt(1,100)}"
            userViewModel.updateUsername(newName)
        }
    }
}