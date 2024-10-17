package co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class RolEntity {
    private Integer id;
    private String nombre;

    public RolEntity(){
        
    }
}
