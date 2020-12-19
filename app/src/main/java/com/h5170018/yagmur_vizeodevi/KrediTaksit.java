package com.h5170018.yagmur_vizeodevi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class KrediTaksit extends AppCompatActivity {

    EditText edtKrediTutari ,edtTaksitSayisi;
    RadioGroup radioGroup;
    TextView txtKullanici;
    RadioButton radioButton1 , radioButton2 ,radioButton5;
    Button btnSonuc;
    private static DecimalFormat df = new DecimalFormat("0.00");


    public void init(){

        edtKrediTutari = findViewById(R.id.editTextTextPersonName);
        edtTaksitSayisi = findViewById(R.id.editTextTextPersonName2);
        radioGroup = findViewById(R.id.radioGroup2);
        radioButton1 = findViewById(R.id.radioButton3);
        radioButton2 = findViewById(R.id.radioButton4);
        radioButton5 = findViewById(R.id.radioButton5);
        txtKullanici = findViewById(R.id.textView4);
        btnSonuc = findViewById(R.id.button);

        Singleton singleton = Singleton.getInstance();
        txtKullanici.setText("Hoşgeldin "+" "+singleton.getKullaniciAdi().toUpperCase());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int themeRes = getIntent().getIntExtra("tema", 0);
        if (themeRes == 2) {
            setTheme(android.R.style.ThemeOverlay_Material_Dark);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kredi_taksit);

        init();


        btnSonuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId=radioGroup.getCheckedRadioButtonId();
                String krediTutar = edtKrediTutari.getText().toString();
                String taksitSayisi = edtTaksitSayisi.getText().toString();
                double faizTutari;


                if (krediTutar.equals("") || taksitSayisi.equals("") || selectedId==-1){
                    Toast.makeText(getApplicationContext(),"Lütfen Tüm Seçimleri Yapın",Toast.LENGTH_LONG).show();
                }
                else if (selectedId==radioButton1.getId()){

                    //taksitTuari = (double) (Double.valueOf(krediTutar)*(0.01*Math.pow(1.01,Integer.valueOf(taksitSayisi))/Math.pow(1.01,Integer.valueOf(taksitSayisi))-1));
                    faizTutari= faizHesabı(Double.valueOf(krediTutar),Integer.valueOf(taksitSayisi),0.01);
                    dialogGoster("Taksit Tutarınız Hesaplandı","Geri Ödeme Tutarı: "+df.format(faizTutari));
                }
                else if (selectedId==radioButton2.getId()){
                    faizTutari= faizHesabı(Double.valueOf(krediTutar),Integer.valueOf(taksitSayisi),0.02);
                    dialogGoster("Taksit Tutarınız Hesaplandı","Geri Ödeme Tutarı: "+df.format(faizTutari));
                }
                else if (selectedId==radioButton5.getId()){
                    faizTutari= faizHesabı(Double.valueOf(krediTutar),Integer.valueOf(taksitSayisi),0.05);
                    dialogGoster("Taksit Tutarınız Hesaplandı","Geri Ödeme Tutarı: "+df.format(faizTutari));
                }
            }
        });
    }

    public void dialogGoster(String baslik,String icerikYazisi){
        final Dialog dialog = new Dialog(KrediTaksit.this);
        dialog.setContentView(R.layout.dialog_islem);


        TextView tvBaslik = dialog.findViewById(R.id.tvDialogBaslik);
        TextView tvIcerik = dialog.findViewById(R.id.tvDialogYazi);


        tvBaslik.setText(baslik);
        tvIcerik.setText(icerikYazisi);

        //dialog.create();
        dialog.show();


    }

    public double faizHesabı(double krediTutari , int taksitSayisi ,double faizOrani){

        double anaPara=krediTutari;
        double faiz=faizOrani;
        int vade=taksitSayisi;
        double birikimliTutar=0;

        for (int i=0; i<=vade; i++)
        {
            birikimliTutar=(anaPara*Math.pow(1+faiz, i));

        }



        return birikimliTutar;
    }



}