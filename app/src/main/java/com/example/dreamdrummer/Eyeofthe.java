package com.example.dreamdrummer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Eyeofthe extends AppCompatActivity {
Button back,pre,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eyeofthe);
        back= findViewById(R.id.btnback);
        pre=findViewById(R.id.btnprevious);
        next=findViewById(R.id.btnnext);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Eyeofthe.this, SongsBeginner.class));
            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Eyeofthe.this, miserymaroon.class));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Eyeofthe.this,Passengerlether.class));
            }
        });
    }
    }