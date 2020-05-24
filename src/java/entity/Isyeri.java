
package entity;


public class Isyeri {
    int isyeri_id;
    String adres;
    int alan;

    public Isyeri() {
    }
    
    public Isyeri(int alan, String adres) {
        this.adres = adres;
        this.alan = alan;
    }


    public Isyeri(int isyeri_id, String adres, int alan) {
        this.isyeri_id = isyeri_id;
        this.adres = adres;
        this.alan = alan;
    }

    public int getIsyeri_id() {
        return isyeri_id;
    }

    public void setIsyeri_id(int isyeri_id) {
        this.isyeri_id = isyeri_id;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getAlan() {
        return alan;
    }

    public void setAlan(int alan) {
        this.alan = alan;
    }

    @Override
    public String toString() {
        return "IsYeri{" + "isyeri_id=" + isyeri_id + ", adres=" + adres + ", alan=" + alan + '}';
    }
    
    
    
}
