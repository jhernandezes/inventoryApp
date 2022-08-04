package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ArrayAdapter
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.MyAdapter
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_list.view.*


class ShoeListFragment : Fragment() {

    private lateinit var binding : FragmentShoeListBinding
    private val shoeViewModel: ShoeViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //This fragment share the ViewModel with shoe detail fragment
        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_shoe_list, container, false)
        ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.setLifecycleOwner(this)

        // Set options menu
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.overflow_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.Logout_item -> {
                        NavHostFragment.findNavController(requireParentFragment()).navigate(ShoeListFragmentDirections.actionListFragmentToLoginFragment())
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)


        // Observe the list changes
        shoeViewModel.shoe_list.observe(viewLifecycleOwner) { list ->
            var myAdapter = MyAdapter(requireActivity(), list)
            binding.listView.adapter = myAdapter
        }

        binding.addShoeButton.setOnClickListener { v: View ->
            NavHostFragment.findNavController(this).navigate(ShoeListFragmentDirections.actionListFragmentToDetailFragment())
        }

        return binding.root
    }

    }

