
package br.com.Consulta.Repositorio;

import br.com.Consulta.Model.Sistemas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemasRepositorio extends JpaRepository<Sistemas, Long> {
    
}
