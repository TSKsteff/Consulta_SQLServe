
package br.com.Consulta.Repositorio;

import br.com.Consulta.Model.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRepositorio extends JpaRepository<Funcionarios, Long>{
    
}
