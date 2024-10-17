package co.edu.unicauca.apiusuarios.core.fachadaServices.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.RolEntity;
import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.UsuarioEntity;
import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.repositories.RolRepository;
import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.repositories.UsuarioRepository;
import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuarioDTO;

@Service
public class UsuarioServiceImpl implements IUSuarioService {
   
    @Autowired
    private UsuarioRepository servicioAccesoBaseDatos;

    @Autowired
    private RolRepository servicioAccesoDatosRol;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UsuarioDTO> findAll() {
        List<UsuarioEntity> usuariosEntity = this.servicioAccesoBaseDatos.findAll();
        List<UsuarioDTO> usuariosDTO = this.modelMapper.map(usuariosEntity, new TypeToken<List<UsuarioDTO>>() {}.getType());
        return usuariosDTO;
    }

    @Override
    public UsuarioDTO findById(Integer id) {
        UsuarioEntity objUsuarioEntity = this.servicioAccesoBaseDatos.findById(id);
        UsuarioDTO usuarioDTO = this.modelMapper.map(objUsuarioEntity, UsuarioDTO.class);
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuario) throws IllegalAccessException {
        // Validar si el rol existe}
        Integer rolId = usuario.getRol() != null ? usuario.getRol().getId() : null;
        if (rolId == null)
            throw new IllegalAccessException("El rol no puede ser nulo");
        
        RolEntity rolEntity = this.servicioAccesoDatosRol.findById(rolId);
        if (rolEntity == null)
            throw new IllegalAccessException("El rol con ID " + rolId + " no existe");
        
        UsuarioEntity usuarioEntity = this.modelMapper.map(usuario, UsuarioEntity.class);
        usuarioEntity.setRol(rolEntity);
        UsuarioEntity objUsuarioEntity = this.servicioAccesoBaseDatos.save(usuarioEntity);
        UsuarioDTO usuarioDTO = this.modelMapper.map(objUsuarioEntity, UsuarioDTO.class);
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO update(Integer id, UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = this.modelMapper.map(usuario, UsuarioEntity.class);
        UsuarioEntity objUsuarioEntity = this.servicioAccesoBaseDatos.update(id, usuarioEntity);
        UsuarioDTO usuarioDTO = this.modelMapper.map(objUsuarioEntity, UsuarioDTO.class);
        return usuarioDTO;
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
}
