package co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuariosConConferenciasDTO;

import java.util.List;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UsuarioConConferenciasDTO {
    private UsuarioDTO objCUsuarioDTO;
    private List<ConferenciaDTO> conferencias;
}
