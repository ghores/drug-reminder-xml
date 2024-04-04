package com.example.yadavaredaroo.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.util.Log;

public class IncomingSms extends BroadcastReceiver {
    private static final String TAG = "IncomingSms";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive: ");

        Bundle bundle = intent.getExtras();
        Object[] pdus = (Object[]) bundle.get("pdus");
        SmsMessage[] messages = new SmsMessage[pdus.length];

        for (int i = 0; i < messages.length; i++) {
            messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);

            String phoneNumber = messages[i].getDisplayOriginatingAddress();
            String messageBody = messages[i].getDisplayMessageBody();

            Log.i(TAG, "endOnReceive: ");
        }
    }
}
