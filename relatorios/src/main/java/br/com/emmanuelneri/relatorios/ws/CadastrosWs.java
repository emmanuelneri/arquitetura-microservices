package br.com.emmanuelneri.relatorios.ws;


import br.com.emmanuelneri.integrador.vo.ClienteVo;
import br.com.emmanuelneri.integrador.vo.ModeloVo;
import br.com.emmanuelneri.integrador.vo.VeiculoVo;
import br.com.emmanuelneri.relatorios.service.ClienteService;
import br.com.emmanuelneri.relatorios.service.ModeloService;
import br.com.emmanuelneri.relatorios.service.VeiculoService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("cadastros")
@Consumes(MediaType.APPLICATION_JSON)
public class CadastrosWs {

    @Inject
    private ClienteService clienteService;

    @Inject
    private ModeloService modeloService;

    @Inject
    private VeiculoService veiculoService;

    @PUT
    @Path("clientes/atualizar")
    public void atualizarCliente(ClienteVo cliente) {
        clienteService.save(cliente);
    }

    @PUT
    @Path("modelos/atualizar")
    public void atualizarModelo(ModeloVo modelo) {
        modeloService.save(modelo);
    }

    @PUT
    @Path("veiculos/atualizar")
    public void atualizarModelo(VeiculoVo veiculo) {
        veiculoService.save(veiculo);
    }

}
