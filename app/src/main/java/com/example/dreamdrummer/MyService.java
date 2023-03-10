package com.example.dreamdrummer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        //getting systems default ringtone

        int music =intent.getIntExtra("mediaToPlay",0);
        if(music==1)
        {
            player = MediaPlayer.create(this,R.raw.elevatormusic);
            //setting loop play to true
            //this will make the ringtone continuously playing
            player.setLooping(true);
            //staring the player
            player.start();
            //we have some options for service
            //start sticky means service will be explicity started and stopped
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        //stopping the player when service is destroyed
        player.stop();
    }
}