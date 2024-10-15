package co.edu.unicauca.apiusuarios.core.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.RolDTO;

public interface IRolServicie {
    public List<RolDTO> findAll();
    public RolDTO findById(Integer id);
    public RolDTO save(RolDTO rol);
    public RolDTO update(Integer id, RolDTO rol);
    public boolean delete(Integer id);
}
