package co.edu.unicauca.apiarticulos.core.fachadaServices.services;
import java.util.List;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.RevisionDTO;

public interface IRevisionService {
public List<RevisionDTO> findAll();

	public RevisionDTO save(RevisionDTO revision);

	public RevisionDTO update(Integer id, RevisionDTO Revision);

	public boolean delete(Integer id);
}
