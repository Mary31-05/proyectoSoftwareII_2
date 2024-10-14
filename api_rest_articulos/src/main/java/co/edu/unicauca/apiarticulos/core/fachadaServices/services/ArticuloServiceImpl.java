package co.edu.unicauca.apiarticulos.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models.ArticuloEntity;
import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.repositories.ArticuloRepository;
import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ArticuloDTO;

@Service
public class ArticuloServiceImpl implements IArticuloService {

    private ArticuloRepository servicioAccesoBaseDatos;

	private ModelMapper modelMapper;

	public ArticuloServiceImpl(ArticuloRepository servicioAccesoBaseDatos, ModelMapper modelMapper) {
		this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
		this.modelMapper = modelMapper;
	}

    @Override
	public List<ArticuloDTO> findAll() {

		List<ArticuloEntity> ArticuloEntity = this.servicioAccesoBaseDatos.findAll();
		List<ArticuloDTO> articuloDTO = this.modelMapper.map(ArticuloEntity, new TypeToken<List<ArticuloDTO>>() {
		}.getType());
		return articuloDTO;
	}

    @Override
    public ArticuloDTO findById(Integer id) {
        ArticuloEntity objArticuloEntity = this.servicioAccesoBaseDatos.findById(id);
		ArticuloDTO ArticuloDTO = this.modelMapper.map(objArticuloEntity, ArticuloDTO.class);
		return ArticuloDTO;
    }
    @Override
    public ArticuloDTO exist(Integer id) {
        System.out.println("Invocando a consultar un Articulo");
        ArticuloEntity objArticuloEntity = this.servicioAccesoBaseDatos.findById(id);
        if (objArticuloEntity != null) {
            ArticuloDTO articuloDTO = this.modelMapper.map(objArticuloEntity, ArticuloDTO.class);
            return articuloDTO;
        } else {
            System.out.println("El artículo con ID " + id + " no fue encontrado.");
            return null;
        }
    }

    @Override
    public ArticuloDTO save(ArticuloDTO articulo) {
        ArticuloEntity articuloEntity = this.modelMapper.map(articulo, ArticuloEntity.class);
		ArticuloEntity objArticuloEntity = this.servicioAccesoBaseDatos.save(articuloEntity);
		ArticuloDTO articuloDTO = this.modelMapper.map(objArticuloEntity, ArticuloDTO.class);
		return articuloDTO;
    }

    @Override
    public ArticuloDTO update(Integer id, ArticuloDTO articulo) {
        ArticuloEntity articuloEntity = this.modelMapper.map(articulo, ArticuloEntity.class);
        ArticuloEntity articuloEntityActualizado = this.servicioAccesoBaseDatos.update(id, articuloEntity);
        ArticuloDTO articuloDTO = this.modelMapper.map(articuloEntityActualizado, ArticuloDTO.class);
        return articuloDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
}
