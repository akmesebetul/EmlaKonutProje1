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
public class Proje {
     int projeId;
    String projeAdi;
    String projeSahibi;
    int altFiyat;
    int ustFiyat;
    String projeAdresi;

    public Proje() {
    }

    public Proje(int projeId, String projeAdi, String projeSahibi, int altFiyat, int ustFiyat, String projeAdresi) {
        this.projeId = projeId;
        this.projeAdi = projeAdi;
        this.projeSahibi = projeSahibi;
        this.altFiyat = altFiyat;
        this.ustFiyat = ustFiyat;
        this.projeAdresi = projeAdresi;
    }

    public int getProjeId() {
        return projeId;
    }

    public void setProjeId(int projeId) {
        this.projeId = projeId;
    }

    public String getProjeAdi() {
        return projeAdi;
    }

    public void setProjeAdi(String projeAdi) {
        this.projeAdi = projeAdi;
    }

    public String getProjeSahibi() {
        return projeSahibi;
    }

    public void setProjeSahibi(String projeSahibi) {
        this.projeSahibi = projeSahibi;
    }

    public int getAltFiyat() {
        return altFiyat;
    }

    public void setAltFiyat(int altFiyat) {
        this.altFiyat = altFiyat;
    }

    public int getUstFiyat() {
        return ustFiyat;
    }

    public void setUstFiyat(int ustFiyat) {
        this.ustFiyat = ustFiyat;
    }

    public String getProjeAdresi() {
        return projeAdresi;
    }

    public void setProjeAdresi(String projeAdresi) {
        this.projeAdresi = projeAdresi;
    }

    @Override
    public String toString() {
        return "Proje{" + "projeId=" + projeId + ", projeAdi=" + projeAdi + ", projeSahibi=" + projeSahibi + ", altFiyat=" + altFiyat + ", ustFiyat=" + ustFiyat + ", projeAdresi=" + projeAdresi + '}';
    }
    
    
    
}


