package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.coroutines.selects.SelectInstance

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up logo click listeners
        val feature1Logo: ImageView = view.findViewById(R.id.logo_feature1)
        val feature2Logo: ImageView = view.findViewById(R.id.logo_feature2)
        val feature3Logo: ImageView = view.findViewById(R.id.logo_feature3)
        val feature4Logo: ImageView = view.findViewById(R.id.logo_feature4)
        val feature5Logo: ImageView = view.findViewById(R.id.logo_feature5)
        val feature6Logo: ImageView = view.findViewById(R.id.logo_feature6)

        feature1Logo.setOnClickListener {
            Toast.makeText(context, "Itinerary Planner", Toast.LENGTH_SHORT).show()
            // Navigate to Itinerary Planner
            val intent = Intent(activity, ItineraryPlanner::class.java)
            startActivity(intent)
        }

        feature2Logo.setOnClickListener {
            Toast.makeText(context, "Attractions", Toast.LENGTH_SHORT).show()
            // Navigate to Attractions
        }

        feature3Logo.setOnClickListener {
            Toast.makeText(context, "Feature 3 clicked", Toast.LENGTH_SHORT).show()
            // Navigate to Feature 3
        }

        feature4Logo.setOnClickListener {
            Toast.makeText(context, "Reviews", Toast.LENGTH_SHORT).show()
            // Navigate to Destination Review
            val intent = Intent(activity, Destination::class.java)
            startActivity(intent)
        }

        feature5Logo.setOnClickListener {
            Toast.makeText(context, "Registration", Toast.LENGTH_SHORT).show()
            // Navigate to Registration
            val intent = Intent(activity, RegistrationActivity::class.java)
            startActivity(intent)
        }

        feature6Logo.setOnClickListener {
            Toast.makeText(context, "FAQs", Toast.LENGTH_SHORT).show()
            // Navigate to FAQs
            val intent = Intent(activity, MainActivityFAQs::class.java)
            startActivity(intent)
        }

    }
}
