package DataLayer;

import BusinessLayer.Utilizador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReceitaSeguidaDAO implements Map<String, Integer> {
    private String nick;
    
    public static int USERNAME = 1;
    public static int ID_RECEITA = 2;
    
    public ReceitaSeguidaDAO(String nm) {
        this.nick = nm;
    }
    
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM RECEITASSEGUIDAS";
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
            String sql = "SELECT * FROM RECEITASSEGUIDAS";
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean containsKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer get(Object key) {
        /**try {
            Integer id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT NOMEUTILIZADOR FROM RECEITASSEGUIDAS r WHERE r.IDRECEITA = "+id;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String nome = rs.getString(NOME_UTILIZADOR);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return nome;*/
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer put(String key, Integer value) {
        int idRec = 0;
        try {
            String sql = null;
            sql = "INSERT INTO RECEITASSEGUIDAS(username, idReceita)"
                        + "VALUES (?,?)";
            PreparedStatement pstm = ConexaoBD.getConexao().prepareStatement(sql);
            pstm.setString(USERNAME, this.nick);
            pstm.setInt(ID_RECEITA,value);
            pstm.execute();
            
            idRec = value;
            pstm.close();
        } catch (SQLException e) {
        }
        return idRec;
    }

    @Override
    public Integer remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends Integer> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Integer> values() {
        Collection<Integer> res = new HashSet<>();
        try {
            String sql = "SELECT IDRECEITA FROM RECEITASSEGUIDAS r WHERE r.USERNAME = '"+this.nick+"'";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getInt(1));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<String, Integer>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
