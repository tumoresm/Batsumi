package com.example.batsumi.MainCourse


import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.batsumi.R
import java.util.*


class StaticRvAdapter(
    private val items: ArrayList<StaticRvModel>,
    updateRV: com.example.batsumi.DRVinterface.UpdateRV,
    activity: Activity
) :
    RecyclerView.Adapter<StaticRvAdapter.StaticRvViewHolder>() {
    var row_index = -1
    var updateRV: com.example.batsumi.DRVinterface.UpdateRV
    var activity: Activity
    var check = true
    var select = true
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StaticRvViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.static_rv_items, parent, false)
        return StaticRvViewHolder(view)
    }

    override fun onBindViewHolder(holder: StaticRvViewHolder, position: Int) {
        val currentItem = items[position]
        holder.img.setImageResource(currentItem.n)
        holder.name.text = currentItem.text
        if (check) {
            val items = ArrayList<DynamicRvModel>()
            items.add(DynamicRvModel("Simple Pizza", R.drawable.food_pizza, 0))
            items.add(DynamicRvModel("Cheese Pizza", R.drawable.food_pizza, 0))
            items.add(DynamicRvModel("Pizza Margherita", R.drawable.food_pizza, 0))
            items.add(DynamicRvModel("Pizza Marinara", R.drawable.food_pizza, 0))
            items.add(DynamicRvModel("Chicago Pizza", R.drawable.food_pizza, 0))
            updateRV.callBack(position, items)
            check = false
        }
        holder.linearLayout.setOnClickListener {
            row_index = position
            notifyDataSetChanged()

            //pizza
            if (position == 0) {
                val items = ArrayList<DynamicRvModel>()
                items.add(DynamicRvModel("Simple Pizza", R.drawable.food_pizza, 0))
                items.add(DynamicRvModel("Cheese Pizza", R.drawable.food_pizza, 0))
                items.add(DynamicRvModel("Pizza Margherita", R.drawable.food_pizza, 0))
                items.add(DynamicRvModel("Pizza Marinara", R.drawable.food_pizza, 0))
                items.add(DynamicRvModel("Chicago Pizza", R.drawable.food_pizza, 0))
                updateRV.callBack(position, items)
            } else if (position == 1) {
                val items = ArrayList<DynamicRvModel>()
                items.add(DynamicRvModel("Simple Burger", R.drawable.food_burger, 1))
                items.add(DynamicRvModel("Potato Corn Burger", R.drawable.food_burger, 1))
                items.add(DynamicRvModel("Crispy Combo Burger", R.drawable.food_burger, 1))
                items.add(DynamicRvModel("Veg Chilli Burger", R.drawable.food_burger, 1))
                items.add(DynamicRvModel("burger 5", R.drawable.food_burger, 1))
                updateRV.callBack(position, items)
            } else if (position == 2) {
                val items = ArrayList<DynamicRvModel>()
                items.add(DynamicRvModel("French Fires", R.drawable.food_fries, 2))
                items.add(DynamicRvModel("Tornado Fries", R.drawable.food_fries, 2))
                items.add(DynamicRvModel("Sweet Potato Fries", R.drawable.food_fries, 2))
                items.add(DynamicRvModel("Steak Fries", R.drawable.food_fries, 2))
                items.add(DynamicRvModel("Tater Tots", R.drawable.food_fries, 2))
                updateRV.callBack(position, items)
            } else if (position == 3) {
                val items = ArrayList<DynamicRvModel>()
                items.add(DynamicRvModel("Chocolate ice-cream", R.drawable.food_icecream, 3))
                items.add(DynamicRvModel("Vanilla ice-cream", R.drawable.food_icecream, 3))
                items.add(DynamicRvModel("Mango ice-cream", R.drawable.food_icecream, 3))
                items.add(DynamicRvModel("Stawberry ice-cream", R.drawable.food_icecream, 3))
                items.add(DynamicRvModel("Mint Chocolate ice-cream", R.drawable.food_icecream, 3))
                updateRV.callBack(position, items)
            } else if (position == 4) {
                val items = ArrayList<DynamicRvModel>()
                items.add(DynamicRvModel("Simple Sandwich", R.drawable.food_sandwich, 4))
                items.add(DynamicRvModel("Tomato Cucumber Sandwich", R.drawable.food_sandwich, 4))
                items.add(DynamicRvModel("Panner Sandwich", R.drawable.food_sandwich, 4))
                items.add(DynamicRvModel("Curd Sandwich", R.drawable.food_sandwich, 4))
                items.add(DynamicRvModel("Grilled Cheese Sandwich", R.drawable.food_sandwich, 4))
                updateRV.callBack(position, items)
            }
        }
        if (select) {
            if (position == 0) {
                holder.linearLayout.setBackgroundResource(R.drawable.custom_rv_selected)
            }
            select = false
        } else {
            if (row_index == position) {
                holder.linearLayout.setBackgroundResource(R.drawable.custom_rv_selected)
            } else {
                holder.linearLayout.setBackgroundResource(R.drawable.custom_rv)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StaticRvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var img: ImageView
        var linearLayout: LinearLayout

        init {
            name = itemView.findViewById(R.id.f_name)
            img = itemView.findViewById(R.id.f_icon)
            linearLayout = itemView.findViewById(R.id.ll1)
        }
    }

    init {
        this.updateRV = updateRV
        this.activity = activity
    }
}
