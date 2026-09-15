package br.com.ctw.api_monitoramento_transformadores.repository;

import br.com.ctw.api_monitoramento_transformadores.entity.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository do Tecnico possui somente os métodos bases do JpaRepository
 */
@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
}
