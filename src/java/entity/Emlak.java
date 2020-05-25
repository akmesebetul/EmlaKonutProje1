/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author MalatyaPc
 */
public class Emlak {

    Long emlakId;
    int arsaId;
    int isyeriId;
    int konutId;
    int projeIlId;
    String emlakTipi;
    int alan;
    String adres;
    int odaSayisi;

    public Emlak() {
    }

    public Emlak(Long emlakId, int arsaId, int isyeriId, int konutId, int projeIlId) {
        this.emlakId = emlakId;
        this.arsaId = arsaId;
        this.isyeriId = isyeriId;
        this.konutId = konutId;
        this.projeIlId = projeIlId;
    }

    public Long getEmlakId() {
        return emlakId;
    }

    public void setEmlakId(Long emlakId) {
        this.emlakId = emlakId;
    }

    public int getArsaId() {
        return arsaId;
    }

    public void setArsaId(int arsaId) {
        this.arsaId = arsaId;
    }

    public int getIsyeriId() {
        return isyeriId;
    }

    public void setIsyeriId(int isyeriId) {
        this.isyeriId = isyeriId;
    }

    public int getKonutId() {
        return konutId;
    }

    public void setKonutId(int konutId) {
        this.konutId = konutId;
    }

    public int getProjeIlId() {
        return projeIlId;
    }

    public void setProjeIlId(int projeIlId) {
        this.projeIlId = projeIlId;
    }

    public String getEmlakTipi() {
        return emlakTipi;
    }

    public void setEmlakTipi(String emlakTipi) {
        this.emlakTipi = emlakTipi;
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

    public int getOdaSayisi() {
        return odaSayisi;
    }

    public void setOdaSayisi(int odaSayisi) {
        this.odaSayisi = odaSayisi;
    }

    @Override
    public String toString() {
        return "Emlak{" + "emlakId=" + emlakId + ", arsaId=" + arsaId + ", isyeriId=" + isyeriId + ", konutId=" + konutId + ", projeIlId=" + projeIlId + ", emlakTipi=" + emlakTipi + ", alan=" + alan + ", adres=" + adres + ", odaSayisi=" + odaSayisi + '}';
    }

}
