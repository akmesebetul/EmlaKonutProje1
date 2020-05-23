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

import dao.ProjeIlDao;
import entity.ProjeIl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ProjeIlController implements Serializable {

    private List<ProjeIl> clist;
    private ProjeIlDao projeildao;

    private ProjeIl projeil;

    public String updateForm(ProjeIl projeil) {
        this.projeil = projeil;
        return "kullanici";
    }

    public String clearForm() {
        this.projeil = new ProjeIl();
        return "kullanici";

    }

    public String deleteConfirm(ProjeIl projeil) {
        this.projeil = projeil;
        return "confirm_delete";
    }

    public String delete() {
        this.getProjeIlDao().delete(this.projeil);
        this.projeil=new ProjeIl();
        return "kullanici";
    }

    public String update() {
        this.getProjeIlDao().update(this.projeil);
        return "kullanici";

    }

    public String create() {
        this.getProjeIlDao().insert(this.projeil);
        this.projeil = new ProjeIl();
        return "kullanici";
    }

    public List<ProjeIl> getClist() {
        this.clist = this.getProjeIlDao().findAll();

        return clist;
    }

    public void setClist(List<ProjeIl> clist) {
        this.clist = clist;
    }

    public ProjeIlDao getProjeIlDao() {
        if (this.projeildao == null) {
            this.projeildao = new ProjeIlDao();
        }

        return projeildao;
    }

    public void setProjeIlDao(ProjeIlDao projeildao) {
        this.projeildao = projeildao;

    }

    public ProjeIl getProjeil() {
        if (this.projeil == null) {
            this.projeil = new ProjeIl();
        }
        return projeil;
    }

    public void setProjeil(ProjeIl projeil) {

        this.projeil = projeil;

    }

}
