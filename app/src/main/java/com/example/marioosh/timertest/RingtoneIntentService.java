package com.example.marioosh.timertest;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.format.Time;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author marioosh
 */
public class RingtoneIntentService extends IntentService {

    private static FileOutputStream logFile;
    public static final String LOGFILE = "log.txt";

    public RingtoneIntentService() {
        super(RingtoneIntentService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        sound();
        AlarmReceiver.completeWakefulIntent(intent);
    }

    private void sound() {
        try {
            logFile = getApplicationContext().openFileOutput(LOGFILE, Context.MODE_WORLD_READABLE|Context.MODE_APPEND);
            Time now = new Time();
            now.setToNow();
            logFile.write((now.format("%Y-%m-%d %H:%M:%S") + " " + "TIK-TAK" + "\n").getBytes("UTF-8"));
        } catch (Exception e) {
            Log.e("E",e+"");
        }
        /*
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
        r.play();
        */
    }
}
