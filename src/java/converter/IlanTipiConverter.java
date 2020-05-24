/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.IlanTipiDao;
import entity.IlanTipi;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="ilanTipiConverter")
public class IlanTipiConverter implements Converter {
    private IlanTipiDao ilanTipiDao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getIlanTipiDao().find(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        IlanTipi ilanTipi = (IlanTipi) value;
        return ilanTipi.getTip_adi();
    }

    public IlanTipiDao getIlanTipiDao() {
        if(this.ilanTipiDao==null)
            this.ilanTipiDao=new IlanTipiDao();
        return ilanTipiDao;
    }    
}
