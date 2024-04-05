package com.example.yadavaredaroo.services;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.yadavaredaroo.api.ApiCaller;
import com.example.yadavaredaroo.model.Applications;
import com.example.yadavaredaroo.model.IResponseMessage;
import com.karumi.dexter.BuildConfig;

public class UpdateService extends Service {

    ApiCaller apiCaller;

    @Override
    public void onCreate() {
        super.onCreate();
        apiCaller = new ApiCaller();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        apiCaller.getCurrent(new IResponseMessage() {
            @Override
            public void onSuccess(Object responseMessage) {
                Log.e("", "");
                Applications app = (Applications) responseMessage;

                int myVersion = BuildConfig.VERSION_CODE;
                if (myVersion < app.getVersion()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(app.getDownload()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(String errorResponseMessage) {
                Log.e("", "");
            }
        });

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
