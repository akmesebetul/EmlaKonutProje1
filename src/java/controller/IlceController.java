package controller;

import dao.IlceDao;
import entity.Ilce;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class IlceController implements Serializable {

    private List<Ilce> clist;
    private IlceDao ilceDao;

    private Ilce ilce;

    public String updateForm(Ilce ilce) {
        this.ilce = ilce;
        return "kullanici";
    }

    public String clearForm() {
        this.ilce = new Ilce();
        return "kullanici";

    }

    public String deleteConfirm(Ilce ilce) {
        this.ilce = ilce;
        return "confirm_delete";
    }

    public String delete() {
        this.getIlceDao().delete(this.ilce);
        this.ilce=new Ilce();
        return "kullanici";
    }

    public String update() {
        this.getIlceDao().update(this.ilce);
        return "kullanici";

    }

    public String create() {
        this.getIlceDao().insert(this.ilce);
        this.ilce = new Ilce();
        return "kullanici";
    }

    public List<Ilce> getClist() {
        this.clist = this.getIlceDao().findAll();

        return clist;
    }

    public void setClist(List<Ilce> clist) {
        this.clist = clist;
    }

    public IlceDao getIlceDao() {
        if (this.ilceDao == null) {
            this.ilceDao = new IlceDao();
        }

        return ilceDao;
    }

    public void setIlceDao(IlceDao ilceDao) {
        this.ilceDao = ilceDao;

    }

    public Ilce getIlce() {
        if (this.ilce == null) {
            this.ilce = new Ilce();
        }
        return ilce;
    }

    public void setIlce(Ilce ilce) {

        this.ilce = ilce;

    }

}
