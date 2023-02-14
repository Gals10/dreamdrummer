package com.example.dreamdrummer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Lessthree extends AppCompatActivity {
Button back,pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessthree);
        back= findViewById(R.id.btnback);
        pre=findViewById(R.id.btnprevious);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lessthree.this, LessonBeginner.class));
            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lessthree.this, Lesstwo.class));
            }
        });
    }
}