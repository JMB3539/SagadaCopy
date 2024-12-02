package com.example.myapplication3

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.adapters.FAQAdapter

class MainActivityFAQs : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var faqAdapter: FAQAdapter
    private lateinit var faqLayout: LinearLayout

    private val faqs = listOf(
        FAQ("How do I get to Sagada?", "• To reach Sagada, travel from Manila to Baguio City by bus (around 6-8 hours). From Baguio, take a bus or van to Sagada (approximately 5-6 hours).\n• There are also direct bus services from Manila to Sagada (Coda Lines)."),
        FAQ("What local transportation options are available in Sagada?", "• Tricab.\n• PUJ.\n• Shuttle jeep/s."),
        FAQ("What are the must-see attractions in Sagada?", "• Hanging Coffins.\n• Sumaguing Cave.\n• Echo Valley.\n• Bomod-ok Falls.\n• Pog-o Viewpoint for stunning sunrise views."),
        FAQ("Are there any local events or festivals in Sagada?", "• Sagada hosts major and minor events."),
        FAQ("Where can I find local dining options in Sagada?", "• A range of dining options, from local eateries to cafes and restaurants.\n• Popular spots include Café Yagam and Sagada Lemon Pie House."),
        FAQ("What should I know about local customs and etiquette?", "• Respect local customs, especially regarding sacred sites.\n• Always ask for permission before taking photos.\n• Dress modestly."),
        FAQ("How do I stay safe while exploring Sagada?", "• Follow safety guidelines provided by your guides.\n• Wear appropriate footwear and bring enough water."),
        FAQ("Where can I get assistance or emergency services in Sagada?", "• The local police station and hospital can provide emergency assistance."),
        FAQ("How can I manage my budget while traveling in Sagada?", "• Set a budget for accommodation, meals, and activities.\n• Look for budget-friendly lodging and local eateries."),
        FAQ("How can I find local shopping areas or markets in Sagada?", "• Local markets sell souvenirs, crafts, and local products.\n• Visit the public market for fresh produce."),
        FAQ("Are there any language barriers in Sagada?", "• English is widely spoken, but learning a few phrases in Filipino can be helpful."),
        FAQ("How can I ensure I’m prepared for the weather in Sagada?", "• Sagada has a cooler climate; pack layered clothing.\n• Bring waterproof gear during the rainy season.")
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_faq)

        faqLayout = findViewById(R.id.faqLayout)

        for (faq in faqs) {
            val questionTextView = TextView(this).apply {
                text = faq.question
                textSize = 16f
                setTypeface(typeface, android.graphics.Typeface.BOLD)
                setBackgroundColor(Color.parseColor("#B3E5FC")) // Light Blue
                setPadding(16, 16, 16, 8) // Padding
            }

            val answerTextView = TextView(this).apply {
                text = faq.answer //Answer with bullet points
                textSize = 14f
                setBackgroundColor(Color.parseColor("#FFEB3B")) // Bright Yellow
                setPadding(16, 8, 16, 16) // Padding
            }

            // Add padding view before each answer for visual separation
            val paddingView = TextView(this).apply {
                setBackgroundColor(Color.parseColor("#C8E6C9")) // Light Green
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    16 // Padding height
                )
            }

            faqLayout.addView(questionTextView)
            faqLayout.addView(answerTextView)
            faqLayout.addView(paddingView)
        }


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        faqAdapter = FAQAdapter(faqs)
        recyclerView.adapter = faqAdapter
    }

    data class FAQ(
        val question: String,
        val answer: String
    )
}


