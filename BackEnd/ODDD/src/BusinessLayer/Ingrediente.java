package BusinessLayer;
/**ELIMINAR*/
public class Ingrediente {
    private int id;
    private String nome;
    private double ncal;
    private int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNcal() {
        return ncal;
    }

    public void setNcal(double ncal) {
        this.ncal = ncal;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int q) {
        this.quantidade = q;
    }
}
