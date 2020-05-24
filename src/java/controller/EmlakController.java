package controller;

import dao.EmlakDao;
import entity.Emlak;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class EmlakController implements Serializable {

    private List<Emlak> clist;
    private EmlakDao emlakDao;

    private Emlak emlak;

    public String updateForm(Emlak emlak) {
        this.emlak = emlak;
        return "kullanici";
    }

    public String clearForm() {
        this.emlak = new Emlak();
        return "kullanici";

    }

    public String deleteConfirm(Emlak emlak) {
        this.emlak = emlak;
        return "confirm_delete";
    }

    public String delete() {
        this.getEmlakDao().delete(this.emlak);
        this.emlak=new Emlak();
        return "kullanici";
    }

    public String update() {
        this.getEmlakDao().update(this.emlak);
        return "kullanici";

    }

    public String create() {
        this.getEmlakDao().insert(this.emlak);
        this.emlak = new Emlak();
        return "kullanici";
    }

    public List<Emlak> getClist() {
        this.clist = this.getEmlakDao().findAll();

        return clist;
    }

    public void setClist(List<Emlak> clist) {
        this.clist = clist;
    }

    public EmlakDao getEmlakDao() {
        if (this.emlakDao == null) {
            this.emlakDao = new EmlakDao();
        }

        return emlakDao;
    }

    public void setEmlakDao(EmlakDao emlakDao) {
        this.emlakDao = emlakDao;

    }

    public Emlak getEmlak() {
        if (this.emlak == null) {
            this.emlak = new Emlak();
        }
        return emlak;
    }

    public void setEmlak(Emlak emlak) {

        this.emlak = emlak;

    }
    
    public String navigateToIlanEkle (){
    return "ilanekle";
    }


}
