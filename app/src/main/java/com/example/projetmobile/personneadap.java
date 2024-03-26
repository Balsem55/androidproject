package com.example.projetmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class personneadap extends ArrayAdapter<personne> {
    private Context mcontext;
    private int mresource;

    public personneadap(@NonNull Context context , int resource, @NonNull ArrayList<personne> objects){
            super(context,resource,objects);
            this.mcontext=context;
            this.mresource=resource;
        }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layI=LayoutInflater.from(mcontext);
        convertView =layI.inflate(mresource,parent,false);
        ImageView image= convertView.findViewById(R.id.image1);
        TextView Name= convertView.findViewById(R.id.textview1);
        image.setImageResource(getItem(position).getImage());
        Name.setText(getItem(position).getName());
        return convertView;
    }
}
