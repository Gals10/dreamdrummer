package com.example.dreamdrummer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class PracticeArena extends AppCompatActivity implements View.OnClickListener {
    Button hayhet,tamtam,snare,raid, crash,bas,back;
    ImageView drum;
    TextView shimosh,sound,name;
    String dd="";
    FirebaseAuth mFirebaseAuth;
    private  Exactdrum[] usera=new  Exactdrum[1];
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_arena);
        hayhet=(Button)findViewById(R.id.btnhayhetwu);
        tamtam=(Button)findViewById(R.id.btntam_wu);
        snare=(Button)findViewById(R.id.btnsnare_wu);
        raid=(Button)findViewById(R.id.btnraid_wu);
        crash=(Button)findViewById(R.id.btncrash_wu);
        bas=(Button)findViewById(R.id.btnbas_Wu);
        drum=(ImageView)findViewById(R.id.drumWarm);
        shimosh=(TextView)findViewById(R.id.shimoshWarm);
        sound=(TextView)findViewById(R.id.soundWarm);
        name=(TextView)findViewById(R.id.drumnameWarm);
        back= findViewById(R.id.btnback);
        mFirebaseAuth = FirebaseAuth.getInstance();
        hayhet.setOnClickListener(this);
        snare.setOnClickListener(this);
        tamtam.setOnClickListener(this);
        crash.setOnClickListener(this);
        raid.setOnClickListener(this);
        bas.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v== back)
        {
            Intent i1 = new Intent(PracticeArena.this, HomeActivity.class);
            startActivity(i1);
        }
        if (v==hayhet)
        {
            dd="הייהט";
            drum.setImageResource(R.drawable.hihatpic);
            Exactdrum hayhet=new Exactdrum(drum,"ליווי חזק","גדול ודומיננטי",dd);
            hayhet.setName("תוף: הייהט");
            name.setText( hayhet.getName());
            shimosh.setText("שימוש: " +  hayhet.getShimosh());
            sound.setText("צליל: " +  hayhet.getSound());

        }
        if(v==bas)
        {
            dd="באס";
            drum.setImageResource(R.drawable.basspic);
            Exactdrum bas=new Exactdrum(drum,"מקצב וטון","נמוך מאוד",dd);
            bas.setName("תוף: באס");
            name.setText(bas.getName());
            shimosh.setText("שימוש: "+bas.getShimosh());
            sound.setText("צליל: "+bas.getSound());
        }
        if(v==tamtam)
        {
           dd="תמתם";
            drum.setImageResource(R.drawable.tamtampic);
            Exactdrum tam=new Exactdrum(drum,"מעברים","עמום וארוך",dd);
            tam.setName("תוף: תמתם");
            name.setText(tam.getName());
            shimosh.setText("שימוש: "+tam.getShimosh());
            sound.setText("צליל: "+tam.getSound());
        }

        if(v== snare)
        {
            dd="סנייר";
            drum.setImageResource(R.drawable.snarepic);
            Exactdrum snare=new Exactdrum(drum,"שמירה על קצב","חד וחזק",dd);
            snare.setName("תןף: סנייר");
            name.setText(snare.getName());
            shimosh.setText("שימוש: "+snare.getShimosh());
            sound.setText("צליל: "+snare.getSound());
        }
        if(v==raid)
        {
            dd="רייד";
            drum.setImageResource(R.drawable.ridepic);
            Exactdrum raid=new Exactdrum(drum,"ליווי עדין","עדין",dd);
            raid.setName("תןף: רייד");
            name.setText(raid.getName());
            shimosh.setText("שימוש: "+raid.getShimosh());
            sound.setText("צליל: "+raid.getSound());
        }
        if(v== crash)
        {
            dd="קראש";
            drum.setImageResource(R.drawable.crashpic);
            Exactdrum crash = new Exactdrum(drum,"הדגשה חזקה","גס ועוצמתי",dd);
            crash.setName("תוף: קראש");
            name.setText(crash.getName());
            shimosh.setText("שימוש: "+crash.getShimosh());
            sound.setText("צליל: "+crash.getSound());
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
                Intent me = new Intent(PracticeArena.this, AboutMe.class);
                stopService(new Intent(PracticeArena.this, MyService.class));
                startActivity(me);
                return true;
            case R.id.menuitem_aboutapp:
                Toast.makeText(this, "waiting...", Toast.LENGTH_SHORT).show();
                Intent app = new Intent(PracticeArena.this, AboutAPP.class);
                stopService(new Intent(PracticeArena.this, MyService.class));
                startActivity(app);
                return true;
            case R.id.menuitem_exit:
                Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
                stopService(new Intent(PracticeArena.this, MyService.class));
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