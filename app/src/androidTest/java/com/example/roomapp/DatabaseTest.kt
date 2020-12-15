package com.example.roomapp

import androidx.room.Room
import androidx.test.runner.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.roomapp.data.ClientDao
import com.example.roomapp.data.ClientDatabase
import com.example.roomapp.model.Client
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private lateinit var clientDao: ClientDao
    private lateinit var db: ClientDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, ClientDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        clientDao = db.ClientDao()
    }
    //
    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
    //
    @Test
    @Throws(Exception::class)
     fun insertUser() {
        val item = Client(0, "iPhone XS", "Bad Touch", "+380689064649")
        clientDao.addClients(item)
        val user = clientDao.readAllData()
        assertNotNull(user)
    }
}