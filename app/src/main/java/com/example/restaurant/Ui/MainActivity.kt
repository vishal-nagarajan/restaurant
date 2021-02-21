package com.example.restaurant.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.restaurant.R
import com.example.restaurant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    private lateinit var  binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding= ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
    supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        val navController = Navigation.findNavController(this,R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
}