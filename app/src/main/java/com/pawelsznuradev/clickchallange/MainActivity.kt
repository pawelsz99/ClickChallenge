package com.pawelsznuradev.clickchallange


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.pawelsznuradev.clickchallange.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)
//        Timber.i("OnCreate ")
//        if (savedInstanceState == null) {
//            Timber.i("OnCreate If")
//            supportFragmentManager.beginTransaction()
//                    .replace(R.id.container, HomeFragment.newInstance())
//                    .commitNow()
//        }

        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity)




    }
}
