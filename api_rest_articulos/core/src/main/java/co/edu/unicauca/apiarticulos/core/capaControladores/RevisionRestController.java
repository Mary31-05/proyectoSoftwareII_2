package co.edu.unicauca.apiarticulos.core.capaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/revisiones")
    public RevisionDTO crearRevision(@RequestBody RevisionDTO revision) {
        return revisionService.save(revision);
    }

    @PutMapping("/revisiones/{id}")
    public RevisionDTO actualizarRevision(@RequestBody RevisionDTO revision, @PathVariable Integer id) {
        return revisionService.update(id, revision);
    }

    @DeleteMapping("/revisiones/{id}")
    public boolean eliminarRevision(@PathVariable Integer id) {
        return revisionService.delete(id);
    }
}

