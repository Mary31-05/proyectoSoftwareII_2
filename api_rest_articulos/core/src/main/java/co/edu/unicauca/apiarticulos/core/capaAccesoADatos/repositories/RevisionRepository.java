package co.edu.unicauca.apiarticulos.core.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.apiarticulos.core.capaAccesoADatos.models.RevisionEntity;

@Repository
public class RevisionRepository {
    private List<RevisionEntity> listaDeRevisiones;

    public RevisionRepository() {
        this.listaDeRevisiones = new ArrayList<>();
    }

    public List<RevisionEntity> findAll() {
        return this.listaDeRevisiones;
    }
    public RevisionEntity save(RevisionEntity revision) {
        this.listaDeRevisiones.add(revision);
        return revision;
    }

    public RevisionEntity update(Integer id, RevisionEntity revisionActualizada) {
        for (int i = 0; i < this.listaDeRevisiones.size(); i++) {
            if (this.listaDeRevisiones.get(i).getId().equals(id)) {
                this.listaDeRevisiones.set(i, revisionActualizada);
                return revisionActualizada;
            }
        }
        return null;
    }

    public boolean delete(Integer id) {
        return this.listaDeRevisiones.removeIf(revision -> revision.getId().equals(id));
    }
}

