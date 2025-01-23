
package br.com.Consulta.Model;




import javax.persistence.Column;//geração de columnas
import javax.persistence.Entity;
import javax.persistence.GeneratedValue; //geração do valor do identificador único da entidade
import javax.persistence.GenerationType; //Indica que o provedor de persistência deve 
//atribuir chaves primárias para a entidade usando uma tabela de banco de dados
import javax.persistence.Id; //indicando o campo de membros abaixo é a chave principal da entidade atual

import lombok.Data;

@Data
@Entity(name = "funcionarios_entity")
public class Funcionarios {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    private String status ;
    
    @Column(nullable = false, length = 50)
    private String cargo;

}


