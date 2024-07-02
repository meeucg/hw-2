package com.example.hw_2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.hw_2.databinding.FragmentBirdBinding

class BirdFragment : Fragment(R.layout.fragment_bird) {

    private var binding: FragmentBirdBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBirdBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}