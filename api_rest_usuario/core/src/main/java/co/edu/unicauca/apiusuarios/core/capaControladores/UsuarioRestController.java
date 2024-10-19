package co.edu.unicauca.apiusuarios.core.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.CRUDUsuariosDTO.UsuarioDTO;
import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuariosConConferenciasDTO.ConferenciaDTO;
import co.edu.unicauca.apiusuarios.core.fachadaServices.services.IUSuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private IUSuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuarios/conferencias/{idUsuario}")
    public List<ConferenciaDTO> listarUsuarioConSusConferencias(@PathVariable Integer idUsuario) {
        return usuarioService.ListarConferenciasDeUsuario(idUsuario);
    }

    @GetMapping("/usuarios/{id}")
    public UsuarioDTO consultarUsuario(@PathVariable Integer id) {
        UsuarioDTO objUsuario = null;
        objUsuario = usuarioService.findById(id);
        return objUsuario;
    }
        
    @PostMapping("/usuarios")
    public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO objUsuario = null;
        try {
            objUsuario = usuarioService.save(usuario);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return objUsuario;
    }
    
    @PutMapping("/usuarios/{id}")
    public UsuarioDTO actualizarUsuario(@RequestBody UsuarioDTO usuario, @PathVariable Integer id){
        UsuarioDTO objUsuario = null;
        UsuarioDTO usuarioActual = usuarioService.findById(id);
        if (usuarioActual != null)
            objUsuario = usuarioService.update(id, usuario);
        return objUsuario;
    }

    @DeleteMapping("/usuarios/{id}")
    public Boolean eliminarUsuario(@PathVariable Integer id) {
        Boolean bandera = false;
        UsuarioDTO usuarioActual = usuarioService.findById(id);
        if (usuarioActual != null)
            bandera = usuarioService.delete(id);
        return bandera;
    }
}
