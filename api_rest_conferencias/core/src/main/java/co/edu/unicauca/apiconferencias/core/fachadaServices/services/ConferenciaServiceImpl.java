package co.edu.unicauca.apiconferencias.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.apiconferencias.core.capaAccesoADatos.models.ConferenciaEntity;
import co.edu.unicauca.apiconferencias.core.capaAccesoADatos.repositories.ConferenciaRepository;
import co.edu.unicauca.apiconferencias.core.fachadaServices.DTO.ConferenciaDTO;

@Service
public class ConferenciaServiceImpl implements IConferenciaService{

    @Autowired
    private ConferenciaRepository servicioAccesoBaseDatos;

    @Autowired
	private ModelMapper modelMapper;

    @Override
	public List<ConferenciaDTO> findAll() {
		List<ConferenciaEntity> ConferenciaEntity = this.servicioAccesoBaseDatos.findAll();
		List<ConferenciaDTO> conferenciaDTO = this.modelMapper.map(ConferenciaEntity, new TypeToken<List<ConferenciaDTO>>() {
		}.getType());
		return conferenciaDTO;
	}

    @Override
    public ConferenciaDTO findById(Integer id) {
        ConferenciaEntity objConferenciaEntity = this.servicioAccesoBaseDatos.findById(id);
		ConferenciaDTO ConferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);
		return ConferenciaDTO;
    }

    @Override
    public ConferenciaDTO save(ConferenciaDTO conferencia) {
        ConferenciaEntity conferenciaEntity = this.modelMapper.map(conferencia, ConferenciaEntity.class);
		ConferenciaEntity objConferenciaEntity = this.servicioAccesoBaseDatos.save(conferenciaEntity);
		ConferenciaDTO conferenciaDTO = this.modelMapper.map(objConferenciaEntity, ConferenciaDTO.class);
		return conferenciaDTO;
    }

    @Override
    public ConferenciaDTO update(Integer id, ConferenciaDTO conferencia) {
        ConferenciaEntity ConferenciaEntity = this.modelMapper.map(conferencia, ConferenciaEntity.class);
        ConferenciaEntity ConferenciaEntityActualizado = this.servicioAccesoBaseDatos.update(id, ConferenciaEntity);
        ConferenciaDTO ConferenciaDTO = this.modelMapper.map(ConferenciaEntityActualizado, ConferenciaDTO.class);
        return ConferenciaDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }

}
