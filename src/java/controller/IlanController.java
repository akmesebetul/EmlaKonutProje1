package controller;

import dao.IlanDao;
import entity.Ilan;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import util.LoginController;

@Named
@SessionScoped
public class IlanController implements Serializable {

    private List<Ilan> clist;
    private IlanDao ilanDao;
    private Ilan ilan;

    public String updateForm(Ilan ilan) {
        this.ilan = ilan;
        return "ilan";
    }

    public String clearForm() {
        this.ilan = new Ilan();
        return "ilan";

    }

    public String deleteConfirm(Ilan ilan) {
        this.ilan = ilan;
        return "confirm_delete_ilan";
    }

    public String delete() {
        this.getIlanDao().delete(this.ilan);
        this.ilan = new Ilan();
        return "ilan";
    }

    public String update() {
        this.getIlanDao().update(this.ilan);
        return "ilan";

    }

    public String create() {
        this.ilan.setKullanici(LoginController.getSessionUser());
        this.getIlanDao().insert(this.ilan);
        if (ilan.getKullanici().getAdminMi() == 1) {
            this.ilan = new Ilan();    
            return "ilan";
        } else {       
            this.ilan = new Ilan();
            return "home";
        }
    }
    
     public String goToIlanGiris() {
        return "ilangiris";
    }

    public List<Ilan> getClist() {
        this.clist = this.getIlanDao().findAll();
        return clist;
    }

    public void setClist(List<Ilan> clist) {
        this.clist = clist;
    }

    public IlanDao getIlanDao() {
        if (this.ilanDao == null) {
            this.ilanDao = new IlanDao();
        }

        return ilanDao;
    }

    public void setIlanDao(IlanDao ilanDao) {
        this.ilanDao = ilanDao;

    }

    public Ilan getIlan() {
        if (this.ilan == null) {
            this.ilan = new Ilan();
        }
        return ilan;
    }

    public void setIlan(Ilan ilan) {
        this.ilan = ilan;

    }

}
