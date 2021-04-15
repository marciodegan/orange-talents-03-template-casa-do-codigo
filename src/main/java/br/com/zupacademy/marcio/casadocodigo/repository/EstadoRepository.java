package br.com.zupacademy.marcio.casadocodigo.repository;

import br.com.zupacademy.marcio.casadocodigo.model.Estado;
import br.com.zupacademy.marcio.casadocodigo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    boolean existsByNomeAndPais(String nome, Pais pais);
//    boolean existsByPaisId(Long id);
//    boolean existsByIdAndPaisId(Long estado, Long pais);
}
