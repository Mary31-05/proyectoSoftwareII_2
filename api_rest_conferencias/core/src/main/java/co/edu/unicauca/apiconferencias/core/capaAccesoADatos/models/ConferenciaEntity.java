package co.edu.unicauca.apiconferencias.core.capaAccesoADatos.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenciaEntity {
    private Integer id;
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String ubicacion;

    public ConferenciaEntity(){
    
    }
}