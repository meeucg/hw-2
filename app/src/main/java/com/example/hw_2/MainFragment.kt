package com.example.hw_2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw_2.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar

class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding?.run {
            pressMeBtn.setOnClickListener {

                val text = etText.text

                if(text?.isEmpty() != true)
                {

                    findNavController().navigate(
                        resId = R.id.action_mainFragment_to_additionalFragment,
                        args = AdditionalFragment.bundle(text.toString())
                    )
                }
                else
                {
                    Snackbar.make(
                        root, "Введите текст", Snackbar.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}