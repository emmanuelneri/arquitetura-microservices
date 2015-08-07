package br.com.emmanuelneri.vendas.service;

import br.com.emmanuelneri.vendas.util.GenericWsService;
import br.com.emmanuelneri.vendas.vo.MarcaVo;

import javax.inject.Named;
import java.util.List;

@Named
public class MarcaService extends GenericWsService<MarcaVo> {

    public List<MarcaVo> findAll() {
        return getList("/marca/buscar/todos");
    }

}
