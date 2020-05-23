/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author tr
 */
public class Kullanici {
     int kullaniciId;
    String kullanciAdi;
    String sifre;
    String adSoyad;
    int adminMi;
    public Kullanici() {
    }

    public Kullanici(int kullaniciId, String kullanciAdi, String sifre, String adSoyad, int adminMi) {
        this.kullaniciId = kullaniciId;
        this.kullanciAdi = kullanciAdi;
        this.sifre = sifre;
        this.adSoyad = adSoyad;
        this.adminMi = adminMi;
    }

    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getKullanciAdi() {
        return kullanciAdi;
    }

    public void setKullanciAdi(String kullanciAdi) {
        this.kullanciAdi = kullanciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public int getAdminMi() {
        return adminMi;
    }

    public void setAdminMi(int adminMi) {
        this.adminMi = adminMi;
    }

    @Override
    public String toString() {
        return "Kullanici{" + "kullaniciId=" + kullaniciId + ", kullanciAdi=" + kullanciAdi + ", sifre=" + sifre + ", adSoyad=" + adSoyad + ", adminMi=" + adminMi + '}';
    }
    
    
}


