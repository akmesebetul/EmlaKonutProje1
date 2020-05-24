package entity;

public class Konut {

    int konutId;
    int oda_sayisi;
    int alan;
    String adres;

    public Konut() {
    }
    
    public Konut(int alan, String adres,int oda_sayisi) {
        this.oda_sayisi = oda_sayisi;
        this.alan = alan;
        this.adres = adres;
    }

    public Konut(int konutId, int oda_sayisi, int alan, String adres) {
        this.konutId = konutId;
        this.oda_sayisi = oda_sayisi;
        this.alan = alan;
        this.adres = adres;
    }

    public int getKonutId() {
        return konutId;
    }

    public void setKonutId(int konutId) {
        this.konutId = konutId;
    }

    public int getOda_sayisi() {
        return oda_sayisi;
    }

    public void setOda_sayisi(int oda_sayisi) {
        this.oda_sayisi = oda_sayisi;
    }

    public int getAlan() {
        return alan;
    }

    public void setAlan(int alan) {
        this.alan = alan;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Konut{" + "konutId=" + konutId + ", oda_sayisi=" + oda_sayisi + ", alan=" + alan + ", adres=" + adres + '}';
    }
    

}
