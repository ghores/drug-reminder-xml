package com.example.yadavaredaroo.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class RebootService extends BroadcastReceiver {
    private static final String TAG = "RebootService";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: " + new Date() + "", null);
        Toast.makeText(context, "onReceaved", Toast.LENGTH_SHORT).show();
    }
}
