package com.example.myapplication3

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class RegistrationActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etSex: EditText
    private lateinit var etID: EditText
    private lateinit var etContactNumber: EditText
    private lateinit var etNationality: EditText
    private lateinit var etDurationOfStay: EditText
    private lateinit var rgGroup: RadioGroup
    private lateinit var rgAgency: RadioGroup
    private lateinit var etPlateNumber: EditText
    private lateinit var etDriverName: EditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Initialize fields
        etName = findViewById(R.id.etName)
        etAge = findViewById(R.id.etAge)
        etSex = findViewById(R.id.etSex)
        etID = findViewById(R.id.etID)
        etContactNumber = findViewById(R.id.etContactNumber)
        etNationality = findViewById(R.id.etNationality)
        etDurationOfStay = findViewById(R.id.etDurationOfStay)
        rgGroup = findViewById(R.id.rgGroup)
        rgAgency = findViewById(R.id.rgAgency)
        etPlateNumber = findViewById(R.id.etPlateNumber)
        etDriverName = findViewById(R.id.etDriverName)
        btnSubmit = findViewById(R.id.btnSubmit)

        // Show/Hide agency details based on selection
        rgAgency.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.rbAgencyYes) {
                etPlateNumber.visibility = View.VISIBLE
                etDriverName.visibility = View.VISIBLE
            } else {
                etPlateNumber.visibility = View.GONE
                etDriverName.visibility = View.GONE
            }
        }

        // Submit button click listener
        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString()
            val sex = etSex.text.toString()
            val id = etID.text.toString()
            val contactNumber = etContactNumber.text.toString()
            val nationality = etNationality.text.toString()
            val durationOfStay = etDurationOfStay.text.toString()
            val isGroup = rgGroup.checkedRadioButtonId == R.id.rbGroupYes
            val isWithAgency = rgAgency.checkedRadioButtonId == R.id.rbAgencyYes
            val plateNumber = if (isWithAgency) etPlateNumber.text.toString() else ""
            val driverName = if (isWithAgency) etDriverName.text.toString() else ""

            // Handle registration logic here (e.g., save data, send to a server, etc.)
            Toast.makeText(this, "Registration submitted!", Toast.LENGTH_SHORT).show()
        }
    }
}
