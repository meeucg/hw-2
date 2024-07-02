package com.example.hw_2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.hw_2.databinding.FragmentBirdBinding
import com.example.hw_2.birdClasses.*
import com.google.android.material.snackbar.Snackbar

class BirdFragment : Fragment(R.layout.fragment_bird) {

    private var binding: FragmentBirdBinding? = null

    private var adapter: BirdAdapter? = null

    private fun initAdapter() {
        binding?.run {
            adapter = BirdAdapter(
                list = BirdRepository.birds,
                glide = Glide.with(this@BirdFragment),
                onClick = {
                    findNavController().navigate(resId = R.id.action_birdFragment_to_birdProfileFragment,
                        BirdProfileFragment.bundle(it))
                    //Snackbar.make(root, BirdRepository.birds[it].name, Snackbar.LENGTH_LONG).show()
                }
            )

            rvBirds.adapter = adapter

            rvBirds.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBirdBinding.bind(view)
        initAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}