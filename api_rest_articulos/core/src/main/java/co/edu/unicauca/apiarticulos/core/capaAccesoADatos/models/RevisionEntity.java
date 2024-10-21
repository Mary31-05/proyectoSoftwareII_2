package co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models;
import java.util.List;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ArticuloRevisionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class RevisionEntity {
    private Integer id;
    private ArticuloRevisionDTO articulo;
    private List<Integer> evaluadores;
    private List<String> comentarios;
    private String estado = "Pendiente";

    public RevisionEntity() {

    }
}
