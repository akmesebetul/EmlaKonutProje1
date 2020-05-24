package controller;

import dao.ProjeDao;
import entity.Proje;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ProjeController implements Serializable {

    private List<Proje> clist;
    private ProjeDao projeDao;

    private Proje proje;

    public String updateForm(Proje proje) {
        this.proje = proje;
        return "kullanici";
    }

    public String clearForm() {
        this.proje = new Proje();
        return "kullanici";

    }

    public String deleteConfirm(Proje proje) {
        this.proje = proje;
        return "confirm_delete";
    }

    public String delete() {
        this.getProjeDao().delete(this.proje);
        this.proje=new Proje();
        return "kullanici";
    }

    public String update() {
        this.getProjeDao().update(this.proje);
        return "kullanici";

    }

    public String create() {
        this.getProjeDao().insert(this.proje);
        this.proje = new Proje();
        return "kullanici";
    }

    public List<Proje> getClist() {
        this.clist = this.getProjeDao().findAll();

        return clist;
    }

    public void setClist(List<Proje> clist) {
        this.clist = clist;
    }

    public ProjeDao getProjeDao() {
        if (this.projeDao == null) {
            this.projeDao = new ProjeDao();
        }

        return projeDao;
    }

    public void setProjeDao(ProjeDao projeDao) {
        this.projeDao = projeDao;

    }

    public Proje getProje() {
        if (this.proje == null) {
            this.proje = new Proje();
        }
        return proje;
    }

    public void setProje(Proje proje) {

        this.proje = proje;

    }

}
