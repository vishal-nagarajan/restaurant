package com.example.restaurant.Ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.restaurant.Db.Category
import com.example.restaurant.Db.Dish
import com.example.restaurant.Db.DishDatabase
import com.example.restaurant.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment() {
//    private lateinit var  binding: FragmentActivit;
    private var dish: Dish? = null
    private lateinit var dishes: List<Dish>
//    private  var categories: List<Category>=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding= ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        launch {
//        context?.let {

//
//        }
//    }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        launch {
//            context?.let {
////                dish=get
//                var mDish = Dish("Idli","South Indian",75,0,5)
//                DishDatabase(it).getDishDao().addDish(mDish)
//                mDish = Dish("Chappathi","North Indian",85,0,4)
//                DishDatabase(it).getDishDao().addDish(mDish)
//                mDish = Dish("Taco","Mexican",180,0,4)
//                DishDatabase(it).getDishDao().addDish(mDish)
//            }
//        }
//        launch {
//            context?.let {
//                var mCategory=Category("mexican","@drawable/mexicancuisine")
//                DishDatabase(it).getDishDao().addCategory(mCategory)
//                mCategory=Category("Indian","@drawable/indiancuisine")
//                DishDatabase(it).getDishDao().addCategory(mCategory)
//
//                }
//            }

//        category_recycler.bottom
        category_recycler.setHasFixedSize(true)
        category_recycler.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)
        launch {
            context?.let {
               var categories=DishDatabase(it).getDishDao().getAllCategory()
                if (categories.isEmpty()){
                    var mCategory=Category("Indian","@drawable/indiancuisine")
                    DishDatabase(it).getDishDao().addCategory(mCategory)
                    mCategory=Category("Mexican","@drawable/mexicancuisine")
                    DishDatabase(it).getDishDao().addCategory(mCategory)

                    mCategory=Category("Chinese","@drawable/chinesecuisine")
                    DishDatabase(it).getDishDao().addCategory(mCategory)

                }
                categories=DishDatabase(it).getDishDao().getAllCategory()
                category_recycler.adapter=CategoryAdapter(categories)


            }
            context?.let {
                val dishes = DishDatabase(it).getDishDao().getAllDishes()
                if (dishes.isEmpty()){
                            var mDish = Dish("Biriyani","Indian",250,0,5)
                            DishDatabase(it).getDishDao().addDish(mDish)
                            mDish = Dish("Ramen","Chinese",150,0,4)
                            DishDatabase(it).getDishDao().addDish(mDish)
                            mDish = Dish("Veg Patti","Mexican",180,0,4)
                            DishDatabase(it).getDishDao().addDish(mDish)
                            mDish = Dish("Idli","Indian",75,0,5)
                            DishDatabase(it).getDishDao().addDish(mDish)
                            mDish = Dish("Chappathi","Indian",85,0,4)
                            DishDatabase(it).getDishDao().addDish(mDish)
                            mDish = Dish("Taco","Mexican",180,0,4)
                            DishDatabase(it).getDishDao().addDish(mDish)
                            mDish = Dish("Chappathi","Indian",85,0,4)
                            DishDatabase(it).getDishDao().addDish(mDish)
                            mDish = Dish("Mayyo","Mexican",180,0,4)
                            DishDatabase(it).getDishDao().addDish(mDish)
                            mDish = Dish("Chappathi","Indian",85,0,4)
                            DishDatabase(it).getDishDao().addDish(mDish)
                            mDish = Dish("Veggie patti","Mexican",180,0,4)
                            DishDatabase(it).getDishDao().addDish(mDish)
                            mDish = Dish("Noodles","Chinese",180,0,4)
                            DishDatabase(it).getDishDao().addDish(mDish)
                            mDish = Dish("Fried Rice","Chinese",140,0,4)
                            DishDatabase(it).getDishDao().addDish(mDish)
                            mDish = Dish("chops","Chinese",280,0,4)
                            DishDatabase(it).getDishDao().addDish(mDish)

                }
            }
        }
        biriyani_addCart.setOnClickListener {
            launch {
                context?.let {
                    val count=DishDatabase(it).getDishDao().getCount("Biriyani","Indian") +1
                    DishDatabase(it).getDishDao().updateCount(count,"Biriyani","Indian")
                    biriyani_count.text=count.toString()
                }
            }

        }
        ramen_addCart.setOnClickListener {
            launch {
                context?.let {
                    val count=DishDatabase(it).getDishDao().getCount("Ramen","Chinese") +1
                    DishDatabase(it).getDishDao().updateCount(count,"Ramen","Chinese")
                    ramen_count.text=count.toString()
                }
            }
        }
        vegPatti_addCart.setOnClickListener {
            launch {
                context?.let {
                    val count=DishDatabase(it).getDishDao().getCount("Veg Patti","Mexican") +1
                    DishDatabase(it).getDishDao().updateCount(count,"Veg Patti","Mexican")
                    vpCount.text=count.toString()
                }
            }
        }
        view_cart.setOnClickListener {
            val action = HomeFragmentDirections.homeToCart()
            Navigation.findNavController(it).navigate(action)
        }

    }
}