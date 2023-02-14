package com.example.dreamdrummer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class GameOver extends AppCompatActivity implements View.OnClickListener {


    Button home, playAgain;
    int score=0;
    private FirebaseFirestore db;
    TextView tvscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        this.db = FirebaseFirestore.getInstance();

        home = (Button) findViewById(R.id.btnhome);
        playAgain = (Button) findViewById(R.id.btnPlayAgain);
        tvscore= findViewById(R.id.tvscore);

        home.setOnClickListener(this);
        playAgain.setOnClickListener(this);

        Intent intent = getIntent();
        score = intent.getIntExtra("finalScores", 0);
        Toast.makeText(GameOver.this, "score" + score, Toast.LENGTH_SHORT).show();
        String string = "your final score: " + score;
        tvscore.setText(string);

    }


    @Override
    protected void onPause() {

        super.onPause();


    }

    @Override
    public void onClick(View v) {


        if (v == home) {
            Intent tohome = new Intent(this, HomeActivity.class);
            startActivity(tohome);
        }

        if (v == playAgain ) {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }

         class HandleAlertDialogListener implements DialogInterface.OnClickListener {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == -1) {
                    Intent intent = new Intent(GameOver.this, GameActivity.class);
                    startActivity(intent);
                }
            }
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuitem_aboutme:
                Toast.makeText(this, "waiting...", Toast.LENGTH_SHORT).show();
                Intent me = new Intent(GameOver.this, AboutMe.class);
                stopService(new Intent(GameOver.this, MyService.class));
                startActivity(me);
                return true;
            case R.id.menuitem_aboutapp:
                Toast.makeText(this, "waiting...", Toast.LENGTH_SHORT).show();
                Intent app = new Intent(GameOver.this, AboutAPP.class);
                stopService(new Intent(GameOver.this, MyService.class));
                startActivity(app);
                return true;
            case R.id.menuitem_exit:
                Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
                stopService(new Intent(GameOver.this, MyService.class));
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
                        finishAffinity();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
