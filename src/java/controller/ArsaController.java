/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author tr
 */
import dao.ArsaDao;
import entity.Arsa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ArsaController implements Serializable {

    private List<Arsa> clist;
    private ArsaDao arsaDao;

    private Arsa arsa;

    public String updateForm(Arsa arsa) {
        this.arsa = arsa;
        return "index";
    }

    public String clearForm() {
        this.arsa = new Arsa();
        return "index";

    }

    public String deleteConfirm(Arsa arsa) {
        this.arsa = arsa;
        return "confirm_delete";
    }

    public String delete() {
        this.getArsaDao().delete(this.arsa);
        this.arsa = new Arsa();
        return "index";
    }

    public String update() {
        this.getArsaDao().update(this.arsa);
        return "index";

    }

    public String create() {
        this.getArsaDao().insert(this.arsa);
        this.arsa = new Arsa();
        return "index";
    }

    public List<Arsa> getClist() {
        this.clist = this.getArsaDao().findAll();

        return clist;
    }

    public void setClist(List<Arsa> clist) {
        this.clist = clist;
    }

    public ArsaDao getArsaDao() {
        if (this.arsaDao == null) {
            this.arsaDao = new ArsaDao();
        }

        return arsaDao;
    }

    public void setArsaDao(ArsaDao arsaDao) {
        this.arsaDao = arsaDao;

    }

    public Arsa getArsa() {
        if (this.arsa == null) {
            this.arsa = new Arsa();
        }
        return arsa;
    }

    public void setArsa(Arsa arsa) {

        this.arsa = arsa;

    }

}
