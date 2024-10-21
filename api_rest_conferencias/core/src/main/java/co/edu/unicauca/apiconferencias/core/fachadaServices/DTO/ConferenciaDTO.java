package co.edu.unicauca.apiconferencias.core.fachadaServices.DTO;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor

public class ConferenciaDTO {
    private Integer id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String ubicacion;
    private List<Integer> articulos;

    public ConferenciaDTO(){
        
    }
}
