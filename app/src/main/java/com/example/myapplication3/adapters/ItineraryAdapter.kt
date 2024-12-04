package com.example.myapplication3.adapters


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication3.R
import com.example.myapplication3.models.Itinerary

class ItineraryAdapter(
    private val activities: MutableList<Itinerary>,
    private val onDeleteClick: (Itinerary) -> Unit
) : RecyclerView.Adapter<ItineraryAdapter.ActivityViewHolder>() {

    inner class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvDay: TextView = itemView.findViewById(R.id.tvDay)
        val tvTime: TextView = itemView.findViewById(R.id.tvTime)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val btnDelete: Button = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itinerary_item_layout, parent, false)
        return ActivityViewHolder(view)
    }

    @SuppressLint("SetTextI18n", "NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val activity = activities[position]
        holder.tvDay.text = activity.day.toString()
        holder.tvTime.text = activity.time
        holder.tvDescription.text = activity.description

        holder.btnDelete.setOnClickListener {
            onDeleteClick(activity)
            notifyDataSetChanged()  // Refresh the RecyclerView to reflect the deleted item
        }
    }

    override fun getItemCount(): Int = activities.size
}
