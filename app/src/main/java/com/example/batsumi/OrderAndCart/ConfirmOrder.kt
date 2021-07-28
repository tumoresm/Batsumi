package com.example.batsumi.OrderAndCart

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.batsumi.DRVinterface.UpdateSelectedItem
import com.example.batsumi.MainCourse.DashBoard
import com.example.batsumi.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.ArrayList
import java.util.Random

class ConfirmOrder : AppCompatActivity() {
    var toolbar: Toolbar? = null
    var confirmRV: RecyclerView? = null
    var add: ImageView? = null
    var minus: ImageView? = null
    var name: TextView? = null
    var price: TextView? = null
    var orderID: TextView? = null
    var adapter: ConfirmOrderAdapter? = null
    var context: Activity? = null
    var updateSelectedItem: UpdateSelectedItem? = null
    var confirmBtn: Button? = null
    var firebaseAuth: FirebaseAuth? = null

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_order)
        confirmBtn = findViewById(R.id.confirm_btn)
        orderID = findViewById(R.id.order_id)
        toolbar = findViewById(R.id.confirm_toolbar)
        toolbar.setTitle("Confirm Order")
        toolbar.setNavigationOnClickListener(object : View.OnClickListener() {

            override fun onClick(v: View?) {
                onBackPressed()
            }
        })
        confirmRV = findViewById(R.id.confirm_RV)
        adapter = ConfirmOrderAdapter(context)
        confirmRV.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false))
        confirmRV.setAdapter(adapter)

        /////////////update se item lenge
        /**
         * static int = 1; convert to string
         * FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
         * DatabaseReference myref = firebaseDatabase.getReference("orders/o-1/"+firebaseAuth.getUid());
         * myref.setValue(userInfo);
         */
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    fun confirm(v: View?) {
        val random = Random()
        val j: Int = random.nextInt(10000)
        val s: String = Integer.toString(j)
        val e: String = DashBoard.email.getText().toString()
        val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
        val ref: DatabaseReference = firebaseDatabase.getReference("orders/ord-$s/")
        val orders: ArrayList<OrderListModel> =
            (ApplicationMain.getMyContext() as UpdateSelectedItem).getItems()
        ref.setValue(orders)
        Toast.makeText(this, "Ordered Confirmed ", Toast.LENGTH_SHORT).show()
        ++i
        orderID.setText("Order ID : $s")
    }

    companion object {
        var i = 1
    }
}