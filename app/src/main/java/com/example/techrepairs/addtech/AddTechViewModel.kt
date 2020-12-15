package com.example.techrepairs.addtech

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class AddTechViewModel : ViewModel() {

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
        _techName.value = ""
        _techModel.value = ""
        _techDescribe.value = ""
        _techPrice.value = ""
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("AddTechViewModel destroyed");
    }
}