package com.basbas.starterkit.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.basbas.starterkit.R
import com.basbas.starterkit.adapter.AdapterMeal
import com.basbas.starterkit.adapter.AdapterMealOffline
import com.basbas.starterkit.base.Baseactivity
import com.basbas.starterkit.entity.MealsItem
import com.basbas.starterkit.entity.MealsItemOffline
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Baseactivity(), InterfaceHome.View {
    override fun loadDataOffline(data: List<MealsItemOffline?>?) {
        if (data != null) {
            val adapterMeal = AdapterMealOffline(this, data)
            adapterMeal.notifyDataSetChanged()
            rv_meal.adapter = adapterMeal
//            swipe_refresh.isRefreshing = false
        }
    }

    override fun loadData(data: List<MealsItem?>?) {
        if (data != null) {
            val adapterMeal = AdapterMeal(this, data)
            adapterMeal.notifyDataSetChanged()
            rv_meal.adapter = adapterMeal
//            swipe_refresh.isRefreshing = false
        }
    }

    override fun showLoading() {
        progress_circular.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progress_circular.visibility = View.GONE
    }

    private var presenter: InterfaceHome.Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_meal.layoutManager = LinearLayoutManager(this)

        presenter = LogicHome(this, this)
        presenter?.loadDataMeals("Canadian")

//        swipe_refresh.setOnRefreshListener {
//            presenter?.loadDataMeals("Seafood")
//
//        }


    }
}
