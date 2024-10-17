package co.edu.unicauca.apiconferencias.core.fachadaServices.services;
import java.util.List;

import co.edu.unicauca.apiconferencias.core.fachadaServices.DTO.ConferenciaDTO;

public interface IConferenciaService {
    public List<ConferenciaDTO> findAll();
    public ConferenciaDTO findById(Integer id);
	public ConferenciaDTO save(ConferenciaDTO conferencia);
	public ConferenciaDTO update(Integer id, ConferenciaDTO conferencia);
	public boolean delete(Integer id);
}
