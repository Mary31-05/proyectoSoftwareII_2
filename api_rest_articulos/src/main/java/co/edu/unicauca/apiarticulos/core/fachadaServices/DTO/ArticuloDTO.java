package co.edu.unicauca.apiarticulos.core.fachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class ArticuloDTO {
    private Integer id;
    private String nombre;
    private String nomAutores;
    private Integer cantAutores;
    private String revista;

    public ArticuloDTO(){
    } 
}
