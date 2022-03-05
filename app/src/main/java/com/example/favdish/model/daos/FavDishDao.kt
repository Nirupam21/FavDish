package com.example.favdish.model.daos

import androidx.room.Dao
import androidx.room.Insert
import com.example.favdish.model.entities.FavDishEntity


@Dao
interface FavDishDao {

    @Insert
    fun insertFavDishDetails(favDish: FavDishEntity)
}