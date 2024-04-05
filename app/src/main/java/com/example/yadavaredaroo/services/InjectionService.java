package com.example.yadavaredaroo.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.Date;

public class InjectionService extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Toast.makeText(context , "InjectionService "+ new Date().toString() + ""
                , Toast.LENGTH_LONG).show();

        Log.e("InjectionService", "InjectionService "+ new Date().toString() + "");


    }
}
