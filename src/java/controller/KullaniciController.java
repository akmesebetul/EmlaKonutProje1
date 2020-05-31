package controller;

import dao.KullaniciDao;
import entity.Kullanici;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named
@SessionScoped
public class KullaniciController implements Serializable {

    private List<Kullanici> clist;
    private KullaniciDao kullaniciDao;

    private Kullanici kullanici;

    public String updateForm(Kullanici kulanici) {
        this.kullanici = kulanici;
        return "kullanici";
    }

    public String clearForm() {
        this.kullanici = new Kullanici();
        return "kullanici";

    }

    public String deleteConfirm(Kullanici kulanici) {
        this.kullanici = kulanici;
        return "confirm_delete";
    }

    public String delete() {
        this.getKullaniciDao().delete(this.kullanici);
        this.kullanici=new Kullanici();
        return "kullanici";
    }

    public String update() {
        this.getKullaniciDao().update(this.kullanici);
        return "kullanici";

    }
    
     public String goToIlan() {
        return "ilan";

    }
     
    


    public String create() {
        this.getKullaniciDao().insert(this.kullanici);
        this.kullanici = new Kullanici();
        return "kullanici";
    }
    
    public String checkUserAddable(){
        if(this.getKullaniciDao().checkUserAddable(this.kullanici)){
            this.getKullaniciDao().insert(kullanici);
            return "index";
        }
        else{
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Bu kullanıcı adı zaten kullanılıyor"));
            return "signup";    
        }
            
    }

    public List<Kullanici> getClist() {
        this.clist = this.getKullaniciDao().findAll();

        return clist;
    }

    public void setClist(List<Kullanici> clist) {
        this.clist = clist;
    }

    public KullaniciDao getKullaniciDao() {
        if (this.kullaniciDao == null) {
            this.kullaniciDao = new KullaniciDao();
        }

        return kullaniciDao;
    }

    public void setKullaniciDao(KullaniciDao kullaniciDao) {
        this.kullaniciDao = kullaniciDao;

    }

    public Kullanici getKullanici() {
        if (this.kullanici == null) {
            this.kullanici = new Kullanici();
        }
        return kullanici;
    }

    public void setKullanici(Kullanici kulanici) {

        this.kullanici = kulanici;

    }

}
