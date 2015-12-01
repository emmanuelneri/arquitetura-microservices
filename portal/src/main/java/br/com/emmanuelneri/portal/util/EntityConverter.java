package br.com.emmanuelneri.portal.util;

import br.com.emmanuelneri.integrador.interfaces.Model;
import org.omnifaces.converter.SelectItemsConverter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import java.io.Serializable;

@FacesConverter(value = "entityConverter")
public class EntityConverter extends SelectItemsConverter {

    @Override
    @SuppressWarnings("unchecked")
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Serializable id = (value instanceof Model<?>) ? ((Model<Serializable>) value).getId() : null;
        return (id != null) ? id.toString() : null;
    }

}