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
import dao.IlanTipiDao;
import entity.IlanTipi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class IlanTipiController implements Serializable {

    private List<IlanTipi> clist;
    private IlanTipiDao ilanTipiDao;

    private IlanTipi ilanTipi;

    public String updateForm(IlanTipi ilanTipi) {
        this.ilanTipi = ilanTipi;
        return "index";
    }

    public String clearForm() {
        this.ilanTipi = new IlanTipi();
        return "index";

    }

    public String deleteConfirm(IlanTipi ilanTipi) {
        this.ilanTipi = ilanTipi;
        return "confirm_delete";
    }

    public String delete() {
        this.getIlanTipiDao().delete(this.ilanTipi);
        this.ilanTipi = new IlanTipi();
        return "index";
    }

    public String update() {
        this.getIlanTipiDao().update(this.ilanTipi);
        return "index";

    }

    public String create() {
        this.getIlanTipiDao().insert(this.ilanTipi);
        this.ilanTipi = new IlanTipi();
        return "index";
    }

    public List<IlanTipi> getClist() {
        return clist;
    }

    public void setClist(List<IlanTipi> clist) {
        this.clist = clist;
    }

    public IlanTipiDao getIlanTipiDao() {
        if (this.ilanTipiDao == null) {
            this.ilanTipiDao = new IlanTipiDao();
        }

        return ilanTipiDao;
    }

    public void setIlanTipiDao(IlanTipiDao ilanTipiDao) {
        this.ilanTipiDao = ilanTipiDao;

    }

    public IlanTipi getIlanTipi() {
        if (this.ilanTipi == null) {
            this.ilanTipi = new IlanTipi();
        }
        return ilanTipi;
    }

    public void setIlanTipi(IlanTipi ilanTipi) {

        this.ilanTipi = ilanTipi;

    }

}
