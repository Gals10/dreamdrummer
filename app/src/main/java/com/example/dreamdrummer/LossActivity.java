package com.example.dreamdrummer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LossActivity extends AppCompatActivity {

    Button playAgain;
    Button Home;
    TextView tvscore;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loss);

        playAgain=(Button)findViewById(R.id.btnPlayAgain);
        Home=(Button)findViewById(R.id.btnMain);
        tvscore= findViewById(R.id.tvscore);


        {
            Intent intent = getIntent();
            score = intent.getIntExtra("scoreloss", 0);
            Toast.makeText(LossActivity.this, "score" + score, Toast.LENGTH_SHORT).show();
            String string = "your final score: " + score;
            tvscore.setText(string);
        }
        FirebaseDatabase.getInstance().getReference("Users")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        final String storedScore = snapshot.child("points").getValue().toString();
                        Integer scoredata = Integer.parseInt(storedScore);
                        if(score > scoredata)
                        {
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .child("points").setValue(score);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        playAgain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                Intent intent = new Intent(LossActivity.this, GameActivity.class);
                startActivity(intent);
            }

        });
        Home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                Intent toMain=new Intent(LossActivity.this, HomeActivity.class);
                startActivity(toMain);
            }

        });


    }




    @Override
    public void onBackPressed()
    {
    }


}
