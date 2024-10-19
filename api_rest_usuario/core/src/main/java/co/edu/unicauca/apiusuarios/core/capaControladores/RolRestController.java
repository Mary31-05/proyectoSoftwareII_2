package co.edu.unicauca.apiusuarios.core.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO.RolDTO;
import co.edu.unicauca.apiusuarios.core.fachadaServices.services.IRolServicie;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class RolRestController {
    
    @Autowired
    private IRolServicie rolService;

    @GetMapping("/roles")
    public List<RolDTO> listarRoles(){
        return rolService.findAll();
    }

    @PostMapping("/roles")
    public RolDTO crearRol(@RequestBody RolDTO rol){
        RolDTO objRol = null;
        objRol = rolService.save(rol);
        return objRol;
    }

    @GetMapping("/roles/{id}")
    public RolDTO consultarRol(@PathVariable Integer id){
        RolDTO objRol = null;
        objRol = rolService.findById(id);
        return objRol;
    }

    @PutMapping("/roles/{id}")
    public RolDTO actualizarRol(@RequestBody RolDTO rol, @PathVariable Integer id) {
        RolDTO objRol = null;
        RolDTO rolActual = rolService.findById(id);
        if (rolActual != null)
            objRol = rolService.update(id, rol);
        return objRol;
    }

    @DeleteMapping("/roles/{id}")
    public Boolean eliminarRol(@PathVariable Integer id){
        Boolean bandera = false;
        RolDTO rolActual = rolService.findById(id);
        if  (rolActual != null)
            bandera = rolService.delete(id);
        return bandera;
    }
}
