package com.example.batsumi

/*import com.airbnb.lottie.LottieAnimationView*/
import android.content.SharedPreferences
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.batsumi.OnbroadingFragments.onBroading_1_Fragment
import com.example.batsumi.OnbroadingFragments.onBroading_2_Fragment
import com.example.batsumi.OnbroadingFragments.onBroading_3_Fragment

class Introductory : AppCompatActivity() {
    var logo: ImageView? = null
    var appName: ImageView? = null
    var splashImg: ImageView? = null
   /* var lottieAnimationView: LottieAnimationView? = null*/
    var animation: Animation? = null
    private var viewPager: ViewPager? = null
    private var slidePageAdapter: ScreenSlidePageAdapter? = null
    var preferences: SharedPreferences? = null

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introductory)
        animation = AnimationUtils.loadAnimation(this, R.anim.ob_anim)
        logo = findViewById(R.id.splash_img_2)
        appName = findViewById(R.id.tumeliso)
        splashImg = findViewById(R.id.tumeliso)
        /*lottieAnimationView = findViewById(R.id.splash_animation)*/
        viewPager = findViewById(R.id.liquidPager)
        slidePageAdapter = ScreenSlidePageAdapter(getSupportFragmentManager())
       /* viewPager.setAdapter(slidePageAdapter)
        viewPager.setAnimation(animation)
        splashImg.animate().translationY(-3600).setDuration(1000).setStartDelay(4000)
        logo.animate().translationY(2400).setDuration(1000).setStartDelay(4000)
        appName.animate().translationY(2400).setDuration(1000).setStartDelay(4000)*/
        /*lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000)*/
        /**
         * //        new Handler().postDelayed(new Runnable() {
         * //            @Override
         * //            public void run() {
         * //                preferences = getSharedPreferences("Shared Pref", MODE_PRIVATE);
         * //                boolean isFirstTime = preferences.getBoolean("firstTime", true);
         * //
         * //                if (isFirstTime){
         * //                    SharedPreferences.Editor editor = preferences.edit();
         * //                    editor.putBoolean("firstTime", false);
         * //                    editor.commit();
         * //                }
         * //                else {
         * //                    startActivity(new Intent(Introductory.this, Login.class));
         * //                    finish();
         * //                }
         * //            }
         * //        },SPLASH_TIME_COUNT); */
    }

    private inner class ScreenSlidePageAdapter(fm: FragmentManager?) :
        FragmentStatePagerAdapter(fm!!) {
        /**
         * Return the number of views available.
         */
        fun getCount(position: Int): Fragment? {
            return when (position) {
                0 -> {
                    onBroading_1_Fragment()
                }
                1 -> {
                    onBroading_2_Fragment()
                }
                2 -> {
                    onBroading_3_Fragment()
                }
                else -> null
            }
        }

        /**
         * Return the number of views available.
         */
        override fun getCount(): Int {
            TODO("Not yet implemented")
        }

        /**
         * Return the Fragment associated with a specified position.
         */
        override fun getItem(position: Int): Fragment {
            TODO("Not yet implemented")
        }
    }

}