package br.com.emmanuelneri.portal.vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UsuarioVO {

    private final Long id;
    private final String email;
    private final String nome;
    private List<ModuloVO> modulos;

    public UsuarioVO(Map<String, Object> tokenMap) {
        this.id = Long.valueOf((long)((Integer) tokenMap.get("id")).intValue());
        this.email = (String)tokenMap.get("email");
        this.nome = (String)tokenMap.get("nome");
        this.modulos = this.getModulosToken((List)tokenMap.get("modulosUsuario"));
    }

    public UsuarioVO(Long id, String email, String nome, List<ModuloVO> modulos) {
        this.id = id;
        this.email = email;
        this.nome = nome;
        this.modulos = modulos;
    }

    public UsuarioVO(String email) {
        this.email = email;
        this.nome = email;
        this.id = null;
    }

    private List<ModuloVO> getModulosToken(List<Map<String, String>> listaMapModulos) {
        return (List)listaMapModulos.stream().map((mapModulo) -> {
            return new ModuloVO((String) mapModulo.get("nome"), (String) mapModulo.get("chave"), (String) mapModulo.get("url"));
        }).collect(Collectors.toList());
    }

    public String getEmail() {
        return this.email;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Set<String> getRoles() {
        return new HashSet();
    }

    public List<ModuloVO> getModulos() {
        return this.modulos;
    }

    public List<ModuloVO> getModulosMenu() {
        List<ModuloVO> modulosMenu = new ArrayList(this.modulos);
        modulosMenu.removeIf((moduloVO) -> moduloVO.getNome().equals("Cadastros"));
        return this.modulos;
    }

}
