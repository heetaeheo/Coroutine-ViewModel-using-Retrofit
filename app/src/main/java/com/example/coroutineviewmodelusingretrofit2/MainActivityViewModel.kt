package com.example.coroutineviewmodelusingretrofit2

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutineviewmodelusingretrofit2.network.RetroInstance
import com.example.coroutineviewmodelusingretrofit2.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    lateinit var ImageLiveData : MutableLiveData<Bitmap>

    init {
        ImageLiveData = MutableLiveData()
    }

    fun getImageObserver() : MutableLiveData<Bitmap>{
        return ImageLiveData
    }

    fun makeApiCall(query: String) {
        viewModelScope.launch(Dispatchers.IO){
            val retroInstance = RetroInstance.getRetroInstace().create(RetroService::class.java)
            val response = retroInstance.getImageFromUrl(query)
            val bytes = response.bytes()
            val bitmap =  BitmapFactory.decodeByteArray(bytes,0,bytes.size)
            ImageLiveData.postValue(bitmap)
        }
    }
}