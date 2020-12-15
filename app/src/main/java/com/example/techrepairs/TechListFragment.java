package com.example.techrepairs;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TechListFragment extends Fragment {
    String[] tech = { "Nokia 3310", "Xiaomi MI A3", "Iphone X", "Huawei P 30 Pro", "Nokia 3330"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tech_list, container, false);
        ListView contactsList = (ListView) view.findViewById(R.id.techList);
        final Intent intent = new Intent(view.getContext(), TechDetails.class);

        ArrayAdapter<String> adapter = new ArrayAdapter(view.getContext(),
                android.R.layout.simple_list_item_1, tech);

        contactsList.setAdapter(adapter);

        contactsList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                startActivity(intent);
            }
        });

        return  view;
    }
}