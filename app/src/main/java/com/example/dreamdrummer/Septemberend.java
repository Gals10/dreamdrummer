package com.example.dreamdrummer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Septemberend extends AppCompatActivity {
    Button back,pre,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_septemberend);
        back= findViewById(R.id.btnback);
        pre=findViewById(R.id.btnprevious);
        next=findViewById(R.id.btnnext);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Septemberend.this, SongsBeginner.class));
            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Septemberend.this,Clocks.class));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Septemberend.this,Havana.class));
            }
        });
    }
}