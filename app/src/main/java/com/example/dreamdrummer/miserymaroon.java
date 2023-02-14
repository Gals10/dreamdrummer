package com.example.dreamdrummer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class miserymaroon extends AppCompatActivity {
    Button back, pre,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_miserymaroon);
        back= findViewById(R.id.btnback);
        pre=findViewById(R.id.btnprevious);
        next=findViewById(R.id.btnnext);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(miserymaroon.this, SongsBeginner.class));
            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(miserymaroon.this, imaginejhon.class));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(miserymaroon.this, Eyeofthe.class));
            }
        });
    }
}