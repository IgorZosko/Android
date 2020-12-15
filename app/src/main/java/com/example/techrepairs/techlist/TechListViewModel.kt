package com.example.techrepairs.techlist

import androidx.lifecycle.ViewModel
import timber.log.Timber

class TechListViewModel : ViewModel() {

    var tech = arrayOf( "Nokia 3310", "Xiaomi MI A3", "Iphone X", "Huawei P 30 Pro", "Nokia 3330" );

    init {
        Timber.i("TechListViewModel");
    }

    override fun onCleared() {
        super.onCleared()
        Timber.i("TechListViewModel destroyed");
    }
}