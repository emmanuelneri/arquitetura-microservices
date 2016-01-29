package br.com.emmanuelneri.integrador.service;


import br.com.emmanuelneri.integrador.anotations.CadastroClientWs;
import org.codehaus.jackson.map.ObjectMapper;

import javax.inject.Inject;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

public class GenericWsService<T> implements Serializable {

    private Class<T> type;

    public GenericWsService() {
        Class<?> clazz = getClass();
        do {
            if (clazz.getSuperclass().equals(GenericWsService.class)) {
                break;
            }
        } while ((clazz = clazz.getSuperclass()) != null);

        this.type = (Class<T>) ((ParameterizedType) clazz
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Inject
    @CadastroClientWs
    protected WebTarget clientWs;

    protected List<T> getList(String url) {
        final String json = getJson(url);

        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return  objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, type));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    protected T get(String url) {
        final String json = getJson(url);

        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return  objectMapper.readValue(json, objectMapper.getTypeFactory().constructType(type));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected String getJson(String url) {
        return clientWs.path(url).request(MediaType.APPLICATION_JSON).get(String.class);
    }

}
