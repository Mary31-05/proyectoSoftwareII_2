package co.edu.unicauca.apiarticulos.core.fachadaServices.services;
import java.util.List;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.RevisionDTO;

public interface IRevisionService {

	public List<RevisionDTO> findAll();
	public RevisionDTO findById(Integer idRevision);
	public RevisionDTO save(RevisionDTO revision, Integer idUsuario);
	public RevisionDTO update(Integer id, RevisionDTO Revision);
	public boolean delete(Integer id);
	public RevisionDTO agregarComentario(Integer idRevision, Integer idEvaluador, String comentario);
	public RevisionDTO actualizarEstado(Integer idRevision, String estado);
}
