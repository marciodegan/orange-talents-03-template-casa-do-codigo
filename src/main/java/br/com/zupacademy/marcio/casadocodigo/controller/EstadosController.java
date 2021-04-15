package br.com.zupacademy.marcio.casadocodigo.controller;

import br.com.zupacademy.marcio.casadocodigo.controller.dto.EstadoRequest;
import br.com.zupacademy.marcio.casadocodigo.model.Estado;
import br.com.zupacademy.marcio.casadocodigo.model.Pais;
import br.com.zupacademy.marcio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.marcio.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadosController {

    private EstadoRepository estadoRepository;
    private PaisRepository paisRepository;

    public EstadosController(EstadoRepository estadoRepository, PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastrarEstado(@RequestBody @Valid EstadoRequest estadoRequest){

        Optional<Pais> pais = paisRepository.findById(estadoRequest.getPaisId());

        if(pais.isPresent()){
            if(!estadoRepository.existsByNomeAndPais(estadoRequest.getNome(), pais.get())){
                estadoRepository.save(estadoRequest.converter());
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }


    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.findAll();
    }
}

