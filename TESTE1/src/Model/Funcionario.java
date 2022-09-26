
package Model;


public class Funcionario {
    
    private String id;
    private String nome;
    private String estado;
    private String cargo;

    public Funcionario(String nome, String estado, String cargo) {
        this.nome=nome;
        this.estado=estado;
        this.cargo=cargo;
    }

    public Funcionario(String id, String nome, String estado, String cargo) {
        this.id=id;
        this.nome=nome;
        this.estado=estado;
        this.cargo=cargo;
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

    public String getestado() {
        return estado;
    }

    public void setestado(String estado) {
        this.estado = estado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
 } 
