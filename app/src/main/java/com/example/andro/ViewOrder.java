package com.example.andro;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.TextView;

public class ViewOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);
        Intent intent = getIntent();
        String text2 = intent.getStringExtra("brand");
        String text3 = intent.getStringExtra("model");
        String text = intent.getStringExtra("name");
        String text1 = intent.getStringExtra("number");

        TextView textView2 = (TextView) findViewById(R.id.brandView);
        TextView textView3 = (TextView) findViewById(R.id.modelView);
        TextView textView = (TextView) findViewById(R.id.nameView);
        TextView textView1 = (TextView) findViewById(R.id.numberView);
        textView2.setText("Brand Phone: " + text2);
        textView3.setText("Model Phone: " + text3);
        textView.setText("Full Name: " + text);
        textView1.setText("Number Phone: " + text1);
    }
}