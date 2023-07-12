package com.example.aksaraapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aksaraapp.databinding.ItemVoucherBinding

class VoucherAdapter(private val data: List<Int>): RecyclerView.Adapter<VoucherAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VoucherAdapter.ViewHolder {
        val binding =
            ItemVoucherBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VoucherAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(private val binding: ItemVoucherBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(imageVoucher: Int){
            Glide.with(itemView.context)
                .load(imageVoucher)
                .into(binding.imageVoucher)
        }
    }
}



