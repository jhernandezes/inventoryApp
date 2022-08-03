package com.udacity.shoestore.screens.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInformationBinding
import com.udacity.shoestore.screens.login.LogingFragmentDirections
import com.udacity.shoestore.screens.login.LogingViewModel


class InformationFragment : Fragment() {

    private lateinit var binding: FragmentInformationBinding
    private  val viewModel: LogingViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_information, container, false)
        ViewModelProvider(this).get(LogingViewModel::class.java)
        binding.logingViewModel = viewModel
        binding.lifecycleOwner = this

        binding.button.setOnClickListener{v : View ->
            val action = InformationFragmentDirections.actionInformationFragmentToListFragment()
            NavHostFragment.findNavController(this).navigate(action)
        }
        return binding.root
    }

}