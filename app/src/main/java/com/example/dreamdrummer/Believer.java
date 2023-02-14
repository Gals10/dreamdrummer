package com.example.dreamdrummer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Believer extends AppCompatActivity {
    Button back,pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_believer);
        back= findViewById(R.id.btnback);
        pre=findViewById(R.id.btnprevious);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Believer.this, SongsAdvanced.class));
            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Believer.this,Animals.class));
            }
        });
    }
}