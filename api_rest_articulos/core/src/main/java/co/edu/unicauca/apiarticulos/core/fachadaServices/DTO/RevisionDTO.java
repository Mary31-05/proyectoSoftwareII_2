package co.edu.unicauca.apiarticulos.core.fachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RevisionDTO {
    private Integer id;
    private Integer articuloId;
    private Integer usuarioId;
    private String estado;
    public RevisionDTO(){
    } 
}
