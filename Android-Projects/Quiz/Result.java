package com.example.infinity.quiz02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {

    TextView scoreText, statusText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreText = findViewById(R.id.score);
        statusText = findViewById(R.id.status);

        Intent i = getIntent();
        int score = i.getIntExtra("score", 0);
        String status = i.getStringExtra("status");

        scoreText.setText("" + score);
        statusText.setText(status);

    }
}
