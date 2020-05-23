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
public class ProjeIl {
    int proje_il_id;
    int proje_id;
    int il_id;

    public ProjeIl() {
    }

    public ProjeIl(int proje_il_id, int proje_id, int il_id) {
        this.proje_il_id = proje_il_id;
        this.proje_id = proje_id;
        this.il_id = il_id;
    }

    public int getProje_il_id() {
        return proje_il_id;
    }

    public void setProje_il_id(int proje_il_id) {
        this.proje_il_id = proje_il_id;
    }

    public int getProje_id() {
        return proje_id;
    }

    public void setProje_id(int proje_id) {
        this.proje_id = proje_id;
    }

    public int getIl_id() {
        return il_id;
    }

    public void setIl_id(int il_id) {
        this.il_id = il_id;
    }

    @Override
    public String toString() {
        return "ProjeIl{" + "proje_il_id=" + proje_il_id + ", proje_id=" + proje_id + ", il_id=" + il_id + '}';
    }
    
    
    
}
