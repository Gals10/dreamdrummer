package com.example.dreamdrummer;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Stack;

public class Leaderboards extends AppCompatActivity {
    private Button button;
    private TextView tx1, tx2 ,tx3, tx4 ,tx5;
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<String> stack2 = new Stack<String>();
    private FirebaseAuth auth;
    private Vip[] arr = new Vip[5];
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboards);
        button = (Button) findViewById(R.id.backbt);
        tx1 = (TextView) findViewById(R.id.firstplace) ;
        tx2 = (TextView) findViewById(R.id.secondplace) ;
        tx3 = (TextView) findViewById(R.id.thirdplace) ;
        tx4 = (TextView) findViewById(R.id.fourthplace) ;
        tx5 = (TextView) findViewById(R.id.fifthplace) ;
        mFirebaseAuth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Leaderboards.this , HomeActivity.class);
                startActivity(intent2);
                finish();
            }
        });

        auth = FirebaseAuth.getInstance();
        DatabaseReference users = FirebaseDatabase.getInstance().getReference("Users");
        Query query = users.orderByChild("points");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1: snapshot.getChildren())
                {
                    String name = snapshot1.getValue().toString();
                    if(!name.equals("0")) {

                        name = name.substring(name.indexOf("me=")+3);
                        name = name.substring(0,name.indexOf("}"));
                        Log.d("users = ", "name = " + name);
                        stack2.push(name);

                    }
                    String p = snapshot1.getValue().toString();
                    if (!p.equals("0"))
                    {
                        p = p.substring(p.indexOf("ts=")+3);
                        p = p.substring(0,p.indexOf(","));
                        Integer points = Integer.parseInt(p);
                        stack1.push(points);
                        Log.d("points","points"+ points);
                    }



                }

                if(!stack1.isEmpty() && !stack2.isEmpty()) {

                    tx1.setText("1. " + stack2.pop() + " > points =" + stack1.pop().toString());
                    tx2.setText("2. " + stack2.pop() + " > points =" + stack1.pop().toString());
                    tx3.setText("3. " + stack2.pop() + " > points =" + stack1.pop().toString());
                    tx4.setText("4. " + stack2.pop() + " > points =" + stack1.pop().toString());
                    tx5.setText("5. " + stack2.pop() + " > points =" + stack1.pop().toString());
                }
                else
                {
                    Toast.makeText(Leaderboards.this, "isempty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}