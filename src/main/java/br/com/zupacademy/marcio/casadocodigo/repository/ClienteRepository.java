package br.com.zupacademy.marcio.casadocodigo.repository;

import br.com.zupacademy.marcio.casadocodigo.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
