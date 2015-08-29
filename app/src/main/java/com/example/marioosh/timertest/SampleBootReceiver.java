package com.example.marioosh.timertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @author marioosh
 */
public class SampleBootReceiver extends BroadcastReceiver {

    AlarmReceiver alarm = new AlarmReceiver();

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
        {
            alarm.setAlarm(context);
        }
    }
}
