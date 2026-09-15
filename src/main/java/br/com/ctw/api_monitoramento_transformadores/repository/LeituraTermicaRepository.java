package br.com.ctw.api_monitoramento_transformadores.repository;

import br.com.ctw.api_monitoramento_transformadores.entity.LeituraTermica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository do Leitura Termica possui somente os métodos bases do JpaRepository
 */
@Repository
public interface LeituraTermicaRepository extends JpaRepository<LeituraTermica, Long> {
}
