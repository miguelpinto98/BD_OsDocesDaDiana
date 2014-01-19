package DataLayer;

import BusinessLayer.Comentario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ComentariosDAO implements Map<Integer,Comentario>{
    private int idreceita;
    
    public static int ID_COMENTARIO = 1;
    public static int NOME_UTILiZADOR = 2;
    public static int ID_RECEITA = 3;
    public static int COMENTARIO = 4;
    public static int DATA_COMENTARIO = 5;
    public static int APAGADO = 6;
    
    public ComentariosDAO(int idr) {
        this.idreceita = idr;
    }
    
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM COMENTARIOS";
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
            String sql = "SELECT * FROM COMENTARIOS";
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
            String sql = "SELECT * FROM COMENTARIOS c WHERE c.IDCOMENTARIO = "+id;
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
    public Comentario get(Object key) {
        Comentario com = null;
        try {
            int id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM COMENTARIOS c WHERE c.IDCOMENTARIO = "+id+" and u.APAGADO = "+0;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String user = rs.getString(NOME_UTILiZADOR);
                int idReceita = rs.getInt(ID_RECEITA);
                String comentario = rs.getString(COMENTARIO);
                Calendar dataComentario = GregorianCalendar.getInstance();
                dataComentario.setTime(rs.getTimestamp(DATA_COMENTARIO));
                int rm = rs.getInt(APAGADO);
                
                com = new Comentario(id,user,comentario,(GregorianCalendar) dataComentario,rm);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return com;
    }

    @Override
    public Comentario put(Integer key, Comentario value) {
        Comentario com = null;
        try {
            String sql = null;
            if(!this.containsKey(key)) {
                sql = "INSERT INTO Comentarios(idComentario, nomeUtilizador, idReceita, comentario, dataComentario, apagado)"
                        + "VALUES (?,?,?,?,?,?)";
                
            } else {
                sql = "";
            }
            PreparedStatement pstm = ConexaoBD.getConexao().prepareStatement(sql);
            pstm.setInt(ID_COMENTARIO, value.getId());
            pstm.setString(NOME_UTILiZADOR, value.getUser());
            pstm.setInt(ID_RECEITA, this.idreceita);
            pstm.setString(COMENTARIO, value.getComent());
            Timestamp dataCom = new Timestamp(value.getDatacoment().getTimeInMillis());
            pstm.setTimestamp(DATA_COMENTARIO, dataCom);            
            pstm.setInt(APAGADO, value.getRemovido());
            pstm.execute();
            
            com = value;
            pstm.close();
        } catch (SQLException e) {
        }
        return com;
    }

    @Override
    public Comentario remove(Object key) {
        Comentario user = null;
        try {
            int id = (Integer) key;
            String sql = "UPDATE Comentarios SET apagado = 1 WHERE idComentario = "+id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return user;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Comentario> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<>();
        try {
            String sql = "SELECT IDCOMENTARIO FROM COMENTARIOS c WHERE c.APAGADO = 0";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getInt(ID_COMENTARIO));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Collection<Comentario> values() {
        Collection<Comentario> res = new HashSet<>();
        try {
            String sql = "SELECT IDCOMENTARIO FROM COMENTARIOS c WHERE c.APAGADO = 0";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(this.get(rs.getInt(ID_COMENTARIO)));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<Integer, Comentario>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
