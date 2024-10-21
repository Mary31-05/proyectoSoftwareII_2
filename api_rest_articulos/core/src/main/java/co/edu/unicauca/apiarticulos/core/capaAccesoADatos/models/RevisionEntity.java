package co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models;
import java.util.List;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ArticuloDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class RevisionEntity {
    private Integer id;
    private ArticuloDTO articulo;
    private List<Integer> evaluadores;
    private List<String> comentarios;
    private String estado;

    public RevisionEntity() {

    }
}
