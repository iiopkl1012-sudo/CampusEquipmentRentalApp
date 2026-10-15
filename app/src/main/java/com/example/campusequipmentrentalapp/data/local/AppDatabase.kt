package com.example.campusequipmentrentalapp.data.local


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [RentalEntity::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase()
{
    /**
     * RentalDao 연결 처리
     * */
    abstract fun rentalDao(): RentalDao

    companion object {
        private var instance: AppDatabase? = null

        /** 앱 전체에서 같은 DB 를 사용 */
        fun getDatabase(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                val _instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "campus_rental_database"
                ).build()
                instance = _instance
                _instance
            }
         }
        }
}