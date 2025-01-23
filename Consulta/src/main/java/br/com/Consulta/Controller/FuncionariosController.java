
package br.com.Consulta.Controller;


import br.com.Consulta.Model.Funcionario;
import br.com.Consulta.Repository.FuncionariosRepository;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import br.com.Consulta.service.FuncionariosService;
import lombok.RequiredArgsConstructor;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/Funcionarios")
public class FuncionariosController {
    

    private final FuncionariosService funcionariosService;

    @GetMapping
    public List<Funcionario> listarTodos() throws IOException  {
        return funcionariosService.findAll();
    }

}
