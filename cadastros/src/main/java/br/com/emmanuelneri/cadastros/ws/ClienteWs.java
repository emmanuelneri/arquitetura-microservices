package br.com.emmanuelneri.cadastros.ws;

import br.com.emmanuelneri.cadastros.model.Cliente;
import br.com.emmanuelneri.cadastros.service.ClienteService;
import br.com.emmanuelneri.integrador.vo.ClienteVo;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("cliente")
@Produces(MediaType.APPLICATION_JSON)
public class ClienteWs {

    @Inject
    private ClienteService clienteService;

    @GET
    @Path("buscar/todos")
    public Response buscarTodosClientes() {
        final List<Cliente> clientes = clienteService.findAll();
        return Response.ok(transformarClientesParaVo(clientes)).build();
    }

    @GET
    @Path("buscar/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        final Cliente cliente = clienteService.findById(id);
        return Response.ok(toVo(cliente)).build();
    }

    private List<ClienteVo> transformarClientesParaVo(List<Cliente> clientes) {
        return clientes.stream().map(this::toVo).collect(Collectors.toList());
    }

    private ClienteVo toVo(Cliente cliente) {
        return new ClienteVo(cliente.getId(), cliente.getNome(), cliente.getCpfCnpj());
    }
}
