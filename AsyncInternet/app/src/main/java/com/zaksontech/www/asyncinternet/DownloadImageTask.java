package com.zaksontech.www.asyncinternet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... strings) {

        String s1 = strings[0];
        InputStream in;

        try {
            URL myURL = new URL(s1);
            HttpURLConnection myConn = (HttpURLConnection) myURL.openConnection();
            myConn.setRequestMethod("GET");
            myConn.setConnectTimeout(2000);
            myConn.setReadTimeout(1000);
            myConn.connect();

            in = myConn.getInputStream();

            Bitmap myMap = BitmapFactory.decodeStream(in);
            return myMap;
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        MainActivity.img.setImageBitmap(bitmap);
    }
}
