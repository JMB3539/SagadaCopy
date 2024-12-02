package com.example.myapplication3


import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.adapters.ItineraryAdapter
import com.example.myapplication3.models.*
import com.example.myapplication3.adapters.ConcreteItineraryAdapter

class ItineraryPlanner : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItineraryAdapter
    private lateinit var backButtonImage: ImageView
    private val itineraryItems = mutableListOf<Any>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.itinerary_activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        backButtonImage = findViewById(R.id.backButtonImage)
        adapter = ConcreteItineraryAdapter(itineraryItems)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Back Button Action
        backButtonImage.setOnClickListener {
            // Navigate back to the previous screen
            finish() // Ends the current activity
        }

        // Add initial items
        itineraryItems.addAll(
            listOf(
                TouristSpot("Bokong Falls", "A beautiful waterfall perfect for a dip."),
                TouristSpot("Sumaguing Cave", "A popular cave for spelunking."),
                TouristSpot("Echo Valley", "Famous for its stunning views and echoes."),
                Restaurant("Log Cabin", "American"),
                Restaurant("Taste of Sagada", "Local Cuisine"),
                Restaurant("Bana's Café", "International"),
                Accommodation("The Homestay", "Guesthouse"),
                Accommodation("Sagbayan Mountain Resort", "Resort"),
                Accommodation("Ganduyan Inn", "Inn")
            )
        )
        adapter.notifyDataSetChanged()

        // Set up drag and drop
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.UP or ItemTouchHelper.DOWN) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                val fromPosition = viewHolder.adapterPosition
                val toPosition = target.adapterPosition
                itineraryItems.swap(fromPosition, toPosition)
                adapter.notifyItemMoved(fromPosition, toPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                // No swipe actions needed
            }
        })

        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun MutableList<Any>.swap(fromPosition: Int, toPosition: Int) {
        val temp = this[fromPosition]
        this[fromPosition] = this[toPosition]
        this[toPosition] = temp
    }
}