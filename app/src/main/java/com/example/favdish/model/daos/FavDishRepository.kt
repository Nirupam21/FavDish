package com.example.favdish.model.daos

import androidx.annotation.WorkerThread
import com.example.favdish.model.entities.FavDishEntity

class FavDishRepository(private val favDishDao: FavDishDao) {

      @WorkerThread
      suspend fun insertFavDishData(favDishEntity: FavDishEntity) {
                  favDishDao.insertFavDishDetails(favDishEntity)
      }

}