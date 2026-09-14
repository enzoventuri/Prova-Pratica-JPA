package br.com.ctw.api_monitoramento_transformadores.repository;

import br.com.ctw.api_monitoramento_transformadores.entity.Transformador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransformadorRepository extends JpaRepository<Transformador, Long> {
    Transformador findByNumeroSerie(String numeroSerie);

    void deleteByNumeroSerie(String numeroSerie);
}
