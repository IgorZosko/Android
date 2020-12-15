package com.example.roomapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomapp.data.ClientDao
import com.example.roomapp.repository.ClientRepository
import com.example.roomapp.model.Client
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClientViewModel(val database: ClientDao, application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Client>>
    private val repository: ClientRepository

    init {
        repository = ClientRepository(database)
        readAllData = repository.readAllData
    }

    fun addClients(client: Client){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addClients(client)
        }
    }

    fun updateClients(client: Client){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateClients(client)
        }
    }

    fun deleteClients(client: Client){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteClients(client)
        }
    }

    fun deleteAllClients(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllClients()
        }
    }

}