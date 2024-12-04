package com.example.myapplication3

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.adapters.ItineraryAdapter
import com.example.myapplication3.models.Itinerary

class ItineraryPlanner : AppCompatActivity() {

    private lateinit var etTitle: EditText
    private lateinit var etDuration: EditText
    private lateinit var etDay: EditText
    private lateinit var etTime: EditText
    private lateinit var etItineraryDescription: EditText
    private lateinit var btnAddItinerary: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var itineraryAdapter: ItineraryAdapter
    private val activities = mutableListOf<Itinerary>()
    private lateinit var backButtonImage: ImageView

    @SuppressLint("NotifyDataSetChanged", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itinerary_activity_main)

        etTitle = findViewById(R.id.etTitle)
        etDuration = findViewById(R.id.etDuration)
        etDay = findViewById(R.id.etDay)
        etTime = findViewById(R.id.etTime)
        etItineraryDescription = findViewById(R.id.etActivityDescription)
        btnAddItinerary = findViewById(R.id.btnAddActivity)
        recyclerView = findViewById(R.id.recyclerView)
        backButtonImage = findViewById(R.id.backButtonImage)

        // Back Button Action
        backButtonImage.setOnClickListener {
            // Navigate back to the previous screen
            finish() // Ends the current activity
        }

        // Set up the RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        itineraryAdapter = ItineraryAdapter(activities) { activity ->
            // Remove the selected activity
            activities.remove(activity)
            itineraryAdapter.notifyDataSetChanged()
        }
        recyclerView.adapter = itineraryAdapter

        // Add new activity on button click
        btnAddItinerary.setOnClickListener {
            addActivity()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addActivity() {
        // Get input values and validate
        val day = etDay.text.toString().toIntOrNull()
        val time = etTime.text.toString()
        val description = etItineraryDescription.text.toString()

        if (day != null && time.isNotBlank() && description.isNotBlank()) {
            // Create a new Activity instance and add it to the list
            val activity = Itinerary(day, time, description)
            activities.add(activity)
            itineraryAdapter.notifyDataSetChanged()  // Refresh the RecyclerView

            // Clear inputs for the next entry
            etDay.text.clear()
            etTime.text.clear()
            etItineraryDescription.text.clear()
        }
    }
}