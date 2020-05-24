/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.DecimalFormat;

/**
 *
 * @author MalatyaPc
 */
public class Ilan {
    int ilan_id;
    String ilan_baslik;
    String ilan_aciklama;
    int fiyat;
    IlanTipi ilan_tipi;
    Kullanici kullanici;
    Ilce ilce;
    Emlak emlak;
    String iletisim_no;

    public Ilan() {
    }

    public Ilan(int ilan_id, String ilan_baslik, String ilan_aciklama, int fiyat, IlanTipi ilan_tipi, Kullanici kullanici, Ilce ilce, Emlak emlak, String iletisim_no) {
        this.ilan_id = ilan_id;
        this.ilan_baslik = ilan_baslik;
        this.ilan_aciklama = ilan_aciklama;
        this.fiyat = fiyat;
        this.ilan_tipi = ilan_tipi;
        this.kullanici = kullanici;
        this.ilce = ilce;
        this.emlak = emlak;
        this.iletisim_no = iletisim_no;
    }

    public int getIlan_id() {
        return ilan_id;
    }

    public void setIlan_id(int ilan_id) {
        this.ilan_id = ilan_id;
    }

    public String getIlan_baslik() {
        return ilan_baslik;
    }

    public void setIlan_baslik(String ilan_baslik) {
        this.ilan_baslik = ilan_baslik;
    }

    public String getIlan_aciklama() {
        return ilan_aciklama;
    }

    public void setIlan_aciklama(String ilan_aciklama) {
        this.ilan_aciklama = ilan_aciklama;
    }

    public int getFiyat(){
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public IlanTipi getIlan_tipi() {
        if(ilan_tipi == null)
            ilan_tipi = new IlanTipi();
        return ilan_tipi;
    }

    public void setIlan_tipi(IlanTipi ilan_tipi) {
        this.ilan_tipi = ilan_tipi;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Ilce getIlce() {
        if(ilce == null)
            ilce = new Ilce();
        return ilce;
    }

    public void setIlce(Ilce ilce) {
        this.ilce = ilce;
    }

    public Emlak getEmlak() {
        if(emlak == null)
            emlak = new Emlak();
        return emlak;
    }

    public void setEmlak(Emlak emlak) {
        this.emlak = emlak;
    }

    public String getIletisim_no() {
        return iletisim_no;
    }

    public void setIletisim_no(String iletisim_no) {
        this.iletisim_no = iletisim_no;
    }

    @Override
    public String toString() {
        return "Ilan{" + "ilan_id=" + ilan_id + ", ilan_baslik=" + ilan_baslik + ", ilan_aciklama=" + ilan_aciklama + ", fiyat=" + fiyat + ", ilan_tipi=" + ilan_tipi + ", kullanici=" + kullanici + ", ilce=" + ilce + ", emlak=" + emlak + ", iletisim_no=" + iletisim_no + '}';
    }
    
    
}
