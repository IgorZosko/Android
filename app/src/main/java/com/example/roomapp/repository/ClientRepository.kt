package com.example.roomapp.repository

import androidx.lifecycle.LiveData
import com.example.roomapp.data.ClientDao
import com.example.roomapp.model.Client

class ClientRepository(private val clientDao: ClientDao) {

    val readAllData: LiveData<List<Client>> = clientDao.readAllData()

    fun addClients(client: Client){
        clientDao.addClients(client)
    }

    fun updateClients(client: Client){
        clientDao.updateClients(client)
    }

    fun deleteClients(client: Client){
        clientDao.deleteClients(client)
    }

    fun deleteAllClients(){
        clientDao.deleteAllClients()
    }

}