package com.wonmirzo.arta.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wonmirzo.arta.databinding.ItemHistoryViewBinding
import com.wonmirzo.arta.db.entity.PermanentInfo

class HistoryItemAdapter(private var items: List<PermanentInfo>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HistoryItemViewHolder(ItemHistoryViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is HistoryItemViewHolder) {
            holder.onBind(item, position)
        }
    }

    override fun getItemCount(): Int = items.size

    inner class HistoryItemViewHolder(private var binding: ItemHistoryViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: PermanentInfo, position: Int) {
            binding.apply {
                tvNishonRaqami.text = item.otOchish?.nishonNumber
                tvNishonXarakteri.text = item.otOchish?.nishonXarakteri
                tvDate.text = item.date
            }
        }
    }
}