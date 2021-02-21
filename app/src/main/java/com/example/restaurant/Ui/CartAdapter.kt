package com.example.restaurant.Ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.restaurant.Db.Dish
import com.example.restaurant.R
import kotlinx.android.synthetic.main.cart_card.view.*
import kotlinx.android.synthetic.main.fragment_cart.view.*

class CartAdapter(private val Carts : List<Dish>): RecyclerView.Adapter<CartAdapter.CartViewHolder>(){

    class CartViewHolder(val view : View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.cart_card,parent,false)
        )
    }

    override fun getItemCount()=Carts.size
    var total=0.0;
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.view.sno.text=(position+1).toString()
        holder.view.dish_cart.text = Carts[position].Name
        holder.view.price_cart.text= Carts[position].Price.toString()
        holder.view.count_cart_card.text="("+Carts[position].CountOrder.toString()+")"
        val amount=(Carts[position].Price*Carts[position].CountOrder)*0.025 +(Carts[position].Price*Carts[position].CountOrder)*0.025+(Carts[position].Price*Carts[position].CountOrder)
        holder.view.amount_cart_card.text=amount.toString()
        total+=amount
//        nettotal= total
//        holder.view.net_total_cart.text="total.toString()"
    }

}