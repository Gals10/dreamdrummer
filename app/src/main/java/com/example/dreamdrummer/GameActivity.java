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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

//import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    Button raid;
    Button crash;
    Button tamtam;
    Button snare;
    Button hayet;
    Button bas;
    String drum;
    String[] drums = {"רייד", "טמטם", "קראש", "הייט", "בס", "סנייר"};
    TextView showGeneratedDrum;
    TextView textViewLeft;
    TextView textViewScores;
    int useFifty=0;
    int scores=0;
    int left=6;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        showGeneratedDrum = (TextView) findViewById(R.id.generated);
        raid = (Button) findViewById(R.id.btnraid);
        crash = (Button) findViewById(R.id.btncrash);
        tamtam = (Button) findViewById(R.id.btntamtam);
        snare = (Button) findViewById(R.id.btnsnare);
        hayet = (Button) findViewById(R.id.btnhayhet);
        bas = (Button) findViewById(R.id.btnbas);
        textViewScores = (TextView) findViewById(R.id.scores);
        textViewLeft=(TextView) findViewById(R.id.left);
        back= (Button) findViewById(R.id.btnback);

        raid.setOnClickListener(this);
        crash.setOnClickListener(this);
        tamtam.setOnClickListener(this);
        snare.setOnClickListener(this);
        hayet.setOnClickListener(this);
        bas.setOnClickListener(this);
        showDrumLeft();
        ShowScores();
        deleteDrum(drums);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameActivity.this, HomeActivity.class));
                finish();
            }
        });
    }



    @Override
    public void onClick(View v) {
        if (v == tamtam && drum.equals("טמטם") || v == bas && drum.equals("בס") || v == snare && drum.equals("סנייר") || v == crash && drum.equals("קראש") || v == hayet && drum.equals("הייט") || v == raid && drum.equals("רייד") )
        {
            Intent intent = new Intent(this, TriviaActivity.class);
            intent.putExtra("generatedDrum", showGeneratedDrum.getText().toString());    //שולח בשביל להתאים את התוף שנבחרה לשאלות
            intent.putExtra("checkleftDrum", drums);//שולח כדי לבדוק אם יש עוד תופים שנשארו להגריל
            scores = Integer.parseInt(textViewScores.getText().toString());
            intent.putExtra("scores", scores);// שולח כדי להוסיף נקודות
            left=Integer.parseInt(textViewLeft.getText().toString());
            intent.putExtra("left",left);
            intent.putExtra("useFifty",useFifty);
            startActivityForResult(intent, 1);
        } else
            {
            Intent toLoss = new Intent(this, LossActivity.class);
            toLoss.putExtra("scoreloss", Integer.parseInt(textViewScores.getText().toString()));
            startActivity(toLoss);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
    }
    //הצגתה ומחיקתה התוף שהוגרלה מהמערך
    public void deleteDrum(String[] drums) {
        drum = drums[new Random().nextInt(drums.length)];//מגריל תוף מתוך כמות התופים שיש במערך, כלומר מתוך מערך התופים
        while (drum.equals("found"))
            drum = drums[new Random().nextInt(drums.length)];
        for (int i = 0; i < drums.length; i++) {
            if (drums[i].equals(drum)) {
                drums[i] = "found";
                break;
            }
        }
        showGeneratedDrum.setText(drum);

    }


    public void ShowScores() {
        textViewScores.setText(String.valueOf(scores));
    }
    public void showDrumLeft()
    {
        textViewLeft.setText(String.valueOf(left));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1)
        {
            useFifty=data.getIntExtra("useFifty",0);
            int scores = data.getIntExtra("scoreAfterInTrivia", 0);
            textViewScores.setText(String.valueOf(scores));
            String[] drumaftertrivia = data.getStringArrayExtra("checkleftDrumAfterInTrivia");
            deleteDrum(drumaftertrivia);
            drums=drumaftertrivia;
            int left=data.getIntExtra("leftAfterTrivia",0);
            textViewLeft.setText(String.valueOf(left));
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
                Intent me = new Intent(GameActivity.this, AboutMe.class);
                startActivity(me);
                return true;
            case R.id.menuitem_aboutapp:
                Toast.makeText(this, "waiting...", Toast.LENGTH_SHORT).show();
                Intent app = new Intent(GameActivity.this, AboutAPP.class);
                startActivity(app);
                return true;
            case R.id.menuitem_exit:
                Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
                onBackPressedd();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressedd()
    {
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

