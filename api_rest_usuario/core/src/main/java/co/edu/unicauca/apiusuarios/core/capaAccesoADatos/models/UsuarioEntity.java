package co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioEntity {
    private Long id;
    private String username;
    private String password;
    private Set<RolEntity> roles = new HashSet<>();
}
