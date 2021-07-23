package com.example.batsumi


import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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
            items.add(DynamicRvModel("Simple Fries", R.drawable.fries, 0))
            items.add(DynamicRvModel("Small Fries", R.drawable.fries, 0))
            items.add(DynamicRvModel("Medium Fries", R.drawable.fries, 0))
            items.add(DynamicRvModel("Large Fries", R.drawable.fries, 0))
            items.add(DynamicRvModel("Extra Cheese Fries", R.drawable.fries, 0))
            updateRV.callBack(position, items)
            check = false
        }
        holder.linearLayout.setOnClickListener {
            row_index = position
            notifyDataSetChanged()

            //pizza
            if (position == 0) {
                val items = ArrayList<DynamicRvModel>()
                items.add(DynamicRvModel("Simple Fries", R.drawable.fries, 0))
                items.add(DynamicRvModel("Small Fries", R.drawable.fries, 0))
                items.add(DynamicRvModel("Medium Fries", R.drawable.fries, 0))
                items.add(DynamicRvModel("Large Fries", R.drawable.fries, 0))
                items.add(DynamicRvModel("Extra Cheese Fries", R.drawable.fries, 0))
                updateRV.callBack(position, items)
            } else if (position == 1) {
                val items = ArrayList<DynamicRvModel>()
                items.add(DynamicRvModel("Simple Mogudu", R.drawable.mogudu, 1))
                items.add(DynamicRvModel("Hot Sauce Mogudu", R.drawable.mogudu, 1))
                items.add(DynamicRvModel("Medium Mogudu", R.drawable.mogudu, 1))
                items.add(DynamicRvModel("Large Mogudu", R.drawable.mogudu, 1))
                items.add(DynamicRvModel("Mogudu with Cabbage", R.drawable.mogudu, 1))
                updateRV.callBack(position, items)
            } else if (position == 2) {
                val items = ArrayList<DynamicRvModel>()
                items.add(DynamicRvModel("Beef & Wors", R.drawable.shisanyama2, 2))
                items.add(DynamicRvModel("Mutton & Beef", R.drawable.shisanyama2, 2))
                items.add(DynamicRvModel("Mutton, Wors & Beef", R.drawable.shisanyama2, 2))
                items.add(DynamicRvModel("Mutton & Wors", R.drawable.shisanyama2, 2))
                items.add(DynamicRvModel("Beef & Chicken", R.drawable.shisanyama2, 2))
                updateRV.callBack(position, items)
            } else if (position == 3) {
                val items = ArrayList<DynamicRvModel>()
                items.add(DynamicRvModel("Igwinya with Mince", R.drawable.vetkoek, 3))
                items.add(DynamicRvModel("Igwinya with Polony", R.drawable.vetkoek, 3))
                items.add(DynamicRvModel("Igwinya with Beef strips", R.drawable.vetkoek, 3))
                items.add(DynamicRvModel("Simple igwinya", R.drawable.vetkoek, 3))
                items.add(DynamicRvModel("Igwinya wih Atchar", R.drawable.vetkoek, 3))
                updateRV.callBack(position, items)
            } else if (position == 4) {
                val items = ArrayList<DynamicRvModel>()
                items.add(DynamicRvModel("Simple Sandwich", R.drawable.sphahlo, 4))
                items.add(DynamicRvModel("Chips, Cheese Sandwich", R.drawable.sphahlo, 4))
                items.add(DynamicRvModel("Cheese Russian & Chips Sandwich", R.drawable.sphahlo, 4))
                items.add(DynamicRvModel("Chips, Egg & Bacon Sandwich", R.drawable.sphahlo, 4))
                items.add(DynamicRvModel("Grilled Cheese Sandwich", R.drawable.sphahlo, 4))
                updateRV.callBack(position, items)
            }
        }
        if (select) {
            if (position == 0) {
                holder.linearLayout.setBackgroundResource(R.drawable.select_custom_rv)
            }
            select = false
        } else {
            if (row_index == position) {
                holder.linearLayout.setBackgroundResource(R.drawable.select_custom_rv)
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
