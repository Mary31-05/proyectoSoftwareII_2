package co.edu.unicauca.apiarticulos.core.fachadaServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import co.edu.unicauca.apiarticulos.core.fachadaServices.DTO.UsuarioDTO;

@Service
public class ConferenciaService {
    @Autowired
    private WebClient.Builder webClientBuilder;

    public boolean validarRol(Integer idUsuario, String rol) {
        String url = "http://localhost:8080/api/usuarios/" + idUsuario;

        UsuarioDTO usuarioDTO = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(UsuarioDTO.class)
                .block();

        return usuarioDTO != null && usuarioDTO.getRol().getNombre().equals(rol);
    }
}
