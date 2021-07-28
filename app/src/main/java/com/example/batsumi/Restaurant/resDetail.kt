package com.example.batsumi.Restaurant

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.Toast
import com.example.batsumi.DRVinterface.UpdateResRV
import com.example.batsumi.DRVinterface.UpdateSelectedItem
import com.example.batsumi.OrderAndCart.ConfirmOrder
import com.example.batsumi.R
import java.util.ArrayList

class resDetail : AppCompatActivity(), UpdateResRV {
    var pos = 0
    var staticRV: RecyclerView? = null
    var dynamicRV: RecyclerView? = null
    var staticAdapter: ResStaticAdapter? = null
    var dynamicAdapter: ResDynamicAdapter? = null
    var ratingBar: RatingBar? = null
    var staticModels: ArrayList<ResStaticModel?> = ArrayList()
    var dynamicModels: ArrayList<ResDynamicModel?>? = null
    var context: Activity? = null
    var updateSelectedItem: UpdateSelectedItem? = null
    var img: ImageView? = null
   
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res_detail)
        ratingBar = findViewById(R.id.res_rating)
        ratingBar.setOnRatingBarChangeListener(object : OnR9atingBarChangeListener() {
            @Override
            fun onRatingChanged(ratingBar: RatingBar, rating: Float, fromUser: Boolean) {
                ratingBar.setRating(rating)
            }
        })
        val intent: Intent = getIntent()
        pos = intent.getIntExtra("pos", 0)
        /** STATIC RV  */
        staticModels.add(ResStaticModel(R.drawable.food_2_pizza, pos))
        staticModels.add(ResStaticModel(R.drawable.food_2_burger, pos))
        staticModels.add(ResStaticModel(R.drawable.food_2_fried, pos))
        staticModels.add(ResStaticModel(R.drawable.food_2_icecream, pos))
        staticModels.add(ResStaticModel(R.drawable.food_2_sandwich, pos))
        staticRV = findViewById(R.id.res_rv_1)
        staticAdapter = ResStaticAdapter(staticModels, this, this@resDetail)
        staticRV.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false))
        staticRV.setAdapter(staticAdapter)
        //******************//
        /**  DYNAMIC RV  */
        dynamicModels = ArrayList()
        dynamicRV = findViewById(R.id.res_rv_2)
        dynamicAdapter = ResDynamicAdapter(dynamicModels, this@resDetail, updateSelectedItem)
        dynamicRV.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
        dynamicRV.setAdapter(dynamicAdapter)
        /**  GO TO ORDER ACTIVITY   */
        img = findViewById(R.id.res_2_order)
        img.setOnClickListener(object : View.OnClickListener() {
            
            fun onClick(v: View?) {
                startActivity(Intent(this@resDetail, ConfirmOrder::class.java))
            }
        })
    }

    
    override fun callBack(position: Int, res_dy_items: ArrayList<ResDynamicModel?>) {
        dynamicAdapter = ResDynamicAdapter(res_dy_items, this@resDetail, updateSelectedItem)
        dynamicAdapter.notifyDataSetChanged()
        dynamicRV.setAdapter(dynamicAdapter)
        dynamicAdapter.setOnItemClickListener(object : OnItemClickListener() {
            
            fun onItemClick(position: Int) {
                val pos: Int = res_dy_items.get(position).getPos()
                Toast.makeText(this@resDetail, "Clicked on item", Toast.LENGTH_SHORT).show()
            }
        })
    }
}