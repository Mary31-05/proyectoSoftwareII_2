package co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioEntity {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String password;
    private RolEntity rol;
}
