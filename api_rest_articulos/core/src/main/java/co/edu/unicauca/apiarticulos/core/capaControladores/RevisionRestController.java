package co.edu.unicauca.apiarticulos.core.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.RevisionDTO;
import co.edu.unicauca.apiarticulos.core.fachadaServices.services.IRevisionService;

@RestController
@RequestMapping ("/api")
public class RevisionRestController {
    @Autowired
    private IRevisionService revisionService;

    @GetMapping("/revisiones")
    public List<RevisionDTO> listarRevisiones() {
        return revisionService.findAll();
    }

    @GetMapping("/revisiones/{id}")
    public RevisionDTO consultarRevision(@PathVariable Integer id) {
		RevisionDTO objRevision = null;
		objRevision = revisionService.findById(id);
		return objRevision;
	}
    
    @PostMapping("/revisiones")
    public RevisionDTO crearRevision(@RequestBody RevisionDTO revision, @RequestParam Integer idUsuario) {
        RevisionDTO objRevision = null;
        objRevision = revisionService.save(revision, idUsuario);
        return objRevision;
    }

    @PutMapping("/revisiones/{id}")
    public RevisionDTO actualizarRevision(@RequestBody RevisionDTO revision, @PathVariable Integer id) {
        return revisionService.update(id, revision);
    }

    @DeleteMapping("/revisiones/{id}")
    public boolean eliminarRevision(@PathVariable Integer id) {
        return revisionService.delete(id);
    }

    @PutMapping("revisiones/{id}/comentario")
    public ResponseEntity<RevisionDTO> agregarComentario(@PathVariable Integer id, @RequestBody String comentario, @RequestParam Integer idUsuario) {
        RevisionDTO revisionConComentario = revisionService.agregarComentario(id, id, comentario);
        if (revisionConComentario != null)
            return ResponseEntity.ok(revisionConComentario);
        else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @PutMapping("revisiones/{id}/estado")
    public ResponseEntity<RevisionDTO> actualizarEstado(@PathVariable Integer id, @RequestBody String estado) {
        RevisionDTO revisionActualizada = revisionService.actualizarEstado(id, estado);
        if (revisionActualizada != null)
            return ResponseEntity.ok(revisionActualizada);
        else 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}