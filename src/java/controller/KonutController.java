package controller;

import dao.KonutDao;
import entity.Konut;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class KonutController implements Serializable {

    private List<Konut> clist;
    private KonutDao konutDao;

    private Konut konut;

    public String updateForm(Konut konut) {
        this.konut = konut;
        return "konut";
    }

    public String clearForm() {
        this.konut = new Konut();
        return "kullanici";

    }

    public String deleteConfirm(Konut konut) {
        this.konut = konut;
        return "confirm_delete";
    }

    public String delete() {
        this.getKonutDao().delete(this.konut);
        this.konut=new Konut();
        return "kullanici";
    }

    public String update() {
        this.getKonutDao().update(this.konut);
        return "kullanici";

    }

    public String create() {
        this.getKonutDao().insert(this.konut);
        this.konut = new Konut();
        return "kullanici";
    }

    public List<Konut> getClist() {
        this.clist = this.getKonutDao().findAll();

        return clist;
    }

    public void setClist(List<Konut> clist) {
        this.clist = clist;
    }

    public KonutDao getKonutDao() {
        if (this.konutDao == null) {
            this.konutDao = new KonutDao();
        }

        return konutDao;
    }

    public void setKonutDao(KonutDao konutDao) {
        this.konutDao = konutDao;

    }

    public Konut getKonut() {
        if (this.konut == null) {
            this.konut = new Konut();
        }
        return konut;
    }

    public void setKonut(Konut konut) {

        this.konut = konut;

    }

}
