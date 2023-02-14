package com.example.dreamdrummer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SongsAdvanced extends AppCompatActivity {

    Button back,home;
    String s1[], s2[];
    int images[]={R.drawable.museups,R.drawable.seeuagain,R.drawable.halloffame,R.drawable.friends,R.drawable.countingstars,R.drawable.magic,R.drawable.thatwhati,R.drawable.animals,R.drawable.believer};
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
                startActivity(new Intent(SongsAdvanced.this, Advance.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SongsAdvanced.this, HomeActivity.class));
            }
        });

        s1=getResources().getStringArray(R.array.songsadv);
        s2=getResources().getStringArray(R.array.Descriptionadv);
        MyAdapter myAdapter= new MyAdapter(this, s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}