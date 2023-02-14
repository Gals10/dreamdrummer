package com.example.dreamdrummer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Advance extends AppCompatActivity {
        Button back, home, lesson, himom, songs, tips;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_advance);
            back = findViewById(R.id.btnback);
            home = findViewById(R.id.btnhome);
            himom = findViewById(R.id.btnhimom);
            songs = findViewById(R.id.btnsongs);
            tips = findViewById(R.id.btntips);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Advance.this, HomeActivity.class));
                }
            });
            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Advance.this, HomeActivity.class));
                }
            });
            himom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Advance.this, WarmUpAdvanced.class));
                }
            });
            songs.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Advance.this, SongsAdvanced.class));
                }
            });
            tips.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Advance.this, Createband.class));
                }
            });


        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.menu_main, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.menuitem_aboutapp:
                    Toast.makeText(this, "waiting...", Toast.LENGTH_LONG).show();
                    Intent me = new Intent(Advance.this, AboutMe.class);
                    startActivity(me);
                    return true;
                case R.id.menuitem_aboutme:
                    Toast.makeText(this, "waiting...", Toast.LENGTH_LONG).show();
                    Intent app = new Intent(Advance.this, AboutAPP.class);
                    startActivity(app);
                    return true;
                case R.id.menuitem_exit:
                    Toast.makeText(this, "exit", Toast.LENGTH_LONG).show();
                    onBackPressed();
                    return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @Override
        public void onBackPressed() {
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure you want to exit?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Advance.super.onBackPressed();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }
