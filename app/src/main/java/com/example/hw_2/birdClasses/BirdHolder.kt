package com.example.hw_2.birdClasses

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.hw_2.R
import com.example.hw_2.databinding.ItemBirdBinding

class BirdHolder(
    private val binding: ItemBirdBinding,
    private val glide: RequestManager,
    private val onClick: (Int) -> Unit,
) : ViewHolder(binding.root) {

    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    private val context: Context
        get() = itemView.context

    fun onBind(birdId: Int) {
        binding.run {
            val bird = BirdRepository.birds[birdId]
            tvName.text = bird.name
            tvTypeAndAge.text = "${bird.type}, ${bird.age}"

            glide
                .load(bird.imageUrl)
                .error(R.drawable.baseline_airplanemode_active_24)
                .placeholder(R.drawable.baseline_airplanemode_active_24)
                .apply(requestOptions)
                .into(ivImage)

            root.setOnClickListener()
            {
                onClick(birdId)
            }
        }
    }
}