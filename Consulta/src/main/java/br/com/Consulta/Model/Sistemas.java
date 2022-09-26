
package br.com.Consulta.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Sistemas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String empresa;
    
    @Column(nullable = false, length = 50)
    private String responsavel;
}
