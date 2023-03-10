package com.example.udacitynanodegreefirstproject_theshoestore.Insturction_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.udacitynanodegreefirstproject_theshoestore.ViewModel.AppViewModel
import com.example.udacitynanodegreefirstproject_theshoestore.databinding.FragmentInstructionBinding


class InstructionFragment: Fragment() {

    private lateinit var binding: FragmentInstructionBinding
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentInstructionBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel

        viewModel.eventShowShoeListScreen.observe(viewLifecycleOwner, Observer { showShoeListScreen ->
            showShoeListScreen?.let {
                if (it) {
                    findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
                    viewModel.onEventShowShowListScreenComplete()
                }
            }
        })

        return binding.root
    }
}