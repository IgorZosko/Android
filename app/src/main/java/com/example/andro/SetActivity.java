package com.example.andro;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class SetActivity extends AppCompatActivity {
    Spinner dropList, dropList1;
    String selectMark;
    boolean add = true;
    private static  final int REQUEST_ACCESS_TYPE=1;
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> list1 = new ArrayList<>();
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_activity);
        Intent intent = getIntent();
       //Скриваємо наші елементи
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tl);
        tableLayout.setVisibility(View.GONE);

    }

    public void onClick(View view){
        TableLayout tableLayout = (TableLayout) findViewById(R.id.tl);
      //При нажаманні кнопку добавити появляються наші елементи
        if(add){
            tableLayout.setVisibility(View.VISIBLE);
            add = false;
        }
        else{
            tableLayout.setVisibility(View.GONE);
            add = true;
        }

        dropList = (Spinner)findViewById(R.id.droplist);
        dropList1 = (Spinner)findViewById(R.id.droplist1);
        dropList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectBrand = parent.getItemAtPosition(position).toString();
                switch (selectBrand) {
                    case "iPhone":
                        dropList1.setAdapter(new ArrayAdapter<String>(SetActivity.this, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.items_div_class_1)));
                        break;
                    case "Samsung":
                        dropList1.setAdapter(new ArrayAdapter<String>(SetActivity.this, R.layout.support_simple_spinner_dropdown_item, getResources().getStringArray(R.array.items_div_class_2)));
                        break;
                }
                dropList1.setVisibility(View.VISIBLE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        dropList1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectMark = parent.getItemAtPosition(position).toString();;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void AddOrder(View view){
        EditText editText = (EditText) findViewById(R.id.textEdit);
        String text = editText.getText().toString();
        EditText editText1 = (EditText) findViewById(R.id.textEdit1);
        String text1 = editText1.getText().toString();

        Spinner spinner = (Spinner) findViewById(R.id.droplist);
        String dropList = spinner.getSelectedItem().toString();
        Spinner spinner1 = (Spinner) findViewById(R.id.droplist1);
        String dropList1 = spinner1.getSelectedItem().toString();

        Intent intent = new Intent(this, ViewOrder.class);
        intent.putExtra("brand", dropList);
        intent.putExtra("model", dropList1);
        intent.putExtra("name",text);
        intent.putExtra("number",text1);
        startActivity(intent);
    }
}