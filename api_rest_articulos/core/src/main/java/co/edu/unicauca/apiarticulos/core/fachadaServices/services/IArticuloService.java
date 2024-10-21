package co.edu.unicauca.apiarticulos.core.fachadaServices.services;

import java.util.List;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ArticuloDTO;

public interface IArticuloService {
	public List<ArticuloDTO> findAll();
	public ArticuloDTO findById(Integer id);
	public ArticuloDTO exist(Integer id);
	public ArticuloDTO save(ArticuloDTO articulo, Integer idUsuario);
	public ArticuloDTO update(Integer id, ArticuloDTO articulo);
	public boolean delete(Integer id);
}
