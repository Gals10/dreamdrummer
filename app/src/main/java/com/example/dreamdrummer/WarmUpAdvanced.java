package com.example.dreamdrummer;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class WarmUpAdvanced extends AppCompatActivity {
    private MediaPlayer Mediaplayer;
    private Button play, Pause, back;
    private EditText bpm;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warm_up_advanced);
        Pause = findViewById(R.id.btnpause);
        play = findViewById(R.id.btnplay);
        bpm= findViewById(R.id.etbpm);
        back= findViewById(R.id.btnback);
        Mediaplayer = MediaPlayer.create(this, R.raw.metro);
        play.setClickable(true);

        play.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String string = bpm.getText().toString();
                if (!string.isEmpty())
                {
                    Integer val = Integer.parseInt(string);
                    if (val % 10 != 0 || val < 60 || val > 250) {
                        Toast.makeText(WarmUpAdvanced.this, "60-250 jumping by 10!", Toast.LENGTH_SHORT).show();
                    } else {
                        if (string.equals("60")) {
                            float speed = 1f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("70")) {
                            float speed = 1.1667f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("80")) {
                            float speed = 1.333f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("90")) {
                            float speed = 1.5f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("100")) {
                            float speed = 1.667f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("110")) {
                            float speed = 1.833f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("120")) {
                            float speed = 2f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("130")) {
                            float speed = 2.1667f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("140")) {
                            float speed = 2.333f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("150")) {
                            float speed = 2.5f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("160")) {
                            float speed = 2.667f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("170")) {
                            float speed = 2.833f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("180")) {
                            float speed = 3f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("190")) {
                            float speed = 3.1667f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("200")) {
                            float speed = 3.333f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("210")) {
                            float speed = 3.5f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("220")) {
                            float speed = 3.667f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.setLooping(true);

                        }
                        if (string.equals("230")) {
                            float speed = 3.833f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("240")) {
                            float speed = 4f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                        if (string.equals("250")) {
                            float speed = 4.1667f;
                            Mediaplayer.setPlaybackParams(Mediaplayer.getPlaybackParams().setSpeed(speed));
                            Mediaplayer.start();
                            Mediaplayer.setLooping(true);
                        }
                    }
                }
                else
                {
                    Toast.makeText(WarmUpAdvanced.this, "enter value", Toast.LENGTH_SHORT).show();
                }


            }
        });


        Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mediaplayer.reset();
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });
        Mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                releaseMediaPlayer();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overridePendingTransition(0, 0);
                startActivity(new Intent(WarmUpAdvanced.this, Advance.class));
                finish();
            }
        });
    }
    private void releaseMediaPlayer()
    {
        if (Mediaplayer!=null)
        {
            Mediaplayer.release();
            Mediaplayer=null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
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
                Intent me = new Intent(WarmUpAdvanced.this, AboutMe.class);
                startActivity(me);
                return true;
            case R.id.menuitem_aboutapp:
                Toast.makeText(this, "waiting...", Toast.LENGTH_SHORT).show();
                Intent app = new Intent(WarmUpAdvanced.this, AboutAPP.class);
                startActivity(app);
                return true;
            case R.id.menuitem_exit:
                Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
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