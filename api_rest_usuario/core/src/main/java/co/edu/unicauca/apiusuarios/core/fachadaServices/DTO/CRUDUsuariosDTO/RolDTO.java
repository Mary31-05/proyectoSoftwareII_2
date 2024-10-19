package co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class RolDTO {
    private Integer id;
    private String nombre;

    public RolDTO() {
        
    } 
}
