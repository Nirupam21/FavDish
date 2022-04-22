package com.example.favdish.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.favdish.model.daos.FavDishRepository
import com.example.favdish.model.entities.FavDishEntity
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class FavDishViewModel(private val repository: FavDishRepository): ViewModel() {

      fun insert(dish: FavDishEntity) = viewModelScope.launch {
            repository.insertFavDishData(dish)
      }
}

class FavDishVIewModelFactory(private val repository: FavDishRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(FavDishRepository::class.java)){
                    @Suppress("Unchecked Cast")
                    return FavDishViewModel(repository) as T
            }

            throw IllegalArgumentException("Unknown ViewModel Class")
    }
}


