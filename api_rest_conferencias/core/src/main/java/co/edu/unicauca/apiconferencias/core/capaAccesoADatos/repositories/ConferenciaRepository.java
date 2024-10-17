package co.edu.unicauca.apiconferencias.core.capaAccesoADatos.repositories;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

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

	// Esto es igual a el de arriba jaja
	/* 
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
	*/

	public ConferenciaEntity save(ConferenciaEntity conferencia) {
		System.out.println("Invocando a almacenar una conferencia");
		ConferenciaEntity objConferencia = null;
		if (this.listaDeConferencias.add(conferencia))
			objConferencia = conferencia;
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
		ConferenciaEntity objConferencias1 = new ConferenciaEntity(1, "IA", LocalDate.of(2024, 10, 20), LocalDate.of(2024, 10, 22), "Auditorio A");
        listaDeConferencias.add(objConferencias1);

        ConferenciaEntity objConferencias2 = new ConferenciaEntity(2, "Desarrollo Sostenible", LocalDate.of(2024, 11, 5), LocalDate.of(2024, 11, 7), "Salón B");
        listaDeConferencias.add(objConferencias2);

        ConferenciaEntity objConferencias3 = new ConferenciaEntity(3, "Innovación Tecnológica", LocalDate.of(2024, 11, 15), LocalDate.of(2024, 11, 17), "Sala C");
        listaDeConferencias.add(objConferencias3);

        ConferenciaEntity objConferencias4 = new ConferenciaEntity(4, "Educación en la Era Digital", LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 3), "Sala D");
        listaDeConferencias.add(objConferencias4);
	}
}
