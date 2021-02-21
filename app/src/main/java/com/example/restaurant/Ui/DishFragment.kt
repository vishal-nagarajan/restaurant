package com.example.restaurant.Ui

import android.icu.lang.UCharacter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.restaurant.Db.Category
import com.example.restaurant.Db.Dish
import com.example.restaurant.Db.DishDatabase
import com.example.restaurant.R
import kotlinx.android.synthetic.main.dish_card.*
import kotlinx.android.synthetic.main.fragment_dish.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.category_recycler
import kotlinx.coroutines.launch

class DishFragment : BaseFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dish, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        dish_recycler.setHasFixedSize(true)
        dish_recycler.layoutManager=  StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
        launch {
            context?.let {
                var dishes= DishDatabase(it).getDishDao().getAllDishes()
//                if (dishes.isEmpty()){
//                    var mDish = Dish("Idli","Indian",75,0,5)
//                    DishDatabase(it).getDishDao().addDish(mDish)
//                    mDish = Dish("Chappathi","Indian",85,0,4)
//                    DishDatabase(it).getDishDao().addDish(mDish)
//                    mDish = Dish("Taco","Mexican",180,0,4)
//                    DishDatabase(it).getDishDao().addDish(mDish)
//                    mDish = Dish("Chappathi","Indian",85,0,4)
//                    DishDatabase(it).getDishDao().addDish(mDish)
//                    mDish = Dish("Mayyo","Mexican",180,0,4)
//                    DishDatabase(it).getDishDao().addDish(mDish)
//                    mDish = Dish("Chappathi","Indian",85,0,4)
//                    DishDatabase(it).getDishDao().addDish(mDish)
//                    mDish = Dish("Veggie patti","Mexican",180,0,4)
//                    DishDatabase(it).getDishDao().addDish(mDish)
//                    mDish = Dish("Noodles","Chinese",180,0,4)
//                    DishDatabase(it).getDishDao().addDish(mDish)
//                    mDish = Dish("Fried Rice","Chinese",140,0,4)
//                    DishDatabase(it).getDishDao().addDish(mDish)
//                    mDish = Dish("chops","Chinese",280,0,4)
//                    DishDatabase(it).getDishDao().addDish(mDish)
//                }
                var cat:String="India"
                arguments?.let {
                    cat = DishFragmentArgs.fromBundle(it).categoryCs.toString()
                    cuisine_category_name.setText(cat)
                }
//                if(cat == "Indian") {
                    dishes = DishDatabase(it).getDishDao().getSpecificDish(cat)
                    dish_recycler.adapter = DishAdapter(dishes)
//                }


            }
        }


    }
}