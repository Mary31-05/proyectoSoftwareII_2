package co.edu.unicauca.apiusuarios.core.fachadaServices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import co.edu.unicauca.apiusuarios.core.fachadaServices.DTO.UsuariosConConferenciasDTO.ConferenciaDTO;
import reactor.core.publisher.Mono;
import java.util.List;

@Service
public class ConferenciasService {
    
    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<ConferenciaDTO> obtenerConferenciasDeUsuario(Integer idUsuario) {
        String url = "http://localhost:1000/api/conferencias/usuario/" + idUsuario;

        Mono<ConferenciaDTO[]> response = webClientBuilder.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(ConferenciaDTO[].class);

        ConferenciaDTO[] conferenciasArray = response.block();
        return conferenciasArray != null ? List.of(conferenciasArray) : List.of();
    }
}
