package com.example.loginpage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import static com.example.loginpage.R.raw.alarmaudio;

public class AlarmReceiver extends BroadcastReceiver {
    MediaPlayer mysong;
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm !!! Time to drink water!",Toast.LENGTH_SHORT).show();
    mysong=MediaPlayer.create(context, alarmaudio);
    mysong.start();
    }
}
