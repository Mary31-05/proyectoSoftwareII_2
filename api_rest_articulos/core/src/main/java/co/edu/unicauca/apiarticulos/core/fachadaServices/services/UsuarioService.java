package co.edu.unicauca.apiarticulos.core.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UsuarioService {
    
    @Autowired
    private WebClient.Builder webClientBuilder;

    public boolean validarRol(Integer idUsuario, String rol) {
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
