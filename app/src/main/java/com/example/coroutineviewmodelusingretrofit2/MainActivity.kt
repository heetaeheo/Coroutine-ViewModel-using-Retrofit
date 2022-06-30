package com.example.coroutineviewmodelusingretrofit2

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.coroutineviewmodelusingretrofit2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageView = binding.imageView
        initViewModel(imageView)
    }

    private fun initViewModel(imageView: ImageView) {


        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.getImageObserver().observe(this, Observer<Bitmap>{
            imageView.setImageBitmap(it)
        })
        viewModel.makeApiCall("4")
    }
}