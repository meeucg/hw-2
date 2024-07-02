package com.example.hw_2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw_2.databinding.FragmentAdditionalBinding

class AdditionalFragment : Fragment(R.layout.fragment_additional) {

    private var binding: FragmentAdditionalBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAdditionalBinding.bind(view)

        val textFromMain = arguments?.getString(ARG_TEXT)

        binding?.apply()
        {
            tvTitle.text = textFromMain

            backBtn.setOnClickListener()
            {
                findNavController().navigate(R.id.action_additionalFragment_to_mainFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {

        private const val ARG_TEXT = "ARG_TEXT"

        fun bundle(text: String): Bundle = Bundle().apply()
        {
            putString(ARG_TEXT, text)
        }
    }
}