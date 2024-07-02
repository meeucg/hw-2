package com.example.hw_2.birdClasses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.hw_2.databinding.ItemBirdBinding

class BirdAdapter(
    private var list: List<Bird>,
    private val glide: RequestManager,
    private val onClick: (Int) -> Unit,
) : RecyclerView.Adapter<BirdHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BirdHolder = BirdHolder(
        binding = ItemBirdBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        glide = glide,
        onClick = onClick,
    )

    override fun onBindViewHolder(holder: BirdHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = list.size

    /*fun updateDataset(newList: List<City>) {
        list = newList
        notifyDataSetChanged()
    }*/
}