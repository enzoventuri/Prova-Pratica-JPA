package br.com.ctw.api_monitoramento_transformadores.repository;

import br.com.ctw.api_monitoramento_transformadores.entity.AlertaTermico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository do Alerta Termico possui somente os métodos bases do JpaRepository
 */
@Repository
public interface AlertaTermicoRepository extends JpaRepository<AlertaTermico, Long> {
}
