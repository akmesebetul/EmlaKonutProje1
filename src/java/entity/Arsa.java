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
public class Arsa {

    int arsaId;
    int alan;
    String adres;

    public Arsa() {
    }

    public Arsa(int alan, String adres) {
        this.alan = alan;
        this.adres = adres;
    }

    public Arsa(int arsaId, int alan, String adres) {
        this.arsaId = arsaId;
        this.alan = alan;
        this.adres = adres;
    }

    public int getArsaId() {
        return arsaId;
    }

    public void setArsaId(int arsaId) {
        this.arsaId = arsaId;
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
        return "Arsa{" + "arsaId=" + arsaId + ", alan=" + alan + ", adres=" + adres + '}';
    }

}
