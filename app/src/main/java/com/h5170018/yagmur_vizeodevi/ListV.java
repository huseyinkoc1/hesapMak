package com.h5170018.yagmur_vizeodevi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListV extends AppCompatActivity {

    ListView listView;
    ArrayList<Kullanici> kullanicilar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int themeRes = getIntent().getIntExtra("tema", 0);
        if (themeRes == 2) {
            setTheme(android.R.style.ThemeOverlay_Material_Dark);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_v);
        listView = findViewById(R.id.listView);


        kullanicilar = new ArrayList<>();
        kullanicilar.add(new Kullanici("admin","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("yagmur","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("kullanici","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("kontrol","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("ms","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("aslı","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("ali","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("mete","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("seda","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("hilal","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("cenk","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("selim","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("pelin","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("busra","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("ömer","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("admin","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("yagmur","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("kullanici","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("kontrol","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("ms","12345",R.drawable.user_24px));

        final CustomAdapter customAdapter = new CustomAdapter(ListV.this,kullanicilar);
        listView.setAdapter(customAdapter);
    }
}