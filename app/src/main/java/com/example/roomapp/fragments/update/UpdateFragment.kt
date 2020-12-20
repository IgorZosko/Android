package com.example.roomapp.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomapp.R
import com.example.roomapp.data.ClientDatabase
import com.example.roomapp.model.Client
import com.example.roomapp.viewmodel.ClientViewModel
import com.example.roomapp.viewmodel.ClientsViewModelFactory
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mClientsViewModelFactory: ClientsViewModelFactory
    private lateinit var mClientViewModel: ClientViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = ClientDatabase.getDatabase(application).ClientDao()

        mClientsViewModelFactory = ClientsViewModelFactory(dataSource, application)
        mClientViewModel = ViewModelProviders.of(this, mClientsViewModelFactory).get(ClientViewModel::class.java)

        view.updatemodelPhone_et.setText(args.currentClient.modelPhone)
        view.updatetroubleshoot_et.setText(args.currentClient.troubleshoot)
        view.updateprice_et.setText(args.currentClient.price)

        view.update_btn.setOnClickListener {
            updateItem()
        }

        // Add menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem() {
        val modelPhone = updatemodelPhone_et.text.toString()
        val troubleshoot = updatetroubleshoot_et.text.toString()
        val price = updateprice_et.text.toString()

        if (inputCheck(modelPhone, troubleshoot, price)) {
            // Create Client Object
            val updatedClient = Client(args.currentClient.id, modelPhone, troubleshoot, price)
            // Update Current Client
            mClientViewModel.updateClients(updatedClient)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun inputCheck(modelPhone: String, troubleshoot: String, price: String): Boolean {
        return !(TextUtils.isEmpty(modelPhone) && TextUtils.isEmpty(troubleshoot) && TextUtils.isEmpty(price))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteClients()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteClients() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            mClientViewModel.deleteClients(args.currentClient)
            Toast.makeText(
                requireContext(),
                "Successfully removed: ${args.currentClient.modelPhone}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentClient.modelPhone}?")
        builder.setMessage("Are you sure you want to delete ${args.currentClient.modelPhone}?")
        builder.create().show()
    }
}