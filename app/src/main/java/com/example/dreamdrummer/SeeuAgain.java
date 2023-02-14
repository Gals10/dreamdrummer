package com.example.dreamdrummer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SeeuAgain extends AppCompatActivity {
Button back,pre,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeu_again);
        back= findViewById(R.id.btnback);
        next=findViewById(R.id.btnnext);
        pre=findViewById(R.id.btnprevious);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeeuAgain.this, SongsAdvanced.class));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeeuAgain.this, Hallof.class));
            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeeuAgain.this,Museups.class));
            }
        });
    }
}