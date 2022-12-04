package com.ono.androidassessment.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ono.androidassessment.UserAgeModel
import com.ono.androidassessment.databinding.HistoryItemLayoutBinding

class HistoryRVAdapter : RecyclerView.Adapter<HistoryRVAdapter.Holder>() {

    private var spots: MutableList<UserAgeModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(HistoryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val spot = spots[position]
        holder.binding.userAgeModel = spot
    }

    override fun getItemCount(): Int {
        return spots.size
    }

    fun submitData(recyclerView: RecyclerView, spots: MutableList<UserAgeModel>) {
        this.spots.clear()
        if (spots.isNotEmpty()) {
            this.spots.addAll(spots)
            notifyDataSetChanged()
        }
    }

    inner class Holder(val binding: HistoryItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}