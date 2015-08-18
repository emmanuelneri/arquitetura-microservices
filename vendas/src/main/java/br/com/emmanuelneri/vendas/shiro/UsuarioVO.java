package br.com.emmanuelneri.vendas.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UsuarioVO implements Serializable {

    private final Long id;
    private final String email;
    private final String nome;
    private List<ModuloVO> modulos;

    @SuppressWarnings("unchecked")
    public UsuarioVO(Map<String, Object> tokenMap) {
        this.id = Long.valueOf((Integer) tokenMap.get("id"));
        this.email = (String) tokenMap.get("email");
        this.nome = (String) tokenMap.get("nome");
        this.modulos = getModulosToken((List<Map<String, String>>) tokenMap.get("modulosUsuario"));
    }

    public UsuarioVO(String email) {
        this.email = email;
        this.nome = email;
        this.id = null;
    }

    private List<ModuloVO> getModulosToken(List<Map<String, String>> listaMapModulos) {
       return listaMapModulos.stream().map(mapModulo -> new ModuloVO(mapModulo.get("nome"),
               mapModulo.get("chave"), mapModulo.get("url"))).collect(Collectors.toList());
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Set<String> getRoles() {
        return new HashSet<>();
    }

    public List<ModuloVO> getModulos() {
        return modulos;
    }

    public List<ModuloVO> getModulosMenu() {
        List<ModuloVO> modulosMenu = new ArrayList<>(modulos);
        modulosMenu.removeIf(moduloVO -> moduloVO.getNome().equals(ModuloVO.MODULO_CADASTRO));
        return modulos;
    }
}
