package co.edu.unicauca.apiusuarios.core.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.RolEntity;
import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.UsuarioEntity;
import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuarioDTO;

@Repository
public class UsuarioRepository {

    private ArrayList<UsuarioEntity> listaDeUsuarios;

    public UsuarioRepository(){
        this.listaDeUsuarios = new ArrayList<UsuarioEntity>();
        cargarUsuarios();
    }

    public List<UsuarioEntity> findAll(){
        System.out.println("Invocando a listarusuarios");
        return this.listaDeUsuarios;
    }

    public UsuarioEntity save(UsuarioEntity usuario){
        System.out.println("Invocando a almacenar usuario");
        UsuarioEntity objUsuario = null;
        if (this.listaDeUsuarios.add(usuario))
            objUsuario = usuario;
        return objUsuario;
    }

    public UsuarioEntity findById(Integer id){
        System.out.println("Invocando a consultar un usuario");
        UsuarioEntity objUsuario = null;

        for (UsuarioEntity usuario : listaDeUsuarios){
            if (usuario.getId() == id){
                objUsuario = usuario;
                break;
            }
        }
        return objUsuario;
    }

    public UsuarioEntity update(Integer id, UsuarioEntity usuario){
        System.out.println("Invocando a actualizar un usuario");
        UsuarioEntity objUsuario = null;

        for (int i = 0; i < this.listaDeUsuarios.size(); i++){
            if (this.listaDeUsuarios.get(i).getId() == id){
                this.listaDeUsuarios.set(i, usuario);
                objUsuario = usuario;
                break;
            }
        }
        return objUsuario;
    }

    public boolean delete(Integer id){
        System.out.println("Invocando a eliminar un usuario");
        boolean bandera = false;

        for (int i = 0; i < listaDeUsuarios.size(); i++){
            if (this.listaDeUsuarios.get(i).getId() == id){
                this.listaDeUsuarios.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    private void cargarUsuarios() {
        UsuarioEntity usuario1 = new UsuarioEntity(1, "Juan", "Pérez", "juan.perez@example.com", "contraseña1", new RolEntity(1, "ORGANIZADOR"));
        this.listaDeUsuarios.add(usuario1);

        UsuarioEntity usuario2 = new UsuarioEntity(2, "Ana", "Gómez", "ana.gomez@example.com", "contraseña2", new RolEntity(2, "EVALUADOR"));
        this.listaDeUsuarios.add(usuario2);

        UsuarioEntity usuario3 = new UsuarioEntity(3, "Luis", "Martínez", "luis.martinez@example.com", "contraseña3", new RolEntity(3, "AUTOR"));
        this.listaDeUsuarios.add(usuario3);

        UsuarioEntity usuario4 = new UsuarioEntity(4, "María", "Hernández", "maria.hernandez@example.com", "contraseña4", new RolEntity(4, "PARTICIPANTE"));
        this.listaDeUsuarios.add(usuario4);       
    }
}