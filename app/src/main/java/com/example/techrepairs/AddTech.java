package com.example.techrepairs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTech extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_tech, container, false);

        Button saveButton = (Button) view.findViewById(R.id.button);

        final EditText techName = (EditText) view.findViewById(R.id.name);
        final EditText techModel = (EditText) view.findViewById(R.id.model);
        final EditText techDescribe = (EditText) view.findViewById(R.id.describe);
        final EditText techPhone = (EditText) view.findViewById(R.id.price);

        EditText[] inputArr = {techName, techModel, techDescribe, techPhone};
        this.focusEdit(inputArr);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(view.getContext(), "Click",Toast.LENGTH_LONG);
                toast.show();
            }
        });

        return view;
    }

    private void focusEdit(EditText[] inputArr) {
        int length = inputArr.length;
        for(int i = 0; i < length; i++ ) {
            final EditText input = inputArr[i];
            input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean hasFocus) {
                    if (hasFocus) {
                        input.setBackgroundResource(R.drawable.edit_text_border);
                    }
                }
            });
        }
    }
}