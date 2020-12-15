package com.example.techrepairs.techlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class TechListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TechListViewModel::class.java)) {
            return TechListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}