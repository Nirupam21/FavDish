package com.example.favdish.model.daos

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.favdish.model.entities.FavDishEntity


@Database(entities = [FavDishEntity::class], version = 1)
abstract class FavDishRoom: RoomDatabase() {

    abstract fun favDishDao(): FavDishDao

    companion object {
        @Volatile
        private var INSTANCE: FavDishRoom? = null

        fun getDatabase(context: Context): FavDishRoom {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavDishRoom::class.java,
                    "fav_dish_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }

        }

    }
}