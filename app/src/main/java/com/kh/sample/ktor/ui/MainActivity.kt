package com.kh.sample.ktor.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kh.sample.ktor.R
import com.kh.sample.ktor.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.loadUseList()
        viewModel.profileUser.observe(this) {
            binding.flipState.displayedChild = 1
            binding.name.text = "Name: ${it.name}"
            binding.mail.text = "Email: ${it.email}"
            binding.status.text = "Status: ${it.status}"
        }

        viewModel.error.observe(this){
            binding.flipState.displayedChild = 2
            binding.error.text = it.message
        }
    }
}