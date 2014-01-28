package BusinessLayer;

import DataLayer.ReceitaDAO;
import java.util.Map;
import java.util.Objects;

public class Categoria {
    private String nomeCategoria;
    private Map<Integer,Receita> receitas;

    public Categoria() {
        this.nomeCategoria = new String();
        this.receitas = new ReceitaDAO(this.nomeCategoria);
    }
    
    public Categoria(String nome) {
        this.nomeCategoria = nome;
        this.receitas = new ReceitaDAO(this.nomeCategoria);
    }

    public String getNomeCategoria(){
        return this.nomeCategoria;
    }
    
    public void setNomeCategoria(String n){
        this.nomeCategoria = n;
    }
    
    public Map<Integer, Receita> getReceitas() {
        return receitas;
    }

    public void setCategorias(Map<Integer, Receita> categorias) {
        this.receitas = categorias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.receitas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categoria other = (Categoria) obj;
        return Objects.equals(this.receitas, other.receitas);
    }
    
    public boolean inserirReceita(Receita rec) {
        boolean ins = false;
        this.receitas.put(0,rec);
        ins = true;
        return ins;
    }
    
}
