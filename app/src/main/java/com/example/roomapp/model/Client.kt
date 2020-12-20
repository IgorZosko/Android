package com.example.roomapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "client_table")
data class Client(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val modelPhone: String,
    val troubleshoot: String,
    val price: String
): Parcelable