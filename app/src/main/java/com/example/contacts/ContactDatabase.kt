package com.example.contacts

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Contact::class],
    version = 2
)
abstract class ContactDatabase : RoomDatabase() {

    abstract val dao: ContactDao
}