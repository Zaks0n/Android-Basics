package com.zaksontech.www.asyncinternet;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConnectInternetTask c1;
    DownloadImageTask d1;

    static TextView tv;
    static ImageView img;

    ConnectivityManager connectivityManager;
    NetworkInfo networkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.myResult);
        img = findViewById(R.id.myImage);

        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
    }

    public void doSomething(View view) {
        c1 = new ConnectInternetTask(this);
        c1.execute("https://www.google.com");
    }

    public void downloadImage(View view) {

        if(networkInfo != null && networkInfo.isConnected()){
            d1 = new DownloadImageTask();
            d1.execute("https://www.thesprucepets.com/thmb/ttkDgtUuTujUWf94CSHyNIXJ0BY=/450x0/filters:no_upscale():max_bytes(150000):strip_icc()/young-female-veterinary-doctor-looking-on-cute-kitten-897713306-5b0ed951ba617700364be6db.jpg");
        }
        else {
            Toast.makeText(this, "Internet Not Conneted", Toast.LENGTH_SHORT).show();
        }

    }
}
