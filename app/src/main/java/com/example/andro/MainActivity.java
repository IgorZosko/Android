package com.example.andro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.FrameLayout;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   public  void onClick(View view){
        EditText editText = (EditText) findViewById(R.id.textEdit);
        String editText1 = editText.getText().toString();

        Toast toast = Toast.makeText(this, "Hello " + editText1, Toast.LENGTH_SHORT);;
        toast.show();

        Intent intent = new Intent(this, SetActivity.class);
        startActivity(intent);
   }
}