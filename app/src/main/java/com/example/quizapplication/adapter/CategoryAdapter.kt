package com.example.quizapplication.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapplication.R
import com.example.quizapplication.databinding.ItemsLayoutBinding
import com.example.quizapplication.model.CategoryModel
import com.example.quizapplication.utils.ColorPicker
import com.example.quizapplication.utils.IconPicker

class CategoryAdapter(private val categoryList: List<CategoryModel>,val context:Context,var onItemClick: OnItemClick) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    private lateinit var itemsLayoutBinding: ItemsLayoutBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemsLayoutBinding = ItemsLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemsLayoutBinding)
    }

    override fun getItemCount(): Int {
      return  categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryModel = categoryList[position]
        holder.bind(categoryModel)
        holder.layoutBinding.cardView.setCardBackgroundColor(Color.parseColor(ColorPicker.getColor()))
        holder.layoutBinding.itemIcon.setImageResource(IconPicker.getIcon())
        holder.layoutBinding.root.setOnClickListener {
            onItemClick.onItemClickListener(categoryModel)
        }
    }


    class ViewHolder(val layoutBinding: ItemsLayoutBinding): RecyclerView.ViewHolder(layoutBinding.root) {

        fun bind(categoryModel: CategoryModel){
            layoutBinding.categoryModel = categoryModel

        }
    }
}