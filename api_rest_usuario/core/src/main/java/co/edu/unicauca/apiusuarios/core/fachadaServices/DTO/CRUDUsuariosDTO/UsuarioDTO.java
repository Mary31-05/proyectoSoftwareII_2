package co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private RolDTO rol;

    public UsuarioDTO() {

    }
}