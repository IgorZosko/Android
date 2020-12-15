package com.example.techrepairs.techdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.techrepairs.R
import com.example.techrepairs.databinding.FragmentTechDetailsBinding


class TechDetails: Fragment() {
    private lateinit var binding: FragmentTechDetailsBinding
    private lateinit var viewModel: TechDetailsViewModel
    private lateinit var viewModelFactory: TechDetailsViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_tech_details,
                container,
                false
        )

        viewModelFactory = TechDetailsViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TechDetailsViewModel::class.java)

        binding.techDetailsViewModel = viewModel
        binding.setLifecycleOwner(this)

        return  binding.root
    }
}