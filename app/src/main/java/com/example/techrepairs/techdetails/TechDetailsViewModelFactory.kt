package com.example.techrepairs.techdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class TechDetailsViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TechDetailsViewModel::class.java)) {
            return TechDetailsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}