package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private var dishType: String = ""
    private var checkedPrices = mutableListOf<String>()
    private var checkedManufacturers = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDropdownList()
        initPriceCheckboxListeners()
        initManufacturerCheckboxListeners()
        findViewById<Button>(R.id.submit_button).setOnClickListener {
            outputFinalInformation()
        }
    }

    private fun initPriceCheckboxListeners() {
        findViewById<CheckBox>(R.id.checkBox_price_1).setOnClickListener { view: View ->
            onPriceCheckboxClicked(
                view
            )
        }
        findViewById<CheckBox>(R.id.checkBox_price_2).setOnClickListener { view: View ->
            onPriceCheckboxClicked(
                view
            )
        }
        findViewById<CheckBox>(R.id.checkBox_price_3).setOnClickListener { view: View ->
            onPriceCheckboxClicked(
                view
            )
        }
        findViewById<CheckBox>(R.id.checkBox_price_4).setOnClickListener { view: View ->
            onPriceCheckboxClicked(
                view
            )
        }
    }

    private fun initManufacturerCheckboxListeners() {
        findViewById<CheckBox>(R.id.checkBox_manufacturer_1).setOnClickListener { view: View ->
            onManufacturerCheckboxClicked(
                view
            )
        }
        findViewById<CheckBox>(R.id.checkBox_manufacturer_2).setOnClickListener { view: View ->
            onManufacturerCheckboxClicked(
                view
            )
        }
    }

    private fun initDropdownList() {
        val spinner: Spinner = findViewById(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.dishes_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        spinner.onItemSelectedListener = this
    }


    private fun onPriceCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkBox_price_1 -> {
                    if (checked) {
                        checkedPrices.add(resources.getString(R.string.priceCheckbox1))
                    } else {
                        checkedPrices.remove(resources.getString(R.string.priceCheckbox1))
                    }
                }
                R.id.checkBox_price_2 -> {
                    if (checked) {
                        checkedPrices.add(resources.getString(R.string.priceCheckbox2))
                    } else {
                        checkedPrices.remove(resources.getString(R.string.priceCheckbox2))
                    }
                }
                R.id.checkBox_price_3 -> {
                    if (checked) {
                        checkedPrices.add(resources.getString(R.string.priceCheckbox3))
                    } else {
                        checkedPrices.remove(resources.getString(R.string.priceCheckbox3))
                    }
                }

                R.id.checkBox_price_4 -> {
                    if (checked) {
                        checkedPrices.add(resources.getString(R.string.priceCheckbox4))
                    } else {
                        checkedPrices.remove(resources.getString(R.string.priceCheckbox4))
                    }
                }
            }
        }
    }

    private fun onManufacturerCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkBox_manufacturer_1 -> {
                    if (checked) {
                        checkedManufacturers.add(resources.getString(R.string.Manufacturer1))
                    } else {
                        checkedManufacturers.remove(resources.getString(R.string.Manufacturer1))
                    }
                }
                R.id.checkBox_manufacturer_2 -> {
                    if (checked) {
                        checkedManufacturers.add(resources.getString(R.string.Manufacturer2))
                    } else {
                        checkedManufacturers.remove(resources.getString(R.string.Manufacturer2))
                    }
                }
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, Id: Long) {
        val dishTypes = resources.getStringArray(R.array.dishes_array)
        dishType = dishTypes[position]
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        dishType = "Nothing selected"
    }

//    private fun onSubmitButtonClicked(view: View) {
//        if (view is Button) {
//            when (view.id) {
//                R.id.submit_button -> {
//                    val checkedPricesString =
//                        if (!checkedPrices.isEmpty()) checkedPrices.joinToString(separator = ",") else "Nothing chosen"
//                    val checkedManufacturerString =
//                        if (!checkedManufacturers.isEmpty()) checkedManufacturers.joinToString(
//                            separator = ","
//                        ) else "Nothing chosen"
//                    "Dish: $dishType\nPrice: $checkedPricesString\nManufacturers: $checkedManufacturerString"
//                        .also { findViewById<TextView>(R.id.textViewFinalText).text = it }
//
//                }
//            }
//        }
//
//    }

    private fun outputFinalInformation(){

        val checkedPricesString =
            if (checkedPrices.isNotEmpty()) checkedPrices.joinToString(separator = ",") else "Nothing chosen"
        val checkedManufacturerString =
            if (checkedManufacturers.isNotEmpty()) checkedManufacturers.joinToString(
                separator = ","
            ) else "Nothing chosen"
        "Dish: $dishType\nPrice: $checkedPricesString\nManufacturers: $checkedManufacturerString"
            .also { findViewById<TextView>(R.id.textViewFinalText).text = it }
    }

}