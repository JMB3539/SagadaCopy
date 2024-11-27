package com.example.myapplication3


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Destination : AppCompatActivity() {

    private lateinit var reviewInput: EditText
    private lateinit var ratingBar: RatingBar
    private lateinit var submitButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.destination_review)

        // Initialize Views
        reviewInput = findViewById(R.id.reviewInput)
        ratingBar = findViewById(R.id.ratingBar)
        submitButton = findViewById(R.id.submitButton)



        // Submit Button Action
        submitButton.setOnClickListener {
            val reviewText = reviewInput.text.toString()
            val ratingValue = ratingBar.rating

            if (reviewText.isBlank() || ratingValue == 0f) {
                Toast.makeText(this, "Please provide a review and rating!", Toast.LENGTH_SHORT).show()
            } else {
                // Process submission (e.g., save to database or send to server)
                // Here we simply display a success message
                Toast.makeText(this, "Successfully Submitted", Toast.LENGTH_SHORT).show()

                // Optionally clear the form after submission
                reviewInput.text.clear()
                ratingBar.rating = 0f
            }
        }
    }

}
