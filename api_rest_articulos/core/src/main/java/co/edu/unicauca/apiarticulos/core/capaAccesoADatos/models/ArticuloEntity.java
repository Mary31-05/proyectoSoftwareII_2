package co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticuloEntity {
    private Integer id;
    private String nombre;
    private String nomAutores;
    private Integer cantAutores;
    private String revista;

    public ArticuloEntity(){

    }
}
