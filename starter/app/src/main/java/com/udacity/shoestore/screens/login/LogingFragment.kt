package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLogingBinding

/**
 * This is the Login Fragment, two types of cases, the user login with a existing account
 * or login with a existing one
 */

class LogingFragment : Fragment() {

    private lateinit var binding: FragmentLogingBinding
    private  val viewModel: LogingViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_loging, container, false)

        ViewModelProvider(this).get(LogingViewModel::class.java)
        binding.logingViewModel = viewModel
        binding.lifecycleOwner = this


        binding.buttonLogin.setOnClickListener{v : View ->
            if (!viewModel.user_name.value.isNullOrEmpty()) {
                val action = LogingFragmentDirections.actionLoginFragmentToWelcomeFragment()
                NavHostFragment.findNavController(this).navigate(action)
            }else{
                Toast.makeText(context, "Before proceeding you must fill in the password and email fields.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonRegister.setOnClickListener{v : View ->
            if (!viewModel.user_name.value.isNullOrEmpty() && !viewModel.password.value.isNullOrEmpty() ) {
                val action = LogingFragmentDirections.actionLoginFragmentToWelcomeFragment()
                NavHostFragment.findNavController(this).navigate(action)
            }else{
                Toast.makeText(context, "Before proceeding you must fill in the password and email fields.", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }


}


