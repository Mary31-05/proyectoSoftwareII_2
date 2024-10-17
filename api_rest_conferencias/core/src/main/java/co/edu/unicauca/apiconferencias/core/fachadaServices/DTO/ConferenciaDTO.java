package co.edu.unicauca.apiconferencias.core.fachadaServices.DTO;

import java.time.LocalDate;

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

    public ConferenciaDTO(){
        
    }
}
