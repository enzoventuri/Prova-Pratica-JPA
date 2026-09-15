package br.com.ctw.api_monitoramento_transformadores.repository;

import br.com.ctw.api_monitoramento_transformadores.entity.Transformador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository do Transformador, sendo utilizdo métodos bases (ex: save) e derivadas.
 */
@Repository
public interface TransformadorRepository extends JpaRepository<Transformador, Long> {
    /**
     * Procura por um Transformador com base no seu Número de serie.
     * @param numeroSerie Número de Série do Transformador que desejas buscar.
     * @return Transformador
     */
    Transformador findByNumeroSerie(String numeroSerie);

    /**
     * Remove um Transformador com base no seu Número de Série.
     * @param numeroSerie Número de Série do Transformador que vai ser deletado.
     */
    void removeByNumeroSerie(String numeroSerie);
}
