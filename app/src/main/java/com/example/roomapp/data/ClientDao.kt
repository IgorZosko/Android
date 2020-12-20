package com.example.roomapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomapp.model.Client

@Dao
interface ClientDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addClients(client: Client)

    @Update
    fun updateClients(client: Client)

    @Delete
    fun deleteClients(client: Client)

    @Query("DELETE FROM client_table")
    fun deleteAllClients()

    @Query("SELECT * FROM client_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Client>>

}