package com.udacity.shoestore.screens.shoeDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoeList.ShoeViewModel


class ShoeDetailFragment : Fragment() {

    private lateinit var binding : FragmentShoeDetailBinding
    private var myShoe : Shoe = Shoe("", "" , "", "")

    private val shoeViewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_shoe_detail, container, false)
        ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.shoe = myShoe

        //Out of the setOnClickListener because both onClick statement use the same action
        val action = ShoeDetailFragmentDirections.actionDetailFragmentToListFragment()

        binding.buttonsave.setOnClickListener{v : View ->

            // Genarate the new shoe model
            shoeViewModel.addShoeModel(myShoe)

            //Navigate to the shoe list again
            NavHostFragment.findNavController(this).navigate(action)
        }

        binding.buttoncancel.setOnClickListener { v: View ->
            NavHostFragment.findNavController(this).navigate(action)
            }
        return binding.root
    }

}