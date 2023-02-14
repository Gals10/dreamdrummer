package com.example.dreamdrummer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class SongsBeginner extends AppCompatActivity {


    MyAdapterSongs myAdapterT1;
    TextView name;
    String key;
    RecyclerView recyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs_beginner);

        recyclerView1 = findViewById(R.id.exelist1);

        name = findViewById(R.id.trainingtype);

        name.setText(key);

        Toast.makeText(SongsBeginner.this, "Click On An Exercise For More Information", Toast.LENGTH_SHORT).show();


            int images[]= {R.drawable.imaginejhon, R.drawable.miserymaroon, R.drawable.eyeoftiger,R.drawable.passengerlet,R.drawable.mylove,R.drawable.doneforme,R.drawable.clocks,R.drawable.septemberend,R.drawable.havana};
            String s1[] = {"Jhon Lenon-Imagine", "Maroon5-Misery", "Survivor-Eye Of Tiger","Passenger-Let Her Go","Westlife-My Love","Charlie Puth-Done For Me","Survivor-Eye Of Tiger","Coldplay-Clocks","Green Day-September Ends","Havana-Camila Cabello"};
            String s2[] = {"Imagine | length-3:54", "Misery | length-3:34", "Eye Of The Tiger | length-4:05","My Love | length-4:13","Done For Me | length-2:57","Clocks | length-4:15","3 sets, 6-10 reps","September Ends| length-7:13","song Havana | length-3:38"};
            myAdapterT1 = new MyAdapterSongs(this, s1, s2, images);




        recyclerView1.setAdapter(myAdapterT1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));


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
                Intent me = new Intent(SongsBeginner.this, AboutMe.class);
                stopService(new Intent(SongsBeginner.this, MyService.class));
                startActivity(me);
                return true;
            case R.id.menuitem_aboutapp:
                Toast.makeText(this, "waiting...", Toast.LENGTH_SHORT).show();
                Intent app = new Intent(SongsBeginner.this, AboutAPP.class);
                stopService(new Intent(SongsBeginner.this, MyService.class));
                startActivity(app);
                return true;
            case R.id.menuitem_exit:
                Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
                stopService(new Intent(SongsBeginner.this, MyService.class));
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}