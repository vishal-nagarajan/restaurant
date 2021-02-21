package com.example.restaurant.Ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.restaurant.Db.DishDatabase
import com.example.restaurant.R
import kotlinx.android.synthetic.main.cart_card.view.*
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.coroutines.launch

class CartFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler_view_cart.setHasFixedSize(true)
        recycler_view_cart.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        launch{
            context?.let{
                val dish = DishDatabase(it).getDishDao().getDishesAddedToCart()
                recycler_view_cart.adapter = CartAdapter(dish)
                var total=0.0
                if (dish.isEmpty()){
                    context?.toast("Cart is Empty")
                }else {
                    for (d in dish) {
                        total += ((d.CountOrder * d.Price) * 0.025) + ((d.CountOrder * d.Price) * 0.025) + (d.CountOrder * d.Price)

                    }

                }
                net_total_cart.text = total.toString()
            }
        }
        place_order.setOnClickListener {
            launch {
                context?.let {
                    DishDatabase(it).getDishDao().placeporder(0)
                }
            }
            val action = CartFragmentDirections.cartToHome()
            Navigation.findNavController(it).navigate(action)
            context?.toast("Order Placed Sucesfully")
        }
    }

}