package com.example.dreamdrummer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LessonBeginner extends AppCompatActivity {
    Button back,home;
    String s1[], s2[];
    int images[]={R.drawable.beatsone,R.drawable.beatstwo,R.drawable.beatsthree};
   RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_beginner);
        back= findViewById(R.id.btnback);
        home= findViewById(R.id.btnhome);
        recyclerView = findViewById(R.id.recyclerView);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonBeginner.this, Begin.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LessonBeginner.this, HomeActivity.class));
            }
        });

        s1=getResources().getStringArray(R.array.lessons);
        s2=getResources().getStringArray(R.array.description);
        MyAdapterLess myAdapterLess=new MyAdapterLess(this, s1,s2,images);
        recyclerView.setAdapter(myAdapterLess);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}