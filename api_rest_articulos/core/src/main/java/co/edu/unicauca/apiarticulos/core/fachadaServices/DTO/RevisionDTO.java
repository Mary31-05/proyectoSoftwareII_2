package co.edu.unicauca.apiarticulos.core.fachadaServices.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class RevisionDTO {
    private Integer id;
    private ArticuloDTO Articulo;
    private List<Integer> evaluadores;
    private List<String> comentarios;
    private String estado;

    public RevisionDTO(){

    } 
}
