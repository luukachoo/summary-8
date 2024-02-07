package com.example.summary8.presentation.screen.tour

import androidx.recyclerview.widget.DiffUtil
import com.example.summary8.presentation.model.Tour

class TourDiffCallback : DiffUtil.ItemCallback<Tour>() {
    override fun areItemsTheSame(oldItem: Tour, newItem: Tour): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Tour, newItem: Tour): Boolean = oldItem == newItem
}