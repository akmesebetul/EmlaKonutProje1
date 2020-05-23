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
public class IlanTipi {
    int tip_id;
    String tip_adi;

    public IlanTipi() {
    }

    public IlanTipi(int tip_id, String tip_adi) {
        this.tip_id = tip_id;
        this.tip_adi = tip_adi;
    }

    public int getTip_id() {
        if(tip_adi.equals("Satılık"))
        return 1;
        else if(tip_adi.equals("Kiralık"))
        return 2;
        else if(tip_adi.equals("Günlük Kiralık"))
        return 3;
        
        else return 0;
    }

    public void setTip_id(int tip_id) {
        this.tip_id = tip_id;
    }

    public String getTip_adi() {
        return tip_adi;
    }

    public void setTip_adi(String tip_adi) {
        this.tip_adi = tip_adi;
    }

    @Override
    public String toString() {
        return tip_adi;
    }
    
    
}
