package com.example.udacitynanodegreefirstproject_theshoestore.Shoe_details_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.udacitynanodegreefirstproject_theshoestore.ViewModel.AppViewModel


class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentShoeDetailBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        viewModel.createNewShoe()

        viewModel.eventCloseScreen.observe(viewLifecycleOwner, Observer { close ->
            close?.let {
                if (it) {
                    findNavController().navigateUp()
                    viewModel.onEventCloseComplete()
                }
            }
        })

        return binding.root
    }
}