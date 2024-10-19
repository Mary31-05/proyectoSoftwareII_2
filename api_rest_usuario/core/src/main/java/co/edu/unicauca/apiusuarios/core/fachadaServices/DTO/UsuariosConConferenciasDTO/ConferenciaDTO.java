package co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuariosConConferenciasDTO;

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