package com.example.hw_2.birdClasses

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.hw_2.R
import com.example.hw_2.databinding.FragmentBirdProfileBinding

class BirdProfileFragment : Fragment(R.layout.fragment_bird_profile) {

    private var binding: FragmentBirdProfileBinding? = null
    private val requestOptions = RequestOptions
        .diskCacheStrategyOf(
            DiskCacheStrategy.ALL
        )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBirdProfileBinding.bind(view)

        val id = arguments?.getInt(ARG_ID) ?: 0
        val glide = Glide.with(this@BirdProfileFragment)
        val bird = BirdRepository.birds[id]

        binding?.apply()
        {
            tvTitle.text = bird.name
            tvDescription.text = "${bird.type}, ${bird.age}"

            glide
                .load(bird.imageUrl)
                .error(R.drawable.baseline_airplanemode_active_24)
                .placeholder(R.drawable.baseline_airplanemode_active_24)
                .apply(requestOptions)
                .into(ivBird)

            backBtn.setOnClickListener()
            {
                findNavController().navigate(R.id.action_birdProfileFragment_to_birdFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val ARG_ID = "ARG_ID"

        fun bundle(id: Int): Bundle = Bundle().apply()
        {
            putInt(ARG_ID, id)
        }
    }
}