package com.example.techrepairs.techlist;

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.techrepairs.R
import com.example.techrepairs.techdetails.TechDetails


class TechListFragment : Fragment() {

    private lateinit var viewModel: TechListViewModel
    private  lateinit var viewModelFactory: TechListViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view : View = inflater?.inflate(R.layout.fragment_tech_list, container, false);

        viewModelFactory = TechListViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TechListViewModel::class.java)


        var techList:ListView =  view?.findViewById(R.id.techList);

        var adapter = ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1, viewModel.tech);

        techList.setAdapter(adapter);
        techList.setOnItemClickListener { parent, view, position, id ->
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.activity_main, TechDetails())?.commit()
         }

        return  view;
    }
}