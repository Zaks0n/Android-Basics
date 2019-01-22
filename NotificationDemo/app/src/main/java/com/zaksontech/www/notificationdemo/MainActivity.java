package com.zaksontech.www.notificationdemo;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doSomething(View view) {

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);

        NotificationCompat.Builder notificationCompat = new NotificationCompat.Builder(this);
        notificationCompat.setContentTitle("New Message");
        notificationCompat.setContentText("Hello, form the other side");
        notificationCompat.setSmallIcon(android.R.drawable.ic_btn_speak_now);

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pd = PendingIntent.getActivity(this,1,intent,0);

        notificationCompat.setContentIntent(pd);
        notificationCompat.setAutoCancel(true);

        notificationManagerCompat.notify(1,notificationCompat.build());
    }
}
