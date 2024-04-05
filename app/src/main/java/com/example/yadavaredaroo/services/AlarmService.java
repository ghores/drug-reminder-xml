package com.example.yadavaredaroo.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class AlarmService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context , "AlarmService "+ new Date().toString() + ""
                , Toast.LENGTH_LONG).show();

        Log.e("AlarmService", "AlarmService "+ new Date().toString() + "");
    }
}
