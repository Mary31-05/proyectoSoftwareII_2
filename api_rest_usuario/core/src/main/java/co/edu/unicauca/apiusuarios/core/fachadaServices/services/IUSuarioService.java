package co.edu.unicauca.apiusuarios.core.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuarioDTO;

public interface IUSuarioService {
    public List<UsuarioDTO> findAll();
    public UsuarioDTO findById(Integer id);
    public UsuarioDTO save(UsuarioDTO usuario) throws IllegalAccessException;
    public UsuarioDTO update(Integer id, UsuarioDTO usuario);
    public boolean delete(Integer id);
}