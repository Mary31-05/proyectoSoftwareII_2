package co.edu.unicauca.apiconferencias.core.fachadaServices.services;
import java.util.List;

import co.edu.unicauca.apiconferencias.core.fachadaServices.DTO.ConferenciaDTO;

public interface IConferenciaService {
    public List<ConferenciaDTO> findAll();
    public ConferenciaDTO findById(Integer id);
	public ConferenciaDTO save(ConferenciaDTO conferencia, Integer idUsuario);
	public ConferenciaDTO update(Integer id, ConferenciaDTO conferencia);
	public ConferenciaDTO agregarArticulo(Integer idConferencia, Integer idArticulo);
	public boolean delete(Integer id);
}
