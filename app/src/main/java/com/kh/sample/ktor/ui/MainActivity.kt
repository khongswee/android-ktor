package com.kh.sample.ktor.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kh.sample.ktor.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel : MainActivityViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.loadUseList()
    }
}