package com.example.mike.firebasemessagingservice;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "__TAG__";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);;
        // Since android Oreo notification channel is needed.
        Log.e(TAG, "onCreate: "+Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "ID";
            String channelTitle = "TITLE";
            String channelDesc = "DESC";
            NotificationChannel channel = new NotificationChannel(channelId,   channelTitle, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(channelDesc);
            mNotificationManager.createNotificationChannel(channel);
        }

        Intent service = new Intent( this, MyFirebaseMessagingService.class );
        startService(service);

    }
}


