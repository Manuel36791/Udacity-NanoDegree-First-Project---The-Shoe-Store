package com.example.udacitynanodegreefirstproject_theshoestore.Shoe_list_screen

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.udacitynanodegreefirstproject_theshoestore.R
import com.example.udacitynanodegreefirstproject_theshoestore.ViewModel.AppViewModel
import com.example.udacitynanodegreefirstproject_theshoestore.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: AppViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)

        viewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            shoes?.let {
                displayShoes(it)
            }
        })

        binding.fab.setOnClickListener {
            it.findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_shoe_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun displayShoes(shoes: List<Shoe>) {
        shoes.forEach { displayShoe(it) }
    }

    private fun displayShoe(shoe: Shoe) {
        val listItemShoeBinding: ListItemShoeBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_shoe, null, false)

        listItemShoeBinding.nameTextView.text = getString(R.string.stringValue, "Shoe name:", shoe.name)
        listItemShoeBinding.companyTextView.text = getString(R.string.stringValue, "Company name:", shoe.company)
        listItemShoeBinding.sizeTextView.text = getString(R.string.doubleValue, "Shoe size:", shoe.size)
        listItemShoeBinding.descriptionTextView.text = getString(R.string.stringValue, "Description:", shoe.description)

        binding.linearLayout.addView(listItemShoeBinding.root)
    }
}