package com.example.summary8.presentation.screen.tour

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.summary8.databinding.ItemTourBinding
import com.example.summary8.presentation.model.Tour

class TourViewPagerAdapter :
    ListAdapter<Tour, TourViewPagerAdapter.TourViewHolder>(TourDiffCallback()) {
    inner class TourViewHolder(private val binding: ItemTourBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tour: Tour) = with(binding) {
            Glide.with(itemView.context)
                .load(tour.cover)
                .into(ivImage)
            tvLocation.text = tour.location
            tvPrice.text = tour.price
            tvReactions.text = tour.reactionCount.toString()
            tvTitle.text = tour.title
            rbRating.rating = tour.rate?.toFloat() ?: 0.0F
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TourViewHolder(
        ItemTourBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}