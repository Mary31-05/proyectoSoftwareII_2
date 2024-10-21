package co.edu.unicauca.apiconferencias.core.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UsuariosService {
    
    @Autowired
    private WebClient.Builder webClientBuilder;

    public boolean validarRolOrganizador(Integer idUsuario, String rol) {
        String url = "http://localhost:8080/api/usuarios/" + idUsuario + "/validarRol?rol="+rol;

        Boolean tieneRol = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block(); 
                
        return tieneRol != null && tieneRol;
    }
}
