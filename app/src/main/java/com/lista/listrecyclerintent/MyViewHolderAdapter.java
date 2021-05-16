package com.lista.listrecyclerintent;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaCas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.se.omapi.Session;
import android.telephony.SmsManager;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Properties;


public class MyViewHolderAdapter extends RecyclerView.Adapter<MyViewHolderAdapter.ViewHolder> {

ArrayList<Model> arrayList;
Context context;

    public MyViewHolderAdapter(Context context,ArrayList<Model> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txt.setText(arrayList.get(position).getCount());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,MainActivity.class);
                PendingIntent pi=PendingIntent.getActivity(context, 0, intent,0);

                //Get the SmsManager instance and call the sendTextMessage method to send message
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage("+40773391696", null, "test", pi,null);

                Toast toast=Toast.makeText(context, "Mesas trimis", Toast.LENGTH_SHORT);
                toast.setMargin(50,50);
                toast.show();

//                String test="cristealin@yahoo.ro";
//                Intent email = new Intent(Intent.ACTION_SEND);
//                email.putExtra(Intent.EXTRA_EMAIL, new String[]{test});
//                email.putExtra(Intent.EXTRA_SUBJECT, "Test");
//                email.putExtra(Intent.EXTRA_TEXT, "Test");
//                email.setType("message/rfc822");
//                email.setData(Uri.parse("mailto:"));
//                context.startActivity(email);


//                Intent shareIntent =   new Intent(android.content.Intent.ACTION_SEND);
//                shareIntent.setType("text/plain");
//                shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Insert Subject here");
//                String app_url = " https://play.google.com/store/apps/details?id=my.example.javatpoint";
//                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
//                context.startActivity(Intent.createChooser(shareIntent, "Share via"));
            }

            private void test() {
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage("+40773391696",null,"bau",null,null);
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt;
        CardView linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txt);
            linearLayout=itemView.findViewById(R.id.cardViewRow);

        }
    }
}
