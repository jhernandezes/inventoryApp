package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.screens.login.LogingViewModel


class WelcomeFragment : Fragment() {

    private lateinit var binding : FragmentWelcomeBinding
    private val fragmentLogingViewModel: LogingViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_welcome, container, false)
        ViewModelProvider(this).get(LogingViewModel::class.java)
        binding.setLifecycleOwner(this)

        fragmentLogingViewModel.user_name.observe(viewLifecycleOwner, Observer { newName ->
            binding.welcomeFragmentUsername.text = newName
        })

        binding.welcomeFragmentSubmit.setOnClickListener{v : View ->
                val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
                NavHostFragment.findNavController(this).navigate(action)
        }
        return binding.root
    }


}