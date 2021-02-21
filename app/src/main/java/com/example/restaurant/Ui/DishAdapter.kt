package com.example.restaurant.Ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurant.Db.Dish
import com.example.restaurant.Db.DishDatabase
import com.example.restaurant.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.dish_card.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DishAdapter(private val dishes: List<Dish>): RecyclerView.Adapter<DishAdapter.DishViewHolder>(){

    class DishViewHolder(val view : View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        return DishViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.dish_card,parent,false)
        )
    }
    override fun getItemCount()=dishes.size
    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
//        val img:String="dishes[position].imageDir"
//        var imgres= holder.view.context.resources.getIdentifier(img,null,holder.view.context.packageName)
//        val res = holder.view.context.resources.getDrawable(imgres)
        holder.view.dish_name.text=dishes[position].Name
        holder.view.price_dish.text=dishes[position].Price.toString()
        holder.view.add_to_cart_button.setOnClickListener {
            CoroutineScope(Dispatchers.Main + Job()).launch {
                    holder.view.context?.let{
                        val count= DishDatabase(it).getDishDao().getCount(dishes[position].Name,dishes[position].Category) +1
                        DishDatabase(it).getDishDao().updateCount(count,dishes[position].Name,dishes[position].Category)
                        holder.view.count_in_cart.text=count.toString()
                    }
                }
        }
    }
}