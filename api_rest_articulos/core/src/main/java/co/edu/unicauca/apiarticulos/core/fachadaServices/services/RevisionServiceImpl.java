package co.edu.unicauca.apiarticulos.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models.RevisionEntity;
import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.repositories.RevisionRepository;
import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.RevisionDTO;

public class RevisionServiceImpl implements IRevisionService{
    private RevisionRepository servicioAccesoBaseDatos;
    private ModelMapper modelMapper;

    public RevisionServiceImpl(RevisionRepository servicioAccesoBaseDatos, ModelMapper modelMapper) {
		this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
		this.modelMapper = modelMapper;
	}

    @Override
	public List<RevisionDTO> findAll() {

		List<RevisionEntity> RevisionEntity = this.servicioAccesoBaseDatos.findAll();
		List<RevisionDTO> RevisionDTO = this.modelMapper.map(RevisionEntity, new TypeToken<List<RevisionDTO>>() {
		}.getType());
		return RevisionDTO;
	}

    @Override
    public RevisionDTO save(RevisionDTO revision) {
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

}
