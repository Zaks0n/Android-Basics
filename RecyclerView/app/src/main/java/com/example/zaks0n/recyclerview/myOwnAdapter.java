package com.example.zaks0n.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

 public class myOwnAdapter extends RecyclerView.Adapter<myOwnAdapter.MyOwnHolder> {

    String data1[], data2[];
    int img[];
    Context ctx;

    public myOwnAdapter(Context ct, String s1[], String s2[], int i1[]){
        ctx = ct;

        data1 = s1;
        data2 = s2;

        img = i1;

    }

    @NonNull
    @Override
    public MyOwnHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater myInflator = LayoutInflater.from(ctx);
        View myOwnView = myInflator.inflate(R.layout.my_row, viewGroup, false);
         return new MyOwnHolder(myOwnView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOwnHolder myOwnView, int i) {
        myOwnView.t1.setText(data1[i]);
        myOwnView.t2.setText(data2[i]);
        myOwnView.myImage.setImageResource(img[i]);

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyOwnHolder extends RecyclerView.ViewHolder {
        TextView t1, t2;
        ImageView myImage;
        public MyOwnHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.text1);
            t2 = itemView.findViewById(R.id.text2);
            myImage = itemView.findViewById(R.id.myImage);
        }
    }
}
