/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.KullaniciDao;
import entity.Kullanici;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author sinem
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private static Kullanici user;
    private KullaniciDao kullaniciDao;

    public String login() {
        user = this.getKullaniciDao().kullaniciBilgileriGecerliMi(user.getKullanciAdi(), user.getSifre());

        if (user == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı kullanıcı adı veya şifre"));
            return "/frontend/login";
        } else {
            //Admin olma durumu        
            if (user.getAdminMi() == 1) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.user);
                // Admin içine yönlendirince hata veriyor, admin içine yönlendirilecek
                return "/ilan.xhtml";
            } //Normal geçerli kullanıcı durumu
            else {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.user);
                return "/home.xhtml";
            }
        }

    }

    public String openLoginPage() {
        return "login";

    }

    public String openIlanGiris() {
        return "ilangiris";

    }

    public String openSignUpPage() {
        return "signup";

    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        user = null;
        return "index";
    }

    public Kullanici getUser() {
        if (this.user == null) {
            this.user = new Kullanici();
        }
        return user;
    }

    public void setUser(Kullanici user) {
        this.user = user;
    }

    public static Kullanici getSessionUser() {
        return LoginController.user;
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
}
