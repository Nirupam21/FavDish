package com.example.favdish.model.daos

import androidx.annotation.WorkerThread
import com.example.favdish.model.entities.FavDishEntity
import kotlinx.coroutines.flow.Flow

class FavDishRepository(private val favDishDao: FavDishDao) {

      @WorkerThread
      suspend fun insertFavDishData(favDishEntity: FavDishEntity) {
                  favDishDao.insertFavDishDetails(favDishEntity)
      }

      val allDishesList: Flow<List<FavDishEntity>> = favDishDao.getAllDishesList()
}