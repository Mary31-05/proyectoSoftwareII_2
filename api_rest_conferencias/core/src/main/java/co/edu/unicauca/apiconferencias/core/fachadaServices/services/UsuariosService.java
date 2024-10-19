package co.edu.unicauca.apiconferencias.core.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import co.edu.unicauca.apiconferencias.core.fachadaServices.DTO.UsuarioDTO;

@Service
public class UsuariosService {
    
    @Autowired
    private WebClient.Builder webClientBuilder;

    public boolean validarRolOrganizador(Integer idUsuario) {
        String url = "http://localhost:8080/api/usuarios/" + idUsuario;

        UsuarioDTO usuarioDTO = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(UsuarioDTO.class)
                .block();

        return usuarioDTO != null && usuarioDTO.getRol().getNombre().equals("ORGANIZADOR");
    }
}
