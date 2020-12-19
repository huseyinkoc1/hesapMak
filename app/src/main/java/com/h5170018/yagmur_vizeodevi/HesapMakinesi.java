package com.h5170018.yagmur_vizeodevi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HesapMakinesi extends AppCompatActivity implements View.OnClickListener {

    Button sayi0, sayi1, sayi2, sayi3, sayi4, sayi5, sayi6, sayi7, sayi8, sayi9, sayitopla, sayicikar, sayicarp, sayibol, sayisil, hesapla;
    TextView display;
    private float ilkdeger = 0;
    private double sonuc = 0;
    private String islem;


    public void init() {

        hesapla = findViewById(R.id.btn30);
        sayi0 = findViewById(R.id.btn28);
        sayi1 = findViewById(R.id.btn22);
        sayi2 = findViewById(R.id.btn23);
        sayi3 = findViewById(R.id.btn24);
        sayi4 = findViewById(R.id.btn14);
        sayi5 = findViewById(R.id.btn15);
        sayi6 = findViewById(R.id.btn16);
        sayi7 = findViewById(R.id.btn10);
        sayi8 = findViewById(R.id.btn11);
        sayi9 = findViewById(R.id.btn12);
        sayitopla = findViewById(R.id.btn25);
        sayicikar = findViewById(R.id.btn20);
        sayicarp = findViewById(R.id.btn19);
        sayibol = findViewById(R.id.btn18);
        sayisil = findViewById(R.id.btn6);
        display = findViewById(R.id.display);


        hesapla.setOnClickListener(this);
        sayi0.setOnClickListener(this);
        sayi1.setOnClickListener(this);
        sayi2.setOnClickListener(this);
        sayi3.setOnClickListener(this);
        sayi4.setOnClickListener(this);
        sayi5.setOnClickListener(this);
        sayi6.setOnClickListener(this);
        sayi7.setOnClickListener(this);
        sayi8.setOnClickListener(this);
        sayi9.setOnClickListener(this);
        sayitopla.setOnClickListener(this);
        sayicikar.setOnClickListener(this);
        sayicarp.setOnClickListener(this);
        sayibol.setOnClickListener(this);
        sayisil.setOnClickListener(this);
        display.setOnClickListener(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int themeRes = getIntent().getIntExtra("tema", 0);
        if (themeRes == 2) {
            setTheme(android.R.style.ThemeOverlay_Material_Dark);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesap_makinesi);


        init();


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn28) {
            display.setText(display.getText() + "0");
        } else if (v.getId() == R.id.btn22) {
            display.setText(display.getText() + "1");
        } else if (v.getId() == R.id.btn23) {
            display.setText(display.getText() + "2");
        } else if (v.getId() == R.id.btn24) {
            display.setText(display.getText() + "3");
        } else if (v.getId() == R.id.btn14) {
            display.setText(display.getText() + "4");
        } else if (v.getId() == R.id.btn15) {
            display.setText(display.getText() + "5");
        } else if (v.getId() == R.id.btn16) {
            display.setText(display.getText() + "6");
        } else if (v.getId() == R.id.btn10) {
            display.setText(display.getText() + "7");
        } else if (v.getId() == R.id.btn11) {
            display.setText(display.getText() + "8");
        } else if (v.getId() == R.id.btn12) {
            display.setText(display.getText() + "9");
        } else if (v.getId() == R.id.btn6) {
            try {
                ilkdeger = 0;
                sonuc = 0;
                display.setText("");
            } catch (Exception c) {
            }
        } else if (v.getId() == R.id.btn25) {
            try {
                ilkdeger = 0;
                sonuc = 0;
                if (!display.getText().toString().equals("")) {
                    ilkdeger = Float.parseFloat(display.getText().toString());
                    display.setText("");
                    islem = "Toplama";
                }

            } catch (Exception c) {
            }
        } else if (v.getId() == R.id.btn20) {
            try {
                ilkdeger = 0;
                sonuc = 0;
                if (!display.getText().toString().equals("")) {
                    ilkdeger = Float.parseFloat(display.getText().toString());
                    display.setText("");
                    islem = "Cikarma";

                }
            } catch (Exception c) {
            }
        } else if (v.getId() == R.id.btn19) {
            try {
                ilkdeger = 0;
                sonuc = 0;
                if (!display.getText().toString().equals("")) {
                    ilkdeger = Float.parseFloat(display.getText().toString());
                    display.setText("");
                    islem = "Carpma";
                }
            } catch (Exception c) {
            }
        } else if (v.getId() == R.id.btn18) {
            try {
                ilkdeger = 0;
                sonuc = 0;
                if (!display.getText().toString().equals("")) {
                    ilkdeger = Float.parseFloat(display.getText().toString());
                    display.setText("");
                    islem = "Bolme";

                }
            } catch (Exception c) {
            }
        } else if (v.getId() == R.id.btn30) {
            try {

                if (!display.getText().toString().equals("") && !String.valueOf(ilkdeger).equals("0")) {
                    if (islem.equals("Toplama")) {
                        sonuc = ilkdeger + Float.parseFloat(display.getText().toString());
                    } else if (islem.equals("Cikarma")) {
                        sonuc = ilkdeger - Float.parseFloat(display.getText().toString());

                    } else if (islem.equals("Carpma")) {
                        sonuc = ilkdeger * Float.parseFloat(display.getText().toString());

                    } else if (islem.equals("Bolme")) {
                        sonuc = ilkdeger / Float.parseFloat(display.getText().toString());

                    }
                    display.setText(String.valueOf(sonuc));
                    ilkdeger = 0;
                    sonuc = 0;

                } else {
                    display.setText("Deger Giriniz.");

                }
                if (R.id.btn17 == v.getId()) {
                    ilkdeger = 0;
                    sonuc = 0;
                    display.setText("");
                }

            } catch (Exception c) {
            }
        }
    }
}
