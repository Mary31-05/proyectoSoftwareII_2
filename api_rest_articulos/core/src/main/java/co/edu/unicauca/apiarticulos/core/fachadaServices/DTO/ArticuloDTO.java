package co.edu.unicauca.apiarticulos.core.fachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class ArticuloDTO {
    private Integer id;
    private String titulo;
    private String resumen;
    private String palabrasClave;
    private String estado;
    private List<Integer> autores;
    private ConferenciaDTO conferencia;

    public ArticuloDTO(){
    } 
}
