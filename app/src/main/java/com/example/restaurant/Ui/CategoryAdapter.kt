package com.example.restaurant.Ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant.Db.Category
import com.example.restaurant.R
import kotlinx.android.synthetic.main.category_card.view.*
//

class CategoryAdapter(private val categories: List<Category>): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

        class CategoryViewHolder(val view : View): RecyclerView.ViewHolder(view)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
            return CategoryViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.category_card,parent,false)
            )
        }
    override fun getItemCount()=categories.size
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val img:String=categories[position].imageDir
        var imgres= holder.view.context.resources.getIdentifier(img,null,holder.view.context.packageName)
        val res = holder.view.context.resources.getDrawable(imgres)
        holder.view.category_name.text=categories[position].Category
        holder.view.category_name2.text=categories[position].Category
//        val image=Uri.parse("@dra")
        holder.view.cuisine_category_image.setImageDrawable(res)
        holder.view.setOnClickListener{
//            if (categories[position].Category.equals("Indian")){
//               val b="Indian"
//            }

            val action = HomeFragmentDirections.hometoDishes(categories[position].Category)
            Navigation.findNavController(it).navigate(action)
        }
//                .setImageURI(image)
//                .setImageResource(R.drawable."image")
    }
}