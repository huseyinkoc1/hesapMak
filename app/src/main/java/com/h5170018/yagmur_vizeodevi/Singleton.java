package com.h5170018.yagmur_vizeodevi;

public class Singleton {

    private String kullaniciAdi;
    private  static Singleton singleton;


    private Singleton(){

    }


    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public static Singleton getInstance(){

        if (singleton == null){
            singleton = new Singleton();
        }
        return  singleton;
    }

}
