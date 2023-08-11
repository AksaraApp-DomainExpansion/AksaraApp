package com.example.aksaraapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aksaraapp.data.model.Category
import com.example.aksaraapp.databinding.ItemCategoryBinding

class CategoryAdapter(private val data:List<Category>): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder (private val binding: ItemCategoryBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(category: Category){
                    Glide.with(itemView.context)
                        .load(category.image)
                        .into(binding.imageCategory)
                    binding.tvCategoryName.text = category.category_name
                    binding.tvCategoryDescription.text = category.category_description
                }
            }

}