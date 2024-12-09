package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PurchaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)


        val homeButton: Button = findViewById(R.id.btn_home)

        homeButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)


            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK

            // Start MainActivity
            startActivity(intent)


        }
    }
}
