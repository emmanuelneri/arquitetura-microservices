package br.com.emmanuelneri.integrador.json;

import br.com.emmanuelneri.integrador.interfaces.Constantes;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public class LocalDateJsonAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String dateString) throws Exception {
        return LocalDate.parse(dateString, Constantes.DATE_TIME_FORMAT_DEFAULT);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        return Constantes.DATE_TIME_FORMAT_DEFAULT.format(localDate);
    }
}
