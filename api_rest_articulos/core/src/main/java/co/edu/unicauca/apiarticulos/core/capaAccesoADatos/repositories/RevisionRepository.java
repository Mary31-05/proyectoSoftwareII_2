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

    public RevisionEntity findById(Integer idRevision) {
        RevisionEntity objRevision = null;

        for (RevisionEntity revision : listaDeRevisiones) {
            if (revision.getId().equals(idRevision)) {
                objRevision = revision;
                break;
            }
        }
        return objRevision;
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

    public RevisionEntity agregarComentario(Integer idRevision, String comentario) {
        RevisionEntity objRevision = null;

        for (int i = 0; i < this.listaDeRevisiones.size(); i++) {
            if (this.listaDeRevisiones.get(i).getId().equals(idRevision)) {
                RevisionEntity revisionObtenida = this.listaDeRevisiones.get(i);
                revisionObtenida.getComentarios().add(comentario);
                this.listaDeRevisiones.set(i, revisionObtenida);
                objRevision = revisionObtenida;
                break;
            }
        }
        return objRevision;
    } 

    public RevisionEntity actualizarEstado(Integer idRevision, String estado){
        RevisionEntity objRevision = null;

        for (int i = 0; i < this.listaDeRevisiones.size(); i++) {
            if (this.listaDeRevisiones.get(i).getId().equals(idRevision)) {
                RevisionEntity revisionObtenida = this.listaDeRevisiones.get(i);
                revisionObtenida.setEstado(estado);
                this.listaDeRevisiones.set(i, revisionObtenida);
                objRevision = revisionObtenida;
                break;
            }
        }
        return objRevision;
    }
}

