package com.h5170018.yagmur_vizeodevi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Kullanici> {

    ArrayList<Kullanici> users ;
    private Activity context;
    private LayoutInflater inflater;


    public CustomAdapter(Activity context, ArrayList<Kullanici> users) {
        super(context,R.layout.custom,users);
        this.users=users;
        this.context=  context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        inflater = context.getLayoutInflater();
        View satir = inflater.inflate(R.layout.custom,null,true);
        TextView textView = satir.findViewById(R.id.txtMain);
        TextView textView1 = satir.findViewById(R.id.txtSub);
        ImageView imageView = satir.findViewById(R.id.imageView);

        textView.setText("Kullanici");
        textView1.setText(users.get(position).getKullaniciAdi());
        imageView.setImageResource(users.get(position).gettImage());



        return satir;
    }

}
