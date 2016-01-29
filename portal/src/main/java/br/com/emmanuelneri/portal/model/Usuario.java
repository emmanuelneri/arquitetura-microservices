package br.com.emmanuelneri.portal.model;

import br.com.emmanuelneri.integrador.vo.ModuloVO;
import br.com.emmanuelneri.integrador.vo.UsuarioVO;
import br.com.emmanuelneri.portal.util.Model;
import org.apache.shiro.crypto.hash.Sha256Hash;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "usuario_uk", columnNames ={"email"})
})
@NamedQueries(value = {
        @NamedQuery(name = "Usuario.findByEmail", query = "select u from Usuario u where u.email = :email"),
        @NamedQuery(name = "Usuario.findCompletoByEmail", query = "select u from Usuario u left join fetch u.modulos m where u.email = :email"),
})
public class Usuario implements Model<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private long version;

    @NotNull
    @Column(length = 100)
    private String email;

    @NotNull
    private String senha;

    @NotNull
    private String nome;

    @ManyToMany
    @JoinTable(name="usuario_modulo",
            joinColumns= @JoinColumn(name="id_usuario", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="id_modulo", referencedColumnName="id"))
    private List<Modulo> modulos = Collections.singletonList(Modulo.PORTAL);

    public UsuarioVO toVo() {
       final List<ModuloVO> moduloVos = getModulos().stream().map(Modulo::toVo).collect(Collectors.toList());
        return new UsuarioVO(getId(), getEmail(), getNome(), moduloVos);
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = new Sha256Hash(senha).toHex();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public List<Modulo> getModulosMenu() {
        final List<Modulo> modulosMenu = new ArrayList<>(modulos);
        modulosMenu.remove(Modulo.PORTAL);
        return modulosMenu;
    }

    public long getVersion() {
        return version;
    }
}
