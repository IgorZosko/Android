package com.example.techrepairs.addtech;

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.techrepairs.R
import com.example.techrepairs.databinding.FragmentAddTechBinding
import timber.log.Timber


class AddTechFragment : Fragment() {

    private lateinit var binding: FragmentAddTechBinding
    private lateinit var viewModel: AddTechViewModel
    private lateinit var viewModelFactory: AddTechViewModelFactory

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

            binding = DataBindingUtil.inflate(
                    inflater,
                    R.layout.fragment_add_tech,
                    container,
                    false
            )

            Timber.i("Called ViewModelProviders.of!");

            viewModelFactory = AddTechViewModelFactory()
            viewModel = ViewModelProviders.of(this, viewModelFactory).get(AddTechViewModel::class.java)

            binding.addTechViewModel = viewModel
            binding.setLifecycleOwner(this)

        return binding.root;
    }
}