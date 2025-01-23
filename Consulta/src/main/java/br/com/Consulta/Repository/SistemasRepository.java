
package br.com.Consulta.Repository;

import br.com.Consulta.Model.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SistemasRepository extends JpaRepository<Sistema, Long> {
    
}
