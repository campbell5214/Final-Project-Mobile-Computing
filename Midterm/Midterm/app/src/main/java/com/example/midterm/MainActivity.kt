package com.example.midterm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var cbSmartphone: CheckBox
    private lateinit var cbLaptop: CheckBox
    private lateinit var cbTshirt: CheckBox
    private lateinit var cbJeans: CheckBox
    private lateinit var cbMilk: CheckBox
    private lateinit var cbBread: CheckBox
    private lateinit var btnViewCart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the CheckBoxes and Button
        cbSmartphone = findViewById(R.id.cb_smartphone)
        cbLaptop = findViewById(R.id.cb_laptop)
        cbTshirt = findViewById(R.id.cb_tshirt)
        cbJeans = findViewById(R.id.cb_jeans)
        cbMilk = findViewById(R.id.cb_milk)
        cbBread = findViewById(R.id.cb_bread)
        btnViewCart = findViewById(R.id.btn_view_cart)


        btnViewCart.setOnClickListener {
            val selectedProducts = ArrayList<String>()
            var totalCost = 0.0


            if (cbSmartphone.isChecked) {
                selectedProducts.add("Fortnite - $60.00")
                totalCost += 60.00
            }
            if (cbLaptop.isChecked) {
                selectedProducts.add("Apex Legends - $40.00")
                totalCost += 40.00
            }
            if (cbTshirt.isChecked) {
                selectedProducts.add("Planets & Pancakes - $5.00")
                totalCost += 5.00
            }
            if (cbJeans.isChecked) {
                selectedProducts.add("Lethal Company - $20.00")
                totalCost += 20.00
            }
            if (cbMilk.isChecked) {
                selectedProducts.add("Crew Pass - $10.00")
                totalCost += 10.00
            }
            if (cbBread.isChecked) {
                selectedProducts.add("Astro Pass - $2.00")
                totalCost += 2.00
            }


            if (selectedProducts.isEmpty()) {
                Toast.makeText(this, "Please select at least one product", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, CartActivity::class.java).apply {
                    putStringArrayListExtra("SELECTED_PRODUCTS", selectedProducts)
                    putExtra("TOTAL_COST", String.format("$%.2f", totalCost))
                }
                startActivity(intent)
            }
        }
    }
}
