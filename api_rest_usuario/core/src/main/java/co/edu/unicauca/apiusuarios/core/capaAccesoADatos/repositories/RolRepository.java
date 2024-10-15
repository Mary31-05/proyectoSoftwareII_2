package co.edu.unicauca.apiusuarios.core.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.apiusuarios.core.capaAccesoADatos.models.RolEntity;

@Repository
public class RolRepository {
    
    private ArrayList<RolEntity> listaRoles;
    
    public RolRepository(){
        this.listaRoles = new ArrayList<RolEntity>();
        cargarRoles();
    }

    public List<RolEntity> findAll(){
        System.out.println("Invocando a listarroles");
        return this.listaRoles;
    }

    public RolEntity save(RolEntity rol){
        System.out.println("Invocando a almacenar rol");
        RolEntity objRol = null;
        if (this.listaRoles.add(rol))
            objRol = rol;
        return objRol;
    }

    public RolEntity findEntity(Integer id){
        System.out.println("Invocando a consultar un rol");
        RolEntity objRol = null;

        for(RolEntity rol : listaRoles){
            if(rol.getId() == id){
                objRol = rol;
                break;
            }
        }
        return objRol;
    }

    public RolEntity update(Integer id, RolEntity rol){
        System.out.println("Invocando a actualizar un rol");
        RolEntity objRol = null;
        for (int i = 0; i < this.listaRoles.size(); i++){
            if (this.listaRoles.get(i).getId() == id){
                this.listaRoles.set(i, rol);
                objRol = rol;
                break;
            }
        }
        return objRol;
    }

    public boolean delete(Integer id){
        System.out.println("Invocando a eliminar un rol");
        boolean bandera = false;
        for (int i = 0; i < this.listaRoles.size(); i++){
            if (this.listaRoles.get(i).getId() == id){
                this.listaRoles.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    private void cargarRoles() {
        RolEntity objRol1 = new RolEntity(1, "ORGANIZADOR");
        this.listaRoles.add(objRol1);
        RolEntity objRol2 = new RolEntity(2, "EVALUADOR");
        this.listaRoles.add(objRol2);
        RolEntity objRol3 = new RolEntity(3, "AUTOR");
        this.listaRoles.add(objRol3);
        RolEntity objRol4 = new RolEntity(4, "PARTICIPANTE");
        this.listaRoles.add(objRol4);
    }
}
