package com.example.infinity.fragment;

import android.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    
    Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);

    }

    public void switchFragment(View v){
        
        if(v == findViewById(R.id.btn1)){
            Fragment fr = new Fragment1();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.containerfrag, fr);
            ft.commit();
        }
        
        else if(v == findViewById(R.id.btn2)){
            Fragment fr = new Fragment2();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.containerfrag, fr);
            ft.commit();
        }
        
        else if(v == findViewById(R.id.btn3)){
            Fragment fr = new Fragment3();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.containerfrag, fr);
            ft.commit();
        }
    }

}
