package co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioEntity {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;

    @NonNull
    private RolEntity rol;

    public UsuarioEntity() {

    }
}
