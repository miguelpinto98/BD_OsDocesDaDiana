package DataLayer;

import BusinessLayer.Utilizador;
import java.sql.Blob;
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

public class UtilizadorDAO implements Map<String, Utilizador> {
    
    public static int USERNAME = 1;
    public static int NOME = 2;
    public static int EMAIL = 3;
    public static int PW = 4;
    public static int AVATAR = 5;
    public static int DESC = 6;
    public static int NUM_RECEITAS = 7;
    public static int VAL_AVAL = 8;
    public static int NUM_AVAL = 9;
    public static int DADOS_COMP = 10;
    public static int APAGADO = 11;
    public static int TIPO = 12;
    public static int CREATE = 13;
    public static int UPDATE = 14;
    public static int LOCALIDADE = 15;
    
    public UtilizadorDAO() {
    }

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM UTILIZADORES";
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
            String sql = "SELECT * FROM UTILIZADORES";
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
            String nick = (String) key;
            String sql = "SELECT * FROM UTILIZADORES u WHERE u.USERNAME = '"+nick+"'";
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
    public Utilizador get(Object key) {
        Utilizador user = null;
        try {
            String nick = (String) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM UTILIZADORES u WHERE u.USERNAME = '"+nick+"' and u.APAGADO = "+0;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String nome = rs.getString(USERNAME);
                String email = rs.getString(EMAIL);
                String pw = rs.getString(PW);
                String img = rs.getString(AVATAR); // ATIVAR ISTO
                String desc = rs.getString(DESC);
                int numrec = rs.getInt(NUM_RECEITAS);
                int valaval = rs.getInt(VAL_AVAL);
                int numaval = rs.getInt(NUM_AVAL);
                int dadoscomp = rs.getInt(DADOS_COMP);
                int rm = rs.getInt(APAGADO);
                int tipo = rs.getInt(TIPO);
                Calendar create = GregorianCalendar.getInstance();
                create.setTime(rs.getTimestamp(CREATE));
                Calendar upd = GregorianCalendar.getInstance();
                upd.setTime(rs.getTimestamp(UPDATE));
                String localidade = rs.getString(LOCALIDADE);
                
                user = new Utilizador (tipo, nick, nome, email, pw, desc, img, numrec, valaval, numaval, dadoscomp, rm, (GregorianCalendar) create, (GregorianCalendar) upd, localidade);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return user;
    }

    @Override
    public Utilizador put(String key, Utilizador value) {
        Utilizador user = null;
        try {
            String sql = null;
            if(!this.containsKey(key)) {
                sql = "INSERT INTO Utilizadores(username, nome, email, password, tipo, created_at, updated_at, localidade) "
                        + "VALUES (?,?,?,?,?,?,?,?)";
                
            } else {
                sql = "";
            }
            PreparedStatement pstm = ConexaoBD.getConexao().prepareStatement(sql);
            pstm.setString(USERNAME, value.getNick());
            pstm.setString(NOME, value.getNome());
            pstm.setString(EMAIL, value.getEmail());
            pstm.setString(PW, value.getPassw());            
            pstm.setInt(TIPO, value.getTipo());
            Timestamp create = new Timestamp(value.getCreate().getTimeInMillis());
            pstm.setTimestamp(CREATE, create);
            Timestamp update = new Timestamp(value.getUpdate().getTimeInMillis());
            pstm.setTimestamp(UPDATE, update);
            pstm.setString(LOCALIDADE, value.getLocalidade());
            
            pstm.execute();
            
            user = value;
            pstm.close();
        } catch (SQLException e) {
        }
        return user;
    }

    @Override
    public Utilizador remove(Object key) {
        Utilizador user = null;
        try {
            String nick = (String) key;
            String sql = "UPDATE Utilizadores SET apagado = 1 WHERE id = '"+nick+"'";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return user;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Utilizador> m) {
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
            String sql = "SELECT USERNAME FROM UTILIZADORES u WHERE u.APAGADO = 0";
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
    public Collection<Utilizador> values() {
        Collection<Utilizador> res = new HashSet<>();
        try {
            String sql = "SELECT USERNAME FROM UTILIZADORES u WHERE u.APAGADO = 0";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(this.get(rs.getString(1)));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<String, Utilizador>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
