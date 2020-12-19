package com.h5170018.yagmur_vizeodevi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Islemler extends AppCompatActivity implements View.OnClickListener {

    Button btnKredi ,btnHesap ,btnList;
    Intent intent;
    int deger;


    public void init(){
        btnKredi = findViewById(R.id.btnKrediHesap);
        btnHesap = findViewById(R.id.btnHesapMak);
        btnList = findViewById(R.id.btnListView);

        btnKredi.setOnClickListener(this);
        btnHesap.setOnClickListener(this);
        btnList.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int themeRes = getIntent().getIntExtra("tema", 0);
        deger = themeRes;
        if (themeRes == 2) {
            setTheme(android.R.style.ThemeOverlay_Material_Dark);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islemler);

        init();


    }

    public void onClick(View v) {

        if (v.getId()==R.id.btnKrediHesap)
        {
            intent = new Intent(Islemler.this, KrediTaksit.class);
            if (deger == 2) {
               intent.putExtra("tema",2);
            }else{
                intent.putExtra("tema",1);
            }
            //finish();
            startActivity(intent);
        }
        else if (v.getId()==R.id.btnHesapMak)
        {
            intent = new Intent(Islemler.this, HesapMakinesi.class);
            if (deger == 2) {
                intent.putExtra("tema",2);
            }else{
                intent.putExtra("tema",1);
            }
            //finish();
            startActivity(intent);
        }
        else if (v.getId()==R.id.btnListView)
        {
            intent = new Intent(Islemler.this, ListV.class);
            if (deger == 2) {
                intent.putExtra("tema",2);
            }else{
                intent.putExtra("tema",1);
            }
            //finish();
            startActivity(intent);
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}