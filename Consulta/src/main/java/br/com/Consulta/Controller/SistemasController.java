
package br.com.Consulta.Controller;


import br.com.Consulta.Model.Sistemas;

import br.com.Consulta.Repositorio.SistemasRepositorio;
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

@RestController
@RequestMapping("/Sistemas")
public class SistemasController {
 
       
    @Autowired
    private SistemasRepositorio sistemasRE;
    
    @GetMapping
    public List<Sistemas> listarTodos() {
        return sistemasRE.findAll();
    }
    
    @GetMapping(value="/{id}")
    public Optional<Sistemas> listarPeloId(@PathVariable Long id) {
        return sistemasRE.findById(id);
    }
    
    @PostMapping
    public Sistemas adicionar(@RequestBody Sistemas sis) {
        return sistemasRE.save(sis);
    }
    
    @PutMapping(value="/{id}")
    public ResponseEntity editar(@PathVariable Long id, @RequestBody Sistemas sis) {
        return sistemasRE.findById(id)
                .map(record -> {
                    record.setNome(sis.getNome());
                    record.setEmpresa(sis.getEmpresa());
                    record.setResponsavel(sis.getResponsavel());
                    Sistemas sist = sistemasRE.save(record);
                    return ResponseEntity.ok().body(sist);
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        return sistemasRE.findById(id)
                .map(record-> {
                    sistemasRE.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
}
