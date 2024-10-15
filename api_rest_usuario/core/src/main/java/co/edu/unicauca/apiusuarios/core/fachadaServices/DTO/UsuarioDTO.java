package co.edu.unicauca.apiusuarios.core.fachadaServices.DTO;

import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.RolEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UsuarioDTO {
    private Integer Id;
    private String FullName;
    private String correo;
    private RolEntity rol;

    public UsuarioDTO() {

    }
}
