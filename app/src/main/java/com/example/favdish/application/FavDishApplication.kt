package com.example.favdish.application

import android.app.Application
import com.example.favdish.model.daos.FavDishRepository
import com.example.favdish.model.daos.FavDishRoom

class FavDishApplication : Application() {

    private val database by lazy { FavDishRoom.getDatabase((this@FavDishApplication)) }
    val repository by lazy { FavDishRepository(database.favDishDao()) }

}