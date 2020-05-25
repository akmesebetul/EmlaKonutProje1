/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.IlceDao;
import entity.Ilce;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "ilceConverter")
public class ilceConverter implements Converter {

    private IlceDao ilcedao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        return this.getIlceDao().find(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        Ilce l = (Ilce) arg2;
        return l.getIlce_id().toString();

    }

    public IlceDao getIlceDao() {
        if (this.ilcedao == null) {
            this.ilcedao = new IlceDao
        ();
        }
        return ilcedao;
    }

}
