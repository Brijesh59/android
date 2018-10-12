package com.example.infinity.intentexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {

    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        t1 = findViewById(R.id.message);

        Intent i = getIntent();

        String userName = i.getStringExtra("name");
        int marks = i.getIntExtra("marks", 0);

        t1.setText("User: " + userName + "\n" + "Marks: " + marks);
    }
}
