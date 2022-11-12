package com.roomdatabase_1

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface ContactDAO {

    @Insert
    fun insertContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Delete
    fun deleteContact(contact: Contact?)

    @Query("SELECT * FROM Contact")
    fun getAllContacts() : Cursor

    @Query("SELECT * FROM Contact WHERE _id=:id")
    fun getOneContact(id : Int) : Contact




}