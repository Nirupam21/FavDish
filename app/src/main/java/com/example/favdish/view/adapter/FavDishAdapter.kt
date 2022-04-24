package com.example.favdish.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.favdish.databinding.ItemDishLayoutBinding
import com.example.favdish.model.entities.FavDishEntity
import com.example.favdish.view.fragments.AllDishesFragment

class FavDishAdapter(private val fragment: Fragment): RecyclerView.Adapter<FavDishAdapter.ViewHolder>() {

        private var dishes: List<FavDishEntity> = listOf()

        class ViewHolder(view: ItemDishLayoutBinding): RecyclerView.ViewHolder(view.root) {
            val ivDishImage = view.ivDishImage
            val tvTitle = view.tvDishTitle
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemDishLayoutBinding = ItemDishLayoutBinding.inflate(
                LayoutInflater.from(fragment.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val dish = dishes[position]
            Glide.with(fragment)
                .load(dish.image)
                .into(holder.ivDishImage)

            holder.tvTitle.text = dish.title
    }

    override fun getItemCount(): Int {
        return dishes.count()
    }

    fun dishesList(list: List<FavDishEntity>) {
            dishes = list
            notifyDataSetChanged()
    }
}