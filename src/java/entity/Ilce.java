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

    public class Ilce {
    int ilce_id;
    String ilce_adi;
    Il il;

    public Ilce(int ilce_id, String ilce_adi, Il il) {
        this.ilce_id = ilce_id;
        this.ilce_adi = ilce_adi;
        this.il = il;
    }

    public Ilce() {
    }

    public int getIlce_id() {
        return ilce_id;
    }

    public void setIlce_id(int ilce_id) {
        this.ilce_id = ilce_id;
    }

    public String getIlce_adi() {
        return ilce_adi;
    }

    public void setIlce_adi(String ilce_adi) {
        this.ilce_adi = ilce_adi;
    }

    public Il getIl() {
       if(il == null)
           il = new Il();
        return il;
    }

    public void setIl(Il il) {
        this.il = il;
    }
    
    public String getIlAdi(){
        return this.il.getIl_adi();
    }

    @Override
    public String toString() {
        return ilce_adi;
    }
    
}
