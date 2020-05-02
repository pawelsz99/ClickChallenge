package com.pawelsznuradev.clickchallenge


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
//import com.google.android.gms.ads.MobileAds
import com.pawelsznuradev.clickchallenge.databinding.MainActivityBinding



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)

       // MobileAds.initialize(this){}



    }
}
