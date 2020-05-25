
package converter;

import dao.EmlakDao;
import entity.Emlak;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "emlakConverter")
public class EmlakConverter implements Converter {

    private EmlakDao emlakdao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        return this.getEmlakDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Emlak l = (Emlak) arg2;
        return l.getEmlakId().toString();

    }

    public EmlakDao getEmlakDao() {
        if (this.emlakdao == null) {
            this.emlakdao = new EmlakDao();
       
        }
        return emlakdao;
    }

}
