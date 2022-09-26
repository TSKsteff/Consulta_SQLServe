
package Model;


public class Sistemas
{
    
    private String id;
    private String nome;
    private String empresa;
    private String responsavel;

    
    
     public Sistemas(String nome, String empresa, String responsavel){
        this.nome = nome;
        this.empresa = empresa;
        this.responsavel = responsavel;
    }
    public Sistemas(String id, String nome, String empresa, String responsavel){
        this.id=id;
        this.nome = nome;
        this.empresa = empresa;
        this.responsavel = responsavel;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
 } 
