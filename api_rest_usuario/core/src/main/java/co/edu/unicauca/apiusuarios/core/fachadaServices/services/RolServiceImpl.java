package co.edu.unicauca.apiusuarios.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.RolEntity;
import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.repositories.RolRepository;
import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.RolDTO;

@Service
public class RolServiceImpl implements IRolServicie {
    
    @Autowired
    private RolRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RolDTO> findAll() {
        List<RolEntity> rolesEntity = this.servicioAccesoBaseDatos.findAll();
        List<RolDTO> rolesDTO = this.modelMapper.map(rolesEntity, new TypeToken<List<RolDTO>>() {}.getType());
        return rolesDTO;
    }

    @Override
    public RolDTO save(RolDTO rol){
        RolEntity rolEntity = this.modelMapper.map(rol, RolEntity.class);
        RolEntity objRolEntity = this.servicioAccesoBaseDatos.save(rolEntity);
        RolDTO rolDTO = this.modelMapper.map(objRolEntity, RolDTO.class);
        return rolDTO;
    }

    @Override
    public RolDTO findById(Integer id) {
        RolEntity objEntity = this.servicioAccesoBaseDatos.findEntity(id);
        RolDTO rolDTO = this.modelMapper.map(objEntity, RolDTO.class);
        return rolDTO;
    }

    @Override
    public RolDTO update(Integer id, RolDTO rol) {
        RolEntity rolEntity = this.modelMapper.map(rol, RolEntity.class);
        RolEntity objRolEntity = this.servicioAccesoBaseDatos.update(id, rolEntity);
        RolDTO rolDTO = this.modelMapper.map(objRolEntity, RolDTO.class);
        return rolDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
}
