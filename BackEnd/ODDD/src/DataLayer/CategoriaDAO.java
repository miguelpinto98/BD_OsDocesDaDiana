package DataLayer;

import BusinessLayer.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CategoriaDAO implements Map<String, Categoria>{
    
    private static final int NOME_CATEGORIA = 1;
    
    public CategoriaDAO() {
    }

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM CATEGORIAS";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res++;
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        boolean res = false;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM CATEGORIAS";
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;    }

    @Override
    public boolean containsKey(Object key) {
        boolean res = false;
        try {
            String categoria = (String) key;
            String sql = "SELECT * FROM CATEGORIAS c WHERE c.NOMECATEGORIA = '"+categoria+"'";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categoria get(Object key) {
        Categoria cat = null;
        try {
            String categoria = (String) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM CATEGORIAS c WHERE c.NOMECATEGORIA = '"+categoria+"' and c.APAGADO = "+0;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String nome = rs.getString(NOME_CATEGORIA);                
                cat = new Categoria(nome);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return cat;    }

    @Override
    public Categoria put(String key, Categoria value) {
        Categoria user = null;
        try {
            String sql;
            if(!this.containsKey(key)) {
                sql = "INSERT INTO Categorias(nomeCategoria) VALUES (?)";                
            } else {
                sql = "";
            }
            PreparedStatement pstm = ConexaoBD.getConexao().prepareStatement(sql);
            pstm.setString(NOME_CATEGORIA, value.getNomeCategoria());
            pstm.execute();
            
            user = value;
            pstm.close();
        } catch (SQLException e) {
        }
        return user;        
    }

    @Override
    public Categoria remove(Object key) {
        Categoria cat = null;
        try {
            String nomecategoria = (String) key;
            String sql = "UPDATE Categorias SET apagado = 1 WHERE nomeCategoria = '"+nomecategoria+"'";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return cat;    }

    @Override
    public void putAll(Map<? extends String, ? extends Categoria> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> keySet() {
        Set<String> res = new TreeSet<>();
        try {
            String sql = "SELECT NOMECATEGORIA FROM CATEGORIAS c WHERE c.APAGADO = 0";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getString(NOME_CATEGORIA));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;    }

    @Override
    public Collection<Categoria> values() {
        Collection<Categoria> res = new HashSet<>();
        try {
            String sql = "SELECT NOMECATEGORIA FROM CATEGORIA c WHERE c.APAGADO = 0";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(this.get(rs.getString(NOME_CATEGORIA)));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<String, Categoria>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
