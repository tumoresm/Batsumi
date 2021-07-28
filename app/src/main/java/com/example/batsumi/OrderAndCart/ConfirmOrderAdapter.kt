package com.example.batsumi.OrderAndCart


import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.batsumi.R
import java.util.ArrayList

class ConfirmOrderAdapter(activity: Activity?) :
    RecyclerView.Adapter<ConfirmOrderAdapter.ViewHolder?>() {
    private val models: ArrayList<OrderListModel>
    var activity: Activity?
    @NonNull

    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.confirm_rv_items, parent, false)
        return ViewHolder(view)
    }

     override fun onBindViewHolder(@NonNull holder: ViewHolder, position: Int) {
        val model: OrderListModel = models.get(position)
        holder.name.setText(model.getName())
        holder.price.setText(model.getPrice())
        model.setQuantity(1)
        holder.add.setOnClickListener(object : OnClickListener() {

            fun onClick(v: View?) {
                var s = holder.quan.getText() as String
                var i: Int = Integer.parseInt(s)
                i++
                model.setQuantity(i)
                s = Integer.toString(i)
                holder.quan.setText(Integer.toString(model.getQuantity()))
            }
        })
        holder.minus.setOnClickListener(object : OnClickListener() {
            @Override
            fun onClick(v: View?) {
                var s = holder.quan.getText() as String
                var i: Int = Integer.parseInt(s)
                if (i > 0) {
                    i--
                    model.setQuantity(i)
                    s = Integer.toString(i)
                    holder.quan.setText(Integer.toString(model.getQuantity()))
                }
            }
        })
    }

    @get:Override
    val itemCount: Int
        get() = models.size()

    inner class ViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var price: TextView
        var quan: TextView
        var add: ImageView
        var minus: ImageView

        init {
            name = itemView.findViewById(R.id.confirm_name)
            price = itemView.findViewById(R.id.confirm_price)
            quan = itemView.findViewById(R.id.confirm_amt)
            add = itemView.findViewById(R.id.add)
            minus = itemView.findViewById(R.id.minus)
        }
    }

    init {
        models = (ApplicationMain.getMyContext() as UpdateSelectedItem).getItems()
        this.activity = activity
    }
}