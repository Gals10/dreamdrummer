package com.example.dreamdrummer;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Excercise extends AppCompatActivity {

    ImageView vid;
    Uri uri;
    TextView name;
    Button undo;
    String key;
    int drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise);

        name = findViewById(R.id.nameofexe);
        vid = findViewById(R.id.video);
        undo = findViewById(R.id.undoEx);

        key = getIntent().getStringExtra("data1");
        drawable = getIntent().getIntExtra("images", R.drawable.back);
        vid.setImageResource(drawable);
        name.setText(key);



        vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Leg
                if(key.equals("Jhon Lenon-Imagine")){
                    uri = Uri.parse("https://www.youtube.com/watch?v=iDLyAyu8k-w");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(key.equals("Maroon5-Misery")){
                    uri = Uri.parse("https://www.youtube.com/watch?v=hSagyPgDtwU&ab_channel=DRUMMATEDRUMMATE");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(key.equals("Survivor-Eye Of Tiger")){
                    uri = Uri.parse("https://www.youtube.com/watch?v=gpYDVEsuXio&ab_channel=DRUMMATEDRUMMATE");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(key.equals("Passenger-Let Her Go")){
                    uri = Uri.parse("https://www.youtube.com/watch?v=ISMP5xeXnug&ab_channel=DRUMMATEDRUMMATE");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(key.equals("Westlife-My Love")){
                    uri = Uri.parse("https://www.youtube.com/watch?v=Zpv496aoBYE&ab_channel=DRUMMATEDRUMMATE");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(key.equals("Charlie Puth-Done For Me")){
                    uri = Uri.parse("https://www.youtube.com/watch?v=qLcE5mNNr28&ab_channel=DRUMMATEDRUMMATE");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(key.equals("Coldplay-Clocks")){
                    uri = Uri.parse("https://www.youtube.com/watch?v=0FqE5hCdbYI&ab_channel=DRUMMATEDRUMMATE");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
                if(key.equals("Green Day-September Ends")){
                    uri = Uri.parse("https://www.youtube.com/watch?v=uKTTkeFrBXw&ab_channel=DRUMMATEDRUMMATE");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }



            }
        });

        undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}