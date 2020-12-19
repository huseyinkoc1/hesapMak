package com.h5170018.yagmur_vizeodevi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButtonA ,radioButtonK;
    Button button;
    EditText editTextAd ,editTextParola;
    Intent intent;
    public ArrayList<Kullanici> kullanicilar;
    boolean gecis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radioButtonA = findViewById(R.id.radioButton);
        radioButtonK = findViewById(R.id.radioButton2);
        editTextAd = findViewById(R.id.edtTextAd);
        editTextParola = findViewById(R.id.edtTextSifre);
        button = findViewById(R.id.btnGiris);
        intent = new Intent(MainActivity.this, Islemler.class);



        kullanicilar = new ArrayList<>();
        kullanicilar.add(new Kullanici("admin","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("yagmur","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("kullanici","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("kontrol","12345",R.drawable.user_24px));
        kullanicilar.add(new Kullanici("ms","12345",R.drawable.user_24px));





        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=radioGroup.getCheckedRadioButtonId();
                String kullaniciAd = editTextAd.getText().toString();
                String password = editTextParola.getText().toString();

                if (kullaniciAd.equals("") || password.equals("") || selectedId==-1){
                    Toast.makeText(getApplicationContext(),"Lütfen İlgili Alanları Doldurunuz.",Toast.LENGTH_LONG).show();
                }
                else if (selectedId==radioButtonA.getId()){

                    for (int i=0 ;i<kullanicilar.size();i++){
                        if (kullanicilar.get(i).getKullaniciAdi().equals(kullaniciAd) && kullanicilar.get(i).getPassword().equals(password)){
                            intent.putExtra("tema",1);
                            Singleton singleton = Singleton.getInstance();
                            singleton.setKullaniciAdi(kullanicilar.get(i).getKullaniciAdi());
                            finish();
                            startActivity(intent);
                            gecis = true;
                        }
                    }
                    gecis();
                }
                else if (selectedId==radioButtonK.getId()){

                    for (int i=0 ;i<kullanicilar.size();i++){
                        if (kullanicilar.get(i).getKullaniciAdi().equals(kullaniciAd) && kullanicilar.get(i).getPassword().equals(password)){
                            intent.putExtra("tema",2);
                            Singleton singleton = Singleton.getInstance();
                            singleton.setKullaniciAdi(kullanicilar.get(i).getKullaniciAdi());
                            finish();
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(),"Geçiş Başarılı",Toast.LENGTH_SHORT).show();
                            gecis = true;
                        }
                    }
                    gecis();
                }

            }
        });
    }

        public void gecis(){
            if (gecis==true){
                Toast.makeText(getApplicationContext(),"Geçiş Başarılı",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity.this,"Yanlış Kullanıcı Adı Veya Şifre",Toast.LENGTH_SHORT).show();
            }
        }


}