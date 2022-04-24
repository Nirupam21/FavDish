package com.example.favdish.viewmodel

import androidx.lifecycle.*
import com.example.favdish.model.daos.FavDishRepository
import com.example.favdish.model.entities.FavDishEntity
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class FavDishViewModel(private val repository: FavDishRepository): ViewModel() {

    fun insert(dish: FavDishEntity) = viewModelScope.launch {
        repository.insertFavDishData(dish)
    }

    val allDishesList: LiveData<List<FavDishEntity>> = repository.allDishesList.asLiveData()

}

class FavDishVIewModelFactory(private val repository: FavDishRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(FavDishViewModel::class.java)){
                    @Suppress("Unchecked Cast")
                    return FavDishViewModel(repository) as T
            }

            throw IllegalArgumentException("Unknown ViewModel Class")
    }
}


