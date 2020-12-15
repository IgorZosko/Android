package com.example.techrepairs.techdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class TechDetailsViewModel : ViewModel() {

    private val _techName = MutableLiveData<String>()
    val techName : LiveData<String>
        get() = _techName

    private val _techModel  = MutableLiveData<String>()
    val techModel : LiveData<String>
        get() = _techModel

    private val _techDescribe = MutableLiveData<String>()
    val techDescribe : LiveData<String>
        get() = _techDescribe

    private val _techPrice = MutableLiveData<String>()
    val techPrice : LiveData<String>
        get() = _techPrice

    init {
        Timber.i("TechDetailsViewModel Created");
        _techName.value = "Iphone"
        _techModel.value = "XS Max"
        _techDescribe.value = "Тріснув екран"
        _techPrice.value = "150 грн"
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("TechDetailsViewModel destroyed");
    }
}