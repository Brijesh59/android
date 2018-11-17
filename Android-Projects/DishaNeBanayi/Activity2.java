package com.example.infinity.basics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView t1 , t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        t1 = findViewById(R.id.tname);
        t2 = findViewById(R.id.tname2);
        Intent i = getIntent();
        String text =  i.getStringExtra("NAME");
        int id = i.getIntExtra("ID",0);
        t1.setText(text);
        t2.setText(""+id);
    }
}
