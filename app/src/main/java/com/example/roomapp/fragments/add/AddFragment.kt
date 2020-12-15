package com.example.roomapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.roomapp.R
import com.example.roomapp.data.ClientDatabase
import com.example.roomapp.model.Client
import com.example.roomapp.viewmodel.ClientViewModel
import com.example.roomapp.viewmodel.ClientsViewModelFactory
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mClientsViewModelFactory: ClientsViewModelFactory
    private lateinit var mClientViewModel: ClientViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = ClientDatabase.getDatabase(application).ClientDao()

        mClientsViewModelFactory = ClientsViewModelFactory(dataSource, application)
        mClientViewModel = ViewModelProviders.of(this, mClientsViewModelFactory).get(ClientViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val modelPhone = addmodelPhone_et.text.toString()
        val troubleshoot = addtroubleshoot_et.text.toString()
        val price = addprice_et.text.toString()

        if(inputCheck(modelPhone, troubleshoot, price)){
            // Create User Object
            val client = Client(
                0,
                modelPhone,
                troubleshoot,
                price
            )
            // Add Data to Database
            mClientViewModel.addClients(client)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(modelPhone: String, troubleshoot: String, price: String): Boolean{
        return !(TextUtils.isEmpty(modelPhone) && TextUtils.isEmpty(troubleshoot) && TextUtils.isEmpty(price))
    }

}