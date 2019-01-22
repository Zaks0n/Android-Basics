package com.example.zaks0n.asyncdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class ProgressTask extends AsyncTask<Void, Integer, String> {

    Context ctx;
    ProgressDialog pd;

    public ProgressTask(Context ct) {
        ctx = ct;

    }

    @Override
    protected void onPreExecute() {
        pd = new ProgressDialog(ctx);
        pd.setTitle("Downloading");
        pd.setMessage("Please wait....");
        pd.setMax(10);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                cancel(true);
            }
        });

        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        for (int i=1; i < 10; i++){
            try {
                Thread.sleep(7000);
                Log.i("Thread", "Execution" + i);
                publishProgress(i);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
                return "Failed";
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int myValue = values[0];
        pd.setProgress(myValue);

    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT);
        pd.dismiss();
    }
}
