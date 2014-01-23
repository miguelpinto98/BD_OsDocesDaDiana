package BusinessLayer;

import DataLayer.ReceitaDAO;
import java.util.Map;
import java.util.Objects;

public class Categoria {
    private String nomeCategoria;
    private Map<Integer,Receita> categorias;

    public Categoria() {
        this.nomeCategoria = new String();
        this.categorias = new ReceitaDAO(this.nomeCategoria);
    }
    
    public Categoria(String nome) {
        this.nomeCategoria = nome;
        this.categorias = new ReceitaDAO(this.nomeCategoria);
    }

    public String getNomeCategoria(){
        return this.nomeCategoria;
    }
    
    public void setNomeCategoria(String n){
        this.nomeCategoria = n;
    }
    
    public Map<Integer, Receita> getCategorias() {
        return categorias;
    }

    public void setCategorias(Map<Integer, Receita> categorias) {
        this.categorias = categorias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.categorias);
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
        return Objects.equals(this.categorias, other.categorias);
    }
}
