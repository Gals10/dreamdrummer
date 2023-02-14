package com.example.dreamdrummer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TavBeginner extends AppCompatActivity {
    Button next,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tav_beginner);
        next=findViewById(R.id.btnnext);
        back= findViewById(R.id.btnback);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TavBeginner.this, LessonBeginner.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TavBeginner.this, Begin.class));
            }
        });
    }
}