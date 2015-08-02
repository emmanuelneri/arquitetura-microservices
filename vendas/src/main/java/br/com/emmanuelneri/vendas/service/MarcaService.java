package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.vendas.vo.MarcaVo;

import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
public class MarcaService implements Serializable {

    public List<MarcaVo> findAll() {
        return new ArrayList<>();
    }

}
