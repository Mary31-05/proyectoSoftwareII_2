package co.edu.unicauca.apiarticulos.core.fachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private RolDTO rol;

    public UsuarioDTO() {

    }
}