package br.com.zupacademy.marcio.casadocodigo.controller.dto;

import br.com.zupacademy.marcio.casadocodigo.model.Cliente;


public class ClienteResponse {

    private Long id;
    private String email;
    private String nome;
    private String sobrenome;
    private String documento;
    private String endereco;
    private String complemento;
    private String cidade;
    private Long paisId;
    private Long estadoId;
    private String telefone;
    private String cep;

    public ClienteResponse(Cliente cliente) {
        this.id = cliente.getId();
        this.email = cliente.getEmail();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.documento = cliente.getDocumento();
        this.endereco = cliente.getEndereco();
        this.complemento = cliente.getComplemento();
        this.cidade = cliente.getCidade();
        this.paisId = cliente.getPais().getId();
//        this.estadoId = cliente.getEstado().getId();
        this.telefone = cliente.getTelefone();
        this.cep = cliente.getCep();
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
