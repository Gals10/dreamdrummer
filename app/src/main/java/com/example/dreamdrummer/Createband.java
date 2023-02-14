package com.example.dreamdrummer;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Createband extends AppCompatActivity {
    EditText name,specialsticks;
    TextView end,gender, type;
    Button back, save, reset, home;
    RadioGroup radioGroup;
    int cp=0;
    int cd=0;
    int cg=0;
    int c=0;
    int girls=0;
    int boys=0;
    RadioGroup radiogroup,radiogroup2;
    private  Band[] a=new Band[3];
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createband);
        name = findViewById(R.id.name);
        gender = findViewById(R.id.gender);
        specialsticks = findViewById(R.id.specialsticks);
        back = findViewById(R.id.back);
        radioGroup= findViewById(R.id.group);
        end = findViewById(R.id.end);
        save = findViewById(R.id.btnsavee);
        type =findViewById(R.id.type);
        reset = findViewById(R.id.reset);
        radiogroup= findViewById(R.id.group);
        radiogroup2 = findViewById(R.id.group2);
        home= findViewById(R.id.btnhome);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.drum:
                        type.setText("drum");
                        break;
                    case R.id.piano:
                        type.setText("piano");
                        break;
                    case R.id.guitar:
                        type.setText("guitar");
                        break;
                }
            }
        });
        radiogroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.drum2:
                        gender.setText("male");
                        break;
                    case R.id.piano2:
                        gender.setText("female");
                        break;

                }
            }
        });
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (c < 3)
                {
                    if (type.getText().toString().equals("drum"))
                    {
                        Drum drum = new Drum(name.getText().toString(), "female", Integer.parseInt(specialsticks.getText().toString()));
                        a[c] =drum;
                        Log.d("gender =",  drum.getGender());
                        if (a[c].getGender().equals("female"))
                            girls++;
                        cd++;
                        type.setText("");
                        name.setText("");
                        gender.setText("");
                        specialsticks.setText("");
                    }
                    else if (type.getText().toString().equals("piano"))
                    {

                        Piano piano = new Piano(name.getText().toString(), gender.getText().toString(), Integer.parseInt(specialsticks.getText().toString()));
                        a[c] = piano;
                        Log.d("gender =",  piano.getGender());
                        if (a[c].getGender().equals("female"))
                            girls++;
                        cp++;
                        type.setText("");
                        name.setText("");
                        gender.setText("");
                        specialsticks.setText("");
                    }
                    else if (type.getText().toString().equals("guitar"))
                    {
                        Guitar guitar = new Guitar(name.getText().toString(), gender.getText().toString(), Integer.parseInt(specialsticks.getText().toString()));
                        a[c] = guitar;
                        Log.d("gender =",  guitar.getGender());
                        if (a[c].getGender().equals("female"))
                            girls++;
                        cg++;
                        type.setText("");
                        name.setText("");
                        gender.setText("");
                        specialsticks.setText("");
                    }
                    else
                        Toast.makeText(Createband.this, " Enter Animal Details", Toast.LENGTH_LONG).show();

                    String text=a[c].getName();
                    c++;
                    Toast.makeText(Createband.this, text+" has registed...next", Toast.LENGTH_LONG).show();
                    Log.d("c=", String.valueOf(c));
                }
                if (c == 3)
                {
                    if (cd ==0  || cp == 0 || cg ==0)
                    {
                        end.setText("      not as the demands") ;
                    }
                    int s = 0;
                    Band band;
                    for (int i = 0; i < 3; i++)
                    {
                        band = a[i];
                        if (a[i] instanceof Piano) {
                            Piano p = (Piano) band;
                            if (p.checkexp()) {
                                s=s+1;
                            }
                        } else if (a[i] instanceof Guitar) {
                            Guitar g = (Guitar) band;
                            if (g.getEqu() > 2) {
                                s = s + 1;
                            }
                        }
                        else if (a[i] instanceof Drum)
                            {
                                Drum d = (Drum) band;
                                if (d.Checksticks()) {
                                    s=s+1;
                                }
                            }
                            if (s==3) {
                                boys = 3 - girls;
                                end.setText("    as the demands! " + boys + " boys " + girls + " girls");
                            }
                            type.setText("");
                            name.setText("");
                            gender.setText("");
                            specialsticks.setText("");
                    }
                    boys=3-girls;
                    if (s<3)
                        end.setText("         almost as the demands " + boys + " boys " + girls + " girls");
                    type.setText("");
                    name.setText("");
                    gender.setText("");
                    specialsticks.setText("");
                    boys=0;
                    girls=0;
                }
                type.setText("");
                name.setText("");
                gender.setText("");
                specialsticks.setText("");
                boys=0;
                girls=0;
            }



        });



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a[0]= null;
                a[1]= null;
                a[2]=null;
                c=0;
                cd=0;
                cp=0;
                cg=0;
                type.setText("");
                name.setText("");
                gender.setText("");
                specialsticks.setText("");
                end.setText("");
                boys=0;
                girls=0;
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Createband.this, HomeActivity.class));
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
            case R.id.menuitem_aboutme:
                Toast.makeText(this, "waiting...", Toast.LENGTH_SHORT).show();
                Intent me = new Intent(Createband.this, AboutMe.class);
                stopService(new Intent(Createband.this, MyService.class));
                startActivity(me);
                return true;
            case R.id.menuitem_aboutapp:
                Toast.makeText(this, "waiting...", Toast.LENGTH_SHORT).show();
                Intent app = new Intent(Createband.this, AboutAPP.class);
                stopService(new Intent(Createband.this, MyService.class));
                startActivity(app);
                return true;
            case R.id.menuitem_exit:
                Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
                stopService(new Intent(Createband.this, MyService.class));
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