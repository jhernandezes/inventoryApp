package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
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

        // Observe the list changes so the show list is always update
        shoeViewModel.shoe_list.observe(viewLifecycleOwner) { list ->
            var myAdapter = MyAdapter(requireActivity(), list)
            binding.listView.adapter = myAdapter
        }

        binding.addShoeButton.setOnClickListener { v: View ->
            NavHostFragment.findNavController(this).navigate(ShoeListFragmentDirections.actionListFragmentToDetailFragment())
        }

        binding.logoutButton.setOnClickListener { v: View ->
            NavHostFragment.findNavController(this).navigate(ShoeListFragmentDirections.actionListFragmentToLoginFragment())
        }
        return binding.root
    }


    }

