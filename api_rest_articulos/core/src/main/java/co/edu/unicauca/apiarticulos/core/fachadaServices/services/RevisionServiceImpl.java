package co.edu.unicauca.apiarticulos.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models.RevisionEntity;
import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.repositories.RevisionRepository;
import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.RevisionDTO;

@Service
public class RevisionServiceImpl implements IRevisionService{
    
    @Autowired
    private RevisionRepository servicioAccesoBaseDatos;

    @Autowired
    private UsuarioService servicioAccesoBaseDatosUsuario;

    @Autowired
    private ModelMapper modelMapper;

    @Override
	public List<RevisionDTO> findAll() {
		List<RevisionEntity> RevisionEntity = this.servicioAccesoBaseDatos.findAll();
		List<RevisionDTO> RevisionDTO = this.modelMapper.map(RevisionEntity, new TypeToken<List<RevisionDTO>>() {
		}.getType());
		return RevisionDTO;
	}

    @Override
    public RevisionDTO findById(Integer idRevision) {
        RevisionEntity objRevisionEntity = this.servicioAccesoBaseDatos.findById(idRevision);
        RevisionDTO revisionDTO = this.modelMapper.map(objRevisionEntity, RevisionDTO.class);
        return revisionDTO;
    }

    @Override
    public RevisionDTO save(RevisionDTO revision, Integer idUsuario) {
        // Validar rol del usuario
        if (!servicioAccesoBaseDatosUsuario.validarRol(idUsuario, "ORGANIZADOR"))
            throw new RuntimeException("El usuario no tiene permisos para crear una revision");

        for (Integer idEvaluador : revision.getEvaluadores()) {
            if (!servicioAccesoBaseDatosUsuario.validarRol(idUsuario, "EVALUADOR"))
                throw new RuntimeException("El evaluador con ID " + idEvaluador + " no puede es un EVALUADOR"); 
        }

        RevisionEntity RevisionEntity = this.modelMapper.map(revision, RevisionEntity.class);
		RevisionEntity objRevisionEntity = this.servicioAccesoBaseDatos.save(RevisionEntity);
		RevisionDTO RevisionDTO = this.modelMapper.map(objRevisionEntity, RevisionDTO.class);
		return RevisionDTO;
    }

    @Override
    public RevisionDTO update(Integer id, RevisionDTO revision) {
        RevisionEntity RevisionEntity = this.modelMapper.map(revision, RevisionEntity.class);
        RevisionEntity revisionEntityActualizado = this.servicioAccesoBaseDatos.update(id, RevisionEntity);
        RevisionDTO RevisionDTO = this.modelMapper.map(revisionEntityActualizado, RevisionDTO.class);
        return RevisionDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }

    @Override
    public RevisionDTO agregarComentario(Integer idRevision, Integer idEvaluador, String comentario) {
        // Validar rol del usuario
        if (!servicioAccesoBaseDatosUsuario.validarRol(idEvaluador, "EVALUADOR"))
            throw new RuntimeException("El usuario no tiene permisos para evaluar el articulo");

        RevisionEntity revisionConComentario = this.servicioAccesoBaseDatos.agregarComentario(idRevision, comentario);
        RevisionDTO RevisionDTO = this.modelMapper.map(revisionConComentario, RevisionDTO.class);
        return RevisionDTO;
    }

    @Override
    public RevisionDTO actualizarEstado(Integer idRevision, String estado) {
        RevisionEntity revisionActulizada = this.servicioAccesoBaseDatos.actualizarEstado(idRevision, estado);
        RevisionDTO revisionDTO = this.modelMapper.map(revisionActulizada, RevisionDTO.class);
        return revisionDTO;
    }
}
