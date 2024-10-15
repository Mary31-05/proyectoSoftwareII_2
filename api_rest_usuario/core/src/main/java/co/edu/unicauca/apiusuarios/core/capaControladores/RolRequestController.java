package co.edu.unicauca.apiusuarios.core.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.RolDTO;
import co.edu.unicauca.apiusuarios.core.fachadaServices.services.IRolServicie;

@RestController
@RequestMapping("/api")
public class RolRequestController {
    
    @Autowired
    private IRolServicie rolServicie;

    @GetMapping("/roles")
    public List<RolDTO> listarRoles(){
        return rolServicie.findAll();
    }

    @PostMapping("/roles")
    public RolDTO crearRol(@RequestBody RolDTO rol){
        RolDTO objRol = null;
        objRol = rolServicie.save(objRol);
        return objRol;
    }

    @GetMapping("/roles/{id}")
    public RolDTO consultarRol(@PathVariable Integer id){
        RolDTO objDTO
    }
}
