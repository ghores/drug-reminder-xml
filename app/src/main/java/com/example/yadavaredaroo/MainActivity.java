package com.example.yadavaredaroo;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yadavaredaroo.services.AlarmService;
import com.example.yadavaredaroo.services.InjectionService;
import com.example.yadavaredaroo.services.UpdateService;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dexter.withContext(this).withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        Log.i(TAG, "onPermissionGranted: ");
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Log.i(TAG, "onPermissionDenied: ");
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        Log.i(TAG, "onPermissionRationaleShouldBeShown: ");
                    }
                }).check();

        Dexter.withContext(this).withPermissions(Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.ACCESS_COARSE_LOCATION)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
                        Log.i(TAG, "onPermissionsChecked: ");
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> list, PermissionToken permissionToken) {
                        Log.i(TAG, "onPermissionRationaleShouldBeShown: ");
                    }
                }).check();
        Intent intent = new Intent(getApplicationContext(), UpdateService.class);
        startService(intent);

        AlarmManager alarmManager1 = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent1 = new Intent(this, AlarmService.class);
        PendingIntent pendingIntent1 = PendingIntent.getBroadcast(this, 1, intent1, PendingIntent.FLAG_IMMUTABLE);
        alarmManager1.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 6000 * 10, pendingIntent1);

        //================================================================
        AlarmManager alarmManager2 = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent2 = new Intent(this, InjectionService.class);
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this, 1, intent2, PendingIntent.FLAG_IMMUTABLE);
        alarmManager1.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 6000 * 10, pendingIntent2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.MINUTE, 14);
        calendar.set(Calendar.HOUR_OF_DAY, 3);
        alarmManager2.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent2);
    }
}