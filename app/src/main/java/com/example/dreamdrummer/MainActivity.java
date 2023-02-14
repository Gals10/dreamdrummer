package com.example.dreamdrummer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import static com.example.dreamdrummer.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button music;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        btn = findViewById(R.id.stam);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intSignUp = new Intent(MainActivity.this, SignUp.class);
                startActivity(intSignUp);
            }
        });

    }


}