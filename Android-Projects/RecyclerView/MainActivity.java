package com.example.infinity.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     RecyclerView recyclerView;
     ArrayList<String> names = new ArrayList<>();
     ArrayList<Integer> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names.add("Javascript");
        names.add("Java");
        names.add("Python");
        names.add("C++");
        names.add("Scala");
        names.add("Shell Scripting");

        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_launcher_foreground);
        images.add(R.drawable.ic_launcher_foreground);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CustomListAdapter(names,images));

    }
}
