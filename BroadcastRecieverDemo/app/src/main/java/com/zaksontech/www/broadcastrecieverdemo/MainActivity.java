package com.zaksontech.www.broadcastrecieverdemo;

import android.content.Intent;
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
        Intent intent = new Intent();
        intent.setAction("anything");
        intent.addCategory("android.intent.category.DEFAULT");
        sendBroadcast(intent);
    }
}
