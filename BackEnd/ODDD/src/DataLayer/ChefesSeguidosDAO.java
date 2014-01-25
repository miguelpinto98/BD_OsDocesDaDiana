package DataLayer;

import static DataLayer.ReceitaSeguidaDAO.USERNAME;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChefesSeguidosDAO implements Map<String,String> {

    private String user;
    
    public static int USERNAME = 1;
    public static int CHEFESEGUIDO = 2;
    
    public ChefesSeguidosDAO(String nick) {
        this.user = nick;
    }

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM CHEFESSEGUIDOS";
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
            String sql = "SELECT * FROM CHEFESSEGUIDOS";
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
    public String get(Object key) {
        /**String nick = (String) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT NOMEUTILIZADOR FROM RECEITASSEGUIDAS r WHERE r.IDRECEITA = '"+nick+"'";
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
    public String put(String key, String value) {
        String chefeseg = "";
        try {
            String sql = null;
            sql = "INSERT INTO CHEFESSEGUIDOS (username, chefeseguido)"
                        + "VALUES (?,?)";
            PreparedStatement pstm = ConexaoBD.getConexao().prepareStatement(sql);
            pstm.setString(USERNAME, user);
            pstm.setString(CHEFESEGUIDO,value);
            pstm.execute();
            
            chefeseg = value;
            pstm.close();
        } catch (SQLException e) {
        }
        return chefeseg;
    }

    @Override
    public String remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends String> m) {
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
    public Collection<String> values() {
        Collection<String> res = new HashSet<>();
        try {
            String sql = "SELECT CHEFESEGUIDO FROM CHEFESSEGUIDOS c WHERE c.USERNAME = '"+this.user+"'";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getString(1));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<String, String>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
