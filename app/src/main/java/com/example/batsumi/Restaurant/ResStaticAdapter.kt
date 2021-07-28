package com.example.batsumi.Restaurant

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.batsumi.DRVinterface.UpdateResRV
import com.example.batsumi.R
import java.util.*


class ResStaticAdapter(
    private val items: ArrayList<ResStaticModel>,
    updateResRV: UpdateResRV,
    activity: Activity
) :
    RecyclerView.Adapter<ResStaticAdapter.ViewHolder>() {
    var row_index = -1
    var updateResRV: UpdateResRV
    var activity: Activity
    var check = true
    var select = true
    var p = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.res_static_rv_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.img.setImageResource(items[position].img)
        p = items[position].pos
        if (check) {
            if (p == 0) {
                val items = ArrayList<ResDynamicModel>()
                items.add(ResDynamicModel("Simple Pizza", "50"))
                items.add(ResDynamicModel("Cheese Pizza", "160"))
                items.add(ResDynamicModel("Pizza Margherita", "100"))
                items.add(ResDynamicModel("Pizza Marinara", "150"))
                items.add(ResDynamicModel("Chicago Pizza", "120"))
                updateResRV.callBack(position, items)
            } else if (p == 1) {
                val items = ArrayList<ResDynamicModel>()
                items.add(ResDynamicModel("Simple Burger", "40"))
                items.add(ResDynamicModel("Potato Corn Burger", "160"))
                items.add(ResDynamicModel("Crispy Combo Burger", "125"))
                items.add(ResDynamicModel("Veg Chilli Burger", "90"))
                items.add(ResDynamicModel("Burger 5", "138"))
                updateResRV.callBack(position, items)
            } else if (p == 2) {
                val items = ArrayList<ResDynamicModel>()
                items.add(ResDynamicModel("French Fires", "60"))
                items.add(ResDynamicModel("Tornado Fries", "160"))
                items.add(ResDynamicModel("Sweet Potato Fries", "150"))
                items.add(ResDynamicModel("Steak Fries", "100"))
                items.add(ResDynamicModel("Tater Tots", "120"))
                updateResRV.callBack(position, items)
            } else if (p == 3) {
                val items = ArrayList<ResDynamicModel>()
                items.add(ResDynamicModel("Chocolate ice-cream", "45"))
                items.add(ResDynamicModel("Vanilla ice-cream", "60"))
                items.add(ResDynamicModel("Mango ice-cream", "80"))
                items.add(ResDynamicModel("Stawberry ice-cream", "55"))
                items.add(ResDynamicModel("Mint Chocolate ice-cream", "95"))
                updateResRV.callBack(position, items)
            } else if (p == 4) {
                val items = ArrayList<ResDynamicModel>()
                items.add(ResDynamicModel("Simple Sandwich", "20"))
                items.add(ResDynamicModel("Tomato Cucumber Sandwich", "49"))
                items.add(ResDynamicModel("Panner Sandwich", "79"))
                items.add(ResDynamicModel("Curd Sandwich", "99"))
                items.add(ResDynamicModel("Grilled Cheese Sandwich", "65"))
                updateResRV.callBack(position, items)
            }
            check = false
        }
        holder.linearLayout.setOnClickListener {
            row_index = position
            notifyDataSetChanged()

            //pizza
            if (position == 0) {
                val items = ArrayList<ResDynamicModel>()
                items.add(ResDynamicModel("Simple Pizza", "50"))
                items.add(ResDynamicModel("Cheese Pizza", "160"))
                items.add(ResDynamicModel("Pizza Margherita", "100"))
                items.add(ResDynamicModel("Pizza Marinara", "150"))
                items.add(ResDynamicModel("Chicago Pizza", "120"))
                updateResRV.callBack(position, items)
            } else if (position == 1) {
                val items = ArrayList<ResDynamicModel>()
                items.add(ResDynamicModel("Simple Burger", "40"))
                items.add(ResDynamicModel("Potato Corn Burger", "160"))
                items.add(ResDynamicModel("Crispy Combo Burger", "125"))
                items.add(ResDynamicModel("Veg Chilli Burger", "90"))
                items.add(ResDynamicModel("Burger 5", "138"))
                updateResRV.callBack(position, items)
            } else if (position == 2) {
                val items = ArrayList<ResDynamicModel>()
                items.add(ResDynamicModel("French Fires", "60"))
                items.add(ResDynamicModel("Tornado Fries", "160"))
                items.add(ResDynamicModel("Sweet Potato Fries", "150"))
                items.add(ResDynamicModel("Steak Fries", "100"))
                items.add(ResDynamicModel("Tater Tots", "120"))
                updateResRV.callBack(position, items)
            } else if (position == 3) {
                val items = ArrayList<ResDynamicModel>()
                items.add(ResDynamicModel("Chocolate ice-cream", "45"))
                items.add(ResDynamicModel("Vanilla ice-cream", "60"))
                items.add(ResDynamicModel("Mango ice-cream", "80"))
                items.add(ResDynamicModel("Stawberry ice-cream", "55"))
                items.add(ResDynamicModel("Mint Chocolate ice-cream", "95"))
                updateResRV.callBack(position, items)
            } else if (position == 4) {
                val items = ArrayList<ResDynamicModel>()
                items.add(ResDynamicModel("Simple Sandwich", "20"))
                items.add(ResDynamicModel("Tomato Cucumber Sandwich", "49"))
                items.add(ResDynamicModel("Panner Sandwich", "79"))
                items.add(ResDynamicModel("Curd Sandwich", "99"))
                items.add(ResDynamicModel("Grilled Cheese Sandwich", "65"))
                updateResRV.callBack(position, items)
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

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img: ImageView
        var linearLayout: LinearLayout

        init {
            img = itemView.findViewById(R.id.res_static_img)
            linearLayout = itemView.findViewById(R.id.res_ll1)
        }
    }

    init {
        this.updateResRV = updateResRV
        this.activity = activity
    }
}
