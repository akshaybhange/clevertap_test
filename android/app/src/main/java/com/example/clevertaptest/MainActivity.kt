package com.example.clevertaptest

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.clevertap.android.sdk.CleverTapAPI
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMagic: Button = findViewById<View>(R.id.btn_magic) as Button
        val layoutMain: ConstraintLayout = findViewById(R.id.layout_main);

        var cleverTapDefaultInstance: CleverTapAPI? = null
        cleverTapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)

        btnMagic.setOnClickListener {
            //Push Profile Update
            val profileUpdate = HashMap<String, Any>()
            profileUpdate["Name"] = "Akshay Bhange"
            profileUpdate["Email"] = "jidesh+akshay.bhange0@clevertap.com"
            profileUpdate["Phone"] = "+919876543210"
            profileUpdate["Gender"] = "M"
            CleverTapAPI.getDefaultInstance(applicationContext)?.onUserLogin(profileUpdate)

            //Trigger Event For Product Viewed
            val prodViewedData = mapOf(
                "Product ID" to 1,
                "Product Image" to "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg",
                "Product Name" to "CleverTap",
            )
            cleverTapDefaultInstance?.pushEvent("Product viewed", prodViewedData)


            val snackbar = Snackbar
                .make(layoutMain, "Event Triggered", Snackbar.LENGTH_SHORT)
            snackbar.show()
        }

    }
}