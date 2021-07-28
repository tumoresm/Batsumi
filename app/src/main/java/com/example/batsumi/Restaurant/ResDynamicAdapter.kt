package com.example.batsumi.Restaurant

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.batsumi.DRVinterface.UpdateSelectedItem
import com.example.batsumi.OrderAndCart.ApplicationMain
import com.example.batsumi.R
import java.util.ArrayList

class ResDynamicAdapter (
    models: ArrayList<ResDynamicModel?>,
    context: Context,
    updateSelectedItem: UpdateSelectedItem?
) : RecyclerView.Adapter<ResDynamicAdapter.ViewHolder?>() {
    var models: ArrayList<ResDynamicModel?> = models
    var activity: Application? = null
    var context: Context
    var name: String? = null
    var price: String? = null
    var updateSelectedItem: UpdateSelectedItem?
    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.res_dynamic_rv_items, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(@NonNull holder: ViewHolder, position: Int) {
        val model: ResDynamicModel? = models.get(position)
        holder.name.setText(model.getName())
        holder.price.setText(model.getPrice())
        //        holder.rating.setText(model.getRating());
//        holder.review.setText(model.getReviews());
        holder.cart.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                name = model.getName()
                price = model.getPrice()
                (ApplicationMain.getMyContext() as UpdateSelectedItem)!!.addItems(name, price)
                holder.cart.setVisibility(View.INVISIBLE)
                holder.done.setVisibility(View.VISIBLE)
            }
        })
    }

    @get:Override
    val itemCount: Int
        get() = models.size()

    inner class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var price: TextView
        var cart: ImageView
        var done: ImageView

        init {
            name = itemView.findViewById(R.id.res_dy_name)
            price = itemView.findViewById(R.id.res_dy_price)
            cart = itemView.findViewById(R.id.res_cart)
            done = itemView.findViewById(R.id.res_cart_done)
        }
    }

    init {
        this.context = context
        this.updateSelectedItem = updateSelectedItem
    }
}