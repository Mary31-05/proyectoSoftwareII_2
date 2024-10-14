package co.edu.unicauca.apiconferencias.core.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.apiconferencias.core.capaAccesoADatos.models.ConferenciaEntity;
@Repository
public class ConferenciaRepository {
    private ArrayList<ConferenciaEntity> listaDeConferencias;

	public ConferenciaRepository() {
		this.listaDeConferencias = new ArrayList<ConferenciaEntity>();
		cargarConferencias();
	}
    public List<ConferenciaEntity> findAll() {
		System.out.println("Invocando a listarConferencias");
		return this.listaDeConferencias;

	}
	public ConferenciaEntity findById(Integer id) {
        System.out.println("Invocando a consultar una conferencia");
        ConferenciaEntity objConferencia = null;

        for (ConferenciaEntity conferencia : listaDeConferencias) {
            if (conferencia.getId() == id) {
                objConferencia = conferencia;
                break;
            }
        }

        return objConferencia;
    }

	public boolean existeConferencia(Integer id) {
        for (ConferenciaEntity conferencia : listaDeConferencias) {
            if (conferencia.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public ConferenciaEntity exist(Integer id) {
        System.out.println("Invocando a consultar una conferencia");

        ConferenciaEntity objConferencia = null;

        if (existeConferencia(id)) {
            for (ConferenciaEntity conferencia : listaDeConferencias) {
                if (conferencia.getId().equals(id)) {
                    objConferencia = conferencia;
                    break;
                }
            }
        } else {
            System.out.println("La conferencia con ID " + id + " no fue encontrada.");
        }

        return objConferencia;
    }
	public ConferenciaEntity save(ConferenciaEntity conferencia) {
		System.out.println("Invocando a almacenar una conferencia");
		ConferenciaEntity objConferencia = null;
		if (this.listaDeConferencias.add(conferencia)) {
			objConferencia = conferencia;
		}

		return objConferencia;
	}

	public ConferenciaEntity update(Integer id, ConferenciaEntity conferencia) {
		System.out.println("Invocando a actualizar una conferencia");
		ConferenciaEntity objConferencias = null;

		for (int i = 0; i < this.listaDeConferencias.size(); i++) {
			if (this.listaDeConferencias.get(i).getId() == id) {
				this.listaDeConferencias.set(i, conferencia);
				objConferencias = conferencia;
				break;
			}
		}

		return objConferencias;
	}

	public boolean delete(Integer id) {
		System.out.println("Invocando a eliminar una conferencia");
		boolean bandera = false;

		for (int i = 0; i < this.listaDeConferencias.size(); i++) {
			if (this.listaDeConferencias.get(i).getId() == id) {
				this.listaDeConferencias.remove(i);
				bandera = true;
				break;
			}
		}

		return bandera;
	}

	private void cargarConferencias() {
		ConferenciaEntity objConferencias1 = new ConferenciaEntity(1, "IA", 1 );
		this.listaDeConferencias.add(objConferencias1);
		ConferenciaEntity objConferencias2 = new ConferenciaEntity(2, "Ingeniería", 3);
		this.listaDeConferencias.add(objConferencias2);
		ConferenciaEntity objConferencias3 = new ConferenciaEntity(3, "Software",5);
		this.listaDeConferencias.add(objConferencias3);
		ConferenciaEntity objConferencias = new ConferenciaEntity(4, "Actualidad", 4);
		this.listaDeConferencias.add(objConferencias);
	}
}
