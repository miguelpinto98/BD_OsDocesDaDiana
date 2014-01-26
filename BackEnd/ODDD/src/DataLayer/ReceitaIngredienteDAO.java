package DataLayer;

import BusinessLayer.Ingrediente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReceitaIngredienteDAO implements Map<Integer, Ingrediente> {    
    private int idreceita;
    
    public static int ID_RECEITA = 1;
    public static int ID_INGREDIENTE = 2;
    
    public ReceitaIngredienteDAO(int idr) {
        this.idreceita = idr;
    }

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM RECEITASINGREDIENTES";
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
            String sql = "SELECT * FROM RECEITASINGREDIENTES";
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean containsKey(Object key) {
        boolean res = false;
        try {
            int id = (Integer) key;
            String sql = "SELECT * FROM RECEITASINGREDIENTES r WHERE r.IDINGREDIENTE = "+id;
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
    public Ingrediente get(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ingrediente put(Integer key, Ingrediente value) {
        Ingrediente ing = null;
        try {
            String sql = null;
            if(!this.containsKey(key)) {
                sql = "INSERT INTO RECEITASINGREDIENTES(idReceita, idingrediente)"
                        + "VALUES (?,?)";
                
            } else {
                sql = "";
            }
            PreparedStatement pstm = ConexaoBD.getConexao().prepareStatement(sql);
            pstm.setInt(ID_RECEITA, this.idreceita);
            pstm.setInt(ID_INGREDIENTE, key);            
            pstm.execute();
            
            ing = value;
            pstm.close();
        } catch (SQLException e) {
        }
        return ing;
    }

    @Override
    public Ingrediente remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Ingrediente> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Ingrediente> values() {
        Collection<Ingrediente> res = new HashSet<>();
        try {
            String sql = "SELECT IDINGREDIENTE FROM RECEITASINGREDIENTES r";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(this.get(rs.getInt(1)));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<Integer, Ingrediente>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
