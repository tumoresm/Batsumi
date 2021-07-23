package com.example.batsumi
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.example.batsumi.DRVinterface.UpdateRV;

class DashBoard : AppCompatActivity(), UpdateRV,
    NavigationView.OnNavigationItemSelectedListener {
    private var recyclerView: RecyclerView? = null
    private var dy_recyclerView: RecyclerView? = null
    private var adapter: StaticRvAdapter? = null
    var pos = 0
    var nav: ImageView? = null

    //Drawer for Navigation
    var drawerLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null
    var toolbar: Toolbar? = null
    var dy_items: ArrayList<DynamicRvModel>? = null
    var dynamicRvAdapter: DynamicRvAdapter? = null
    var img: ImageView? = null
    var proButton: ImageView? = null
    var imgURI: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_Batsumi)
        setContentView(R.layout.activity_dash_board)
        val item = ArrayList<StaticRvModel>()
        /** *********************************  */
        item.add(StaticRvModel(R.drawable.fries, "fries"))
        item.add(StaticRvModel(R.drawable.sphahlo, "sphahlo"))
        item.add(StaticRvModel(R.drawable.shisanyama2, "shisanyama"))
        item.add(StaticRvModel(R.drawable.mogudu, "mogudu"))
        item.add(StaticRvModel(R.drawable.vetkoek, "amagwinya"))
        recyclerView = findViewById(R.id.rv_1)
        adapter = StaticRvAdapter(item, this, this@DashBoard)
        /**  Navigation  */
//        navigationView.bringToFront();
        navigationView = findViewById(R.id.navi_dash)
        drawerLayout = findViewById(R.id.drawer)
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )


        /** */
        fun onBackPressed() {
            if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
                drawerLayout!!.closeDrawer(GravityCompat.START)
            } else {
                super.onBackPressed()
            }
        }
    }

    override fun callBack(position: Int, dy_items: java.util.ArrayList<DynamicRvModel>) {
        TODO("Not yet implemented")
    }

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}
