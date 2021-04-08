package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import br.com.zupacademy.marcio.casadocodigo.model.Estado;

import java.util.List;
import java.util.stream.Collectors;

public class EstadoResponse {

    private String nome;
    private Long paisId;

    public EstadoResponse(Estado estado) {
        this.nome = estado.getNome();
        this.paisId = estado.getPais().getId();
    }

    public static List<EstadoResponse> converter(List<Estado> estados) {
        return estados.stream().map(EstadoResponse::new).collect(Collectors.toList());
    }


    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }


}
