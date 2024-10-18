package co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RevisionEntity {
    private Integer id;
    private Integer articuloId;
    private Integer usuarioId;
    private String estado;

    public RevisionEntity(){
    }
}
