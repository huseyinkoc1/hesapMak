package com.h5170018.yagmur_vizeodevi;

public class Kullanici {

    private String kullaniciAdi;
    private String password;
    private String kullaniciId;
    private String homedizi;
    private String acilisiTarihi;
    private int   tImage ;

    public int gettImage() {
        return tImage;
    }

    public void settImage(int tImage) {
        this.tImage = tImage;
    }

    private int kalanSure;

    public Kullanici(String kullaniciAdi, String password, int tImage) {
        this.kullaniciAdi = kullaniciAdi;
        this.password = password;
        this.tImage = tImage;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(String kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getHomedizi() {
        return homedizi;
    }

    public void setHomedizi(String homedizi) {
        this.homedizi = homedizi;
    }

    public String getAcilisiTarihi() {
        return acilisiTarihi;
    }

    public void setAcilisiTarihi(String acilisiTarihi) {
        this.acilisiTarihi = acilisiTarihi;
    }

    public int getKalanSure() {
        return kalanSure;
    }

    public void setKalanSure(int kalanSure) {
        this.kalanSure = kalanSure;
    }
}
