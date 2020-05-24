package controller;

import dao.IsyeriDao;
import entity.Isyeri;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class IsyeriController implements Serializable {

    private List<Isyeri> clist;
    private IsyeriDao isyeriDao;

    private Isyeri isyeri;

    public String updateForm(Isyeri konut) {
        this.isyeri = konut;
        return "konut";
    }

    public String clearForm() {
        this.isyeri = new Isyeri();
        return "kullanici";

    }

    public String deleteConfirm(Isyeri isyeri) {
        this.isyeri = isyeri;
        return "confirm_delete";
    }

    public String delete() {
        this.getIsyeriDao().delete(this.isyeri);
        this.isyeri=new Isyeri();
        return "kullanici";
    }

    public String update() {
        this.getIsyeriDao().update(this.isyeri);
        return "kullanici";

    }

    public String create() {
        this.getIsyeriDao().insert(this.isyeri);
        this.isyeri = new Isyeri();
        return "kullanici";
    }

    public List<Isyeri> getClist() {
        this.clist = this.getIsyeriDao().findAll();

        return clist;
    }

    public void setClist(List<Isyeri> clist) {
        this.clist = clist;
    }

    public IsyeriDao getIsyeriDao() {
        if (this.isyeriDao == null) {
            this.isyeriDao = new IsyeriDao();
        }

        return isyeriDao;
    }

    public void setIsyeriDao(IsyeriDao isyeriDao) {
        this.isyeriDao = isyeriDao;

    }

    public Isyeri getIsyeri() {
        if (this.isyeri == null) {
            this.isyeri = new Isyeri();
        }
        return isyeri;
    }

    public void setIsyeri(Isyeri isyeri) {

        this.isyeri = isyeri;

    }

}
