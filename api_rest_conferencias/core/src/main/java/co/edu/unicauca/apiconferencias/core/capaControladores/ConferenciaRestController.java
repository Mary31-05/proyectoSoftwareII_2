package co.edu.unicauca.apiconferencias.core.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.apiconferencias.core.fachadaServices.DTO.ConferenciaDTO;
import co.edu.unicauca.apiconferencias.core.fachadaServices.services.IConferenciaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping ("/api")
public class ConferenciaRestController {

    @Autowired
	private IConferenciaService ConferenciaService;

    @GetMapping("/conferencias")
    public List<ConferenciaDTO> listarConferencias() {
		return ConferenciaService.findAll();
    }
    
    @GetMapping("/conferencias/{id}")
	public ConferenciaDTO consultarConferencia(@PathVariable Integer id) {
		ConferenciaDTO objConferencia = null;
		objConferencia = ConferenciaService.findById(id);
		return objConferencia;
	}

    @PostMapping("/conferencias")
	public ConferenciaDTO crearConferencia(@RequestBody ConferenciaDTO conferencia, @RequestParam Integer idUsuario) {
        ConferenciaDTO objConferencia = null;
		objConferencia = ConferenciaService.save(conferencia, idUsuario);
		return objConferencia;
	}

    @PutMapping("/conferencias/{id}")
    public ResponseEntity<ConferenciaDTO> actualizarConferencia(@PathVariable Integer id, @RequestBody ConferenciaDTO conferencia) {
        ConferenciaDTO actualizado = ConferenciaService.update(id, conferencia);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/conferencias/{idConferencia}/articulo")
    public ResponseEntity<ConferenciaDTO> agregarArticulo(@PathVariable Integer idConferencia, @RequestBody Integer idArticulo) {
        ConferenciaDTO actualizado = ConferenciaService.agregarArticulo(idConferencia, idArticulo);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    @DeleteMapping("/conferencias/{id}")
    public ResponseEntity<Boolean> eliminarConferencia(@PathVariable Integer id) {
        ConferenciaDTO ConferenciaActual = ConferenciaService.findById(id);
        if (ConferenciaActual != null) {
            Boolean eliminado = ConferenciaService.delete(id);
            return ResponseEntity.ok(eliminado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}


