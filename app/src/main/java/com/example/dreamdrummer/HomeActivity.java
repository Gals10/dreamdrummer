package com.example.dreamdrummer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity {

    Button LogOut, user, practice,vip,lead;
    Button lv1;
    Button lv2;
    Button hidon;
    TextView tvlogin,play,ver;
    FirebaseAuth mFirebaseAuth;
    DatabaseReference ref=FirebaseDatabase.getInstance().getReference("Users")
            .child(FirebaseAuth.getInstance().getCurrentUser().getUid());
    private  Switch wifiSwitch,musicSwitch;
    private  WifiManager wifiManager;
    private  User[] usera=new User[1];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        LogOut = findViewById(R.id.logout);
        practice = findViewById(R.id.btnpractice);
        lv1 = findViewById(R.id.btnbegin);
        lv2 = findViewById(R.id.btnadvance);
        hidon = findViewById(R.id.btnhidon);
        user = findViewById(R.id.btnuser);
        tvlogin = findViewById(R.id.tvuser);
        play = findViewById(R.id.tvpaly);
        vip = findViewById(R.id.btnvip);
        ver= findViewById(R.id.verify);
        lead = findViewById(R.id.lead);
        mFirebaseAuth = FirebaseAuth.getInstance();
        wifiSwitch = findViewById(R.id.wifi_switch);
        musicSwitch = findViewById(R.id.music_switch);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        if(!mFirebaseAuth.getCurrentUser().isEmailVerified())
        {
            vip.setVisibility(View.INVISIBLE);
            hidon.setVisibility(View.INVISIBLE);
            play.setVisibility(View.GONE);
        }

        musicSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if (isChecked)
                {
                    musicSwitch.setText("MUSIC is ON");
                    stopService(new Intent(HomeActivity.this, MyService.class));
                    Intent intent = new Intent(HomeActivity.this, MyService.class);
                    intent.putExtra("mediaToPlay", 1);
                    startService(intent);
                }
                else
                {
                    musicSwitch.setText("MUSIC is OFF");
                    stopService(new Intent(HomeActivity.this, MyService.class));
                }
            }
        });



        LogOut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                stopService(new Intent(HomeActivity.this, MyService.class));
                FirebaseAuth.getInstance().signOut();
                Intent i1 = new Intent(HomeActivity.this, Login.class);
                startActivity(i1);
                Toast.makeText(HomeActivity.this, "Logout Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        lv1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                stopService(new Intent(HomeActivity.this, MyService.class));
                Intent begin = new Intent(HomeActivity.this, Begin.class);
                startActivity(begin);
            }

        });
        lv2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                stopService(new Intent(HomeActivity.this, MyService.class));
                Intent advance= new Intent(HomeActivity.this, Advance.class);
                startActivity(advance);
            }

        });
        hidon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                stopService(new Intent(HomeActivity.this, MyService.class));
                Intent advance= new Intent(HomeActivity.this, GameActivity.class);
                startActivity(advance);
            }

        });
        practice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                stopService(new Intent(HomeActivity.this, MyService.class));
                Intent advance= new Intent(HomeActivity.this, PracticeArena.class);
                startActivity(advance);
            }

        });
        lead.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view)
            {
                stopService(new Intent(HomeActivity.this, MyService.class));
                Intent begin = new Intent(HomeActivity.this, Leaderboards.class);
                startActivity(begin);
            }

        });
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                String name=snapshot.child("username").getValue().toString();
                tvlogin.setText("logged in as: "+name);
                if (mFirebaseAuth.getCurrentUser().isEmailVerified())
                {
                    Vip vip = new Vip(mFirebaseAuth.getCurrentUser().getEmail(), mFirebaseAuth.getCurrentUser().getUid(), mFirebaseAuth.getCurrentUser().getDisplayName(),true,0);
                    usera[0] = vip;
                }
                else
                {
                    User user=new User(mFirebaseAuth.getCurrentUser().getEmail(), mFirebaseAuth.getCurrentUser().getUid(), mFirebaseAuth.getCurrentUser().getDisplayName(),0);
                    usera[0] = user;
                }
                User usercheck;
                for (int i = 0; i < 1; i++) {
                    usercheck = usera[i];
                    if (usera[i] instanceof Vip) {
                        Vip vip = (Vip) usercheck;
                        if (vip.getIsver() == true)
                        {
                            tvlogin.setTextColor(Color.parseColor("#C39B23"));
                            user.setVisibility(View.INVISIBLE);
                            ver.setVisibility(View.INVISIBLE);
                        }
                    }
                    else {
                          hidon.setVisibility(View.INVISIBLE);
                          play.setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomeActivity.this, "Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver, intentFilter);
        wifiSwitch.setClickable(false);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
        wifiSwitch.setClickable(false);
    }
    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                    WifiManager.WIFI_STATE_UNKNOWN);
            switch (wifiStateExtra) {
                case WifiManager.WIFI_STATE_ENABLED:
                    wifiSwitch.setChecked(true);
                    wifiSwitch.setText("WiFi is ON");
                    break;
                case WifiManager.WIFI_STATE_DISABLED:
                    wifiSwitch.setChecked(false);
                    wifiSwitch.setText("WiFi is OFF");
                    break;
            }
        }
    };

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
                Intent me = new Intent(HomeActivity.this, AboutMe.class);
                stopService(new Intent(HomeActivity.this, MyService.class));
                startActivity(me);
                return true;
            case R.id.menuitem_aboutapp:
                Toast.makeText(this, "waiting...", Toast.LENGTH_SHORT).show();
                Intent app = new Intent(HomeActivity.this, AboutAPP.class);
                stopService(new Intent(HomeActivity.this, MyService.class));
                startActivity(app);
                return true;
            case R.id.menuitem_exit:
                Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
                stopService(new Intent(HomeActivity.this, MyService.class));
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