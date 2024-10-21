package co.edu.unicauca.apiarticulos.core.capaAccesoADatos.repositories;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models.ArticuloEntity;
import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.ConferenciaDTO;

@Repository
public class ArticuloRepository {

    private ArrayList<ArticuloEntity> listaDeArticulos;

    public ArticuloRepository() {
        this.listaDeArticulos = new ArrayList<ArticuloEntity>();
        CargarArticulos();
    }

    public List<ArticuloEntity> findAll() {
        System.out.println("Invocando a listarArticulos");
        return this.listaDeArticulos;
    }

    public ArticuloEntity findById(Integer id) {
        System.out.println("Invocando a consultar un Articulo");
        ArticuloEntity objArticulo = null;

        for (ArticuloEntity articulo : listaDeArticulos) {
            if (articulo.getId() == id) {
                objArticulo = articulo;
                break;
            }
        }

        return objArticulo;
    }

    public boolean existeArticulo(Integer id) {
        for (ArticuloEntity articulo : listaDeArticulos) {
            if (articulo.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public ArticuloEntity exist(Integer id) {
        System.out.println("Invocando a consultar un Articulo");

        ArticuloEntity objArticulo = null;

        if (existeArticulo(id)) {
            for (ArticuloEntity articulo : listaDeArticulos) {
                if (articulo.getId().equals(id)) {
                    objArticulo = articulo;
                    break;
                }
            }
        } else {
            System.out.println("El artículo con ID " + id + " no fue encontrado.");
        }

        return objArticulo;
    }

    public ArticuloEntity save(ArticuloEntity articulo) {
        System.out.println("Invocando a almacenar un articulo");
        ArticuloEntity objArticulo = null;
        if (this.listaDeArticulos.add(articulo)) {
            objArticulo = articulo;
        }

        return objArticulo;
    }

    public ArticuloEntity update(Integer id, ArticuloEntity articulo) {
        System.out.println("Invocando a actualizar un articulo");
        ArticuloEntity objArticulo = null;

        for (int i = 0; i < this.listaDeArticulos.size(); i++) {
            if (this.listaDeArticulos.get(i).getId() == id) {
                this.listaDeArticulos.set(i, articulo);
                objArticulo = articulo;
                break;
            }
        }

        return objArticulo;
    }

    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar un articulo");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeArticulos.size(); i++) {
            if (this.listaDeArticulos.get(i).getId() == id) {
                this.listaDeArticulos.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    private void CargarArticulos() {
        ArticuloEntity objArticulo1 = new ArticuloEntity(1, "IA en la actualidad", "Resumen del artículo sobre IA", "IA, Tecnología, Futuro", "Publicado", new ArrayList<>(), new ConferenciaDTO(1));
        this.listaDeArticulos.add(objArticulo1);

        ArticuloEntity objArticulo2 = new ArticuloEntity(2, "Ingeniería de software", "Resumen del artículo sobre ingeniería de software", "Software, Ingeniería, Desarrollo", "Publicado", new ArrayList<>(), new ConferenciaDTO(2));
        this.listaDeArticulos.add(objArticulo2);

        ArticuloEntity objArticulo3 = new ArticuloEntity(3, "Tecnología", "Resumen del artículo sobre tecnología", "Tecnología, Innovación", "Publicado", new ArrayList<>(), new ConferenciaDTO(3));
        this.listaDeArticulos.add(objArticulo3);
    }

}
