package com.example.dreamdrummer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LessonsAdvanced extends AppCompatActivity {
    Button back, home;
    String s1[], s2[];
    int images[] = {R.drawable.beatsone, R.drawable.beatstwo, R.drawable.beatsthree, R.drawable.beatsfour, R.drawable.fillsone, R.drawable.fillstwo, R.drawable.fillsthree, R.drawable.fillsfour, R.drawable.fillsfive};
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_beginner);
        back = findViewById(R.id.btnback);
        home = findViewById(R.id.btnhome);
        recyclerView = findViewById(R.id.recyclerView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonsAdvanced.this, Advance.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonsAdvanced.this, HomeActivity.class));
            }
        });

        s1 = getResources().getStringArray(R.array.lessons);
        s2 = getResources().getStringArray(R.array.description);
        MyAdapter myAdapter = new MyAdapter(this, s1, s2, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}