package com.mvvmexercises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mvvmexercises.databinding.ActivityMainBinding
import com.mvvmexercises.mvvm_for_network.ui.RetrofitWithMvvmActivity
import com.mvvmexercises.simple_mvvm.ui.SimpleMvvmActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.simpleMvvmBtn.setOnClickListener {
            val intent = Intent(this, SimpleMvvmActivity::class.java)
            startActivity(intent)
        }

        binding.networkMvvmBtn.setOnClickListener {
            val intent = Intent(this, RetrofitWithMvvmActivity::class.java)
            startActivity(intent)
        }
    }
}