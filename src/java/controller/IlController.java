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

import dao.IlDao;
import entity.Il;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class IlController implements Serializable {

    private List<Il> clist;
    private IlDao ilDao;

    private Il il;

    public String updateForm(Il il) {
        this.il = il;
        return "il";
    }

    public String clearForm() {
        this.il = new Il();
        return "il";

    }

    public String deleteConfirm(Il il) {
        this.il = il;
        return "confirm_delete";
    }

    public String delete() {
        this.getIlDao().delete(this.il);
        this.il=new Il();
        return "il";
    }

    public String update() {
        this.getIlDao().update(this.il);
        return "il";

    }

    public String create() {
        this.getIlDao().insert(this.il);
        this.il = new Il();
        return "il";
    }

    public List<Il> getClist() {
        this.clist = this.getIlDao().findAll();

        return clist;
    }

    public void setClist(List<Il> clist) {
        this.clist = clist;
    }

    public IlDao getIlDao() {
        if (this.ilDao == null) {
            this.ilDao = new IlDao();
        }

        return ilDao;
    }

    public void setIlDao(IlDao ilDao) {
        this.ilDao = ilDao;

    }

    public Il getIl() {
        if (this.il == null) {
            this.il = new Il();
        }
        return il;
    }

    public void setIl(Il il) {
        this.il = il;
    }

}

