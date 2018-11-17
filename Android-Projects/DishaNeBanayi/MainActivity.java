package com.example.infinity.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button b1 ;
    PopupMenu p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.popup);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = new PopupMenu(MainActivity.this, view);
                p.inflate(R.menu.menu1);
                p.show();

            }
        });
    }
    
}
