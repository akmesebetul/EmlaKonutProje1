
package converter;

import dao.KullaniciDao;

import entity.Kullanici;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author GulistanColak
 */

@FacesConverter(value = "kullaniciConverter")
public class KullaniciConverter implements Converter {

    private KullaniciDao kullanicidao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        return this.getKullaniciDao().find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Kullanici kullanici = (Kullanici) arg2;
        return Integer.toString(kullanici.getKullaniciId());

    }

    public KullaniciDao getKullaniciDao() {
        if (this.kullanicidao == null) {
            this.kullanicidao = new KullaniciDao();
       
        }
        return kullanicidao;
    }

}
