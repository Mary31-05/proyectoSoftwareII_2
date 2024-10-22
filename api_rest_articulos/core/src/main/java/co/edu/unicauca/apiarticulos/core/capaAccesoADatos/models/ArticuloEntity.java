package co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models;
import java.util.List;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ConferenciaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ArticuloEntity {
    private Integer id;
    private String titulo;
    private String resumen;
    private String palabrasClave;
    private List<Integer> autores;
    private ConferenciaDTO conferencia;

    public ArticuloEntity() {

    }
}
