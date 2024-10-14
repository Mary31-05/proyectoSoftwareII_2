package co.edu.unicauca.apiconferencias.core.capaAccesoADatos.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConferenciaEntity {
    private Integer id;
    private String nombre;
    private Integer cantArticulos;

    public ConferenciaEntity(){
    
    }
}