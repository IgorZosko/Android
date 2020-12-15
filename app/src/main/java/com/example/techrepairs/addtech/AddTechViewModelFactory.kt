package com.example.techrepairs.addtech

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class AddTechViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel ?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddTechViewModel::class.java)) {
            return AddTechViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}