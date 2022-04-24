package com.example.favdish.model.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.favdish.model.entities.FavDishEntity
import java.nio.file.FileVisitOption
import java.util.concurrent.Flow


@Dao
interface FavDishDao {

    @Insert
    suspend fun insertFavDishDetails(favDishEntity: FavDishEntity)

    @Query("Select * from FAV_DISH_TABLE order by ID")

    fun getAllDishesList(): kotlinx.coroutines.flow.Flow<List<FavDishEntity>>
}