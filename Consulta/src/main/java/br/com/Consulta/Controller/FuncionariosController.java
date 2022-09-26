
package br.com.Consulta.Controller;


import br.com.Consulta.Model.Funcionarios;
import br.com.Consulta.Repositorio.FuncionariosRepositorio;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //permite lidar com todas as APIs de descanso, como OBTER, POSTAR, Excluir, FAZER solicitações
@RequestMapping("/Funcionarios")// mapeia um caminho ou padrão
public class FuncionariosController {
    
 @Autowired // atribuir automaticamente as propriedade com os valores ou referências passadas
    private FuncionariosRepositorio funcionarioRE;

    @GetMapping 
                    //fazer uma lista puxar por mapeamento todos os dados da minha entidade
    public List<Funcionarios> listarTodos() throws IOException  {
        return funcionarioRE.findAll();
    }
    //findall esse metodo retorna todas as correspondências não sobrepostas de um padrão em uma sequência
    @GetMapping(value="/{id}") 
    public Optional<Funcionarios> listarPeloId(@PathVariable Long id) {
        return funcionarioRE.findById(id);
    }
    
    @PostMapping
    public Funcionarios adicionar(@RequestBody Funcionarios fun) {
        return funcionarioRE.save(fun);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Funcionarios livro) {
        return funcionarioRE.findById(id)
                .map(record -> {
                    record.setNome(livro.getNome());
                    record.setStatus(livro.getStatus());
                    record.setCargo(livro.getCargo());
                    Funcionarios fun = funcionarioRE.save(record);
                    return ResponseEntity.ok().body(fun);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return funcionarioRE.findById(id)
                .map(record-> {
                    funcionarioRE.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
}
