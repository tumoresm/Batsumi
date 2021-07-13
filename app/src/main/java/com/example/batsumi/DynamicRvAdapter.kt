package com.example.batsumi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.RatingBar.OnRatingBarChangeListener
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class DynamicRvAdapter(var models: ArrayList<DynamicRvModel>) :
    RecyclerView.Adapter<DynamicRvAdapter.DynamicRvHolder>() {
    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DynamicRvHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.dynamicrvitems, parent, false)
        return DynamicRvHolder(view, listener)
    }

    override fun onBindViewHolder(holder: DynamicRvHolder, position: Int) {
        val model = models[position]
        holder.imageView.setImageResource(model.image)
        holder.textView.text = model.name
        holder.ratingBar.onRatingBarChangeListener =
            OnRatingBarChangeListener { ratingBar, rating, fromUser -> ratingBar.rating = rating }
    }

    override fun getItemCount(): Int {
        return models.size
    }

    inner class DynamicRvHolder(itemView: View, listener: OnItemClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView
        var textView: TextView
        var ratingBar: RatingBar
        var constraintLayout: ConstraintLayout

        init {
            imageView = itemView.findViewById(R.id.dy_img)
            textView = itemView.findViewById(R.id.dy_name)
            constraintLayout = itemView.findViewById(R.id.constraintLayout)
            ratingBar = itemView.findViewById(R.id.dy_rating)
            itemView.setOnClickListener {
                if (listener != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position)
                    }
                }
            }
        }
    }
}