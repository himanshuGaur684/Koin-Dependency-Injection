package com.example.koindi

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FakeObject::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        fun getDataBase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "db")
                .fallbackToDestructiveMigration().build()
    }

    abstract fun appDao(): AppDao

}

@Entity
data class FakeObject(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)

@Dao
interface AppDao {

    @Insert
    suspend fun insertFakeObject(fakeObject: FakeObject)

}