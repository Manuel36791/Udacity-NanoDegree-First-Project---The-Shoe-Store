package com.example.udacitynanodegreefirstproject_theshoestore.Welcome_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.udacitynanodegreefirstproject_theshoestore.ViewModel.AppViewModel
import com.example.udacitynanodegreefirstproject_theshoestore.databinding.FragmentWelcomeBinding



class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel

        viewModel.eventShowInstructionScreen.observe(viewLifecycleOwner, Observer { showInstructionScreen ->
            showInstructionScreen?.let {
                if (it) {
                    findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())

                    viewModel.onEventShowInstructionScreenComplete()
                }
            }
        })

        return binding.root
    }
}