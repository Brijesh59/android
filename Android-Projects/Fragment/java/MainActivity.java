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

//    public static class Frag1 extends Fragment1{
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            // Inflate the layout for this fragment
//            return inflater.inflate(R.layout.fragment_fragment1, container, false);
//        }
//
//    }
//
//    public static class Frag2 extends Fragment2{
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            // Inflate the layout for this fragment
//            return inflater.inflate(R.layout.fragment_fragment2, container, false);
//        }
//
//    }

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
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.containerfrag, new Fragment1());
            tx.commit();
        }
        else if(v == findViewById(R.id.btn2)){
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.containerfrag, new Fragment2());
            tx.commit();
        }
        else if(v == findViewById(R.id.btn3)){
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.containerfrag, new Fragment3());
            tx.commit();
        }
    }

}
