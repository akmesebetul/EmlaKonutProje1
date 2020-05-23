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
public class Il {
     int il_id;
    String il_adi;

    public Il() {
    }

    public Il(int il_id, String il_adi) {
        this.il_id = il_id;
        this.il_adi = il_adi;
    }

    public int getIl_id() {
        return il_id;
    }

    public void setIl_id(int il_id) {
        this.il_id = il_id;
    }

    public String getIl_adi() {
        return il_adi;
    }

    public void setIl_adi(String il_adi) {
        this.il_adi = il_adi;
    }

    @Override
    public String toString() {
        return il_adi;
    }
    
}
