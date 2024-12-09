package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CartActivity : AppCompatActivity() {

    private lateinit var tvSelectedProducts: TextView
    private lateinit var tvTotalCost: TextView
    private lateinit var btnBackToProductList: Button
    private lateinit var btnCheckout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        tvSelectedProducts = findViewById(R.id.tv_selected_products)
        tvTotalCost = findViewById(R.id.tv_total_cost)
        btnBackToProductList = findViewById(R.id.btn_back_to_list)
        btnCheckout = findViewById(R.id.btn_checkout)
        // Get data from the intent
        val selectedProducts = intent.getStringArrayListExtra("SELECTED_PRODUCTS") ?: ArrayList()
        val totalCost = intent.getStringExtra("TOTAL_COST") ?: "$0.00"


        tvSelectedProducts.text = selectedProducts.joinToString("\n")
        tvTotalCost.text = "Total Cost: $totalCost"


        btnBackToProductList.setOnClickListener {
            finish()
        }

        btnCheckout.setOnClickListener {

            val intent = Intent(this, PurchaseActivity::class.java)
            startActivity(intent)


            finish()
        }
    }
}
