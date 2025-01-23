
package br.com.Consulta.Repository;

import br.com.Consulta.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepository extends JpaRepository<Funcionario, Long>{
    
}
