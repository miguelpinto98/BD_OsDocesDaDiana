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
    
    public static int NOME = 2;
    public static int EMAIL = 3;
    public static int PW = 4;
    public static int DATA_REG = 5;
    public static int AVATAR = 6;
    public static int DESC = 7;
    public static int NUM_RECEITAS = 8;
    public static int VAL_AVAL = 9;
    public static int NUM_AVAL = 10;
    public static int DADOS_COMP = 11;
    public static int APAGADO = 12;
    public static int TIPO = 13;
        
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
            String sql = "SELECT * FROM UTILIZADORES u WHERE u.NOMEUTILIZADOR = '"+nick+"'";
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
            String sql = "SELECT * FROM UTILIZADORES u WHERE u.NOMEUTILIZADOR = '"+nick+"' and u.APAGADO = "+0;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String nome = rs.getString(NOME);
                String email = rs.getString(EMAIL);
                String pw = rs.getString(PW);
                Calendar datareg = GregorianCalendar.getInstance();
                datareg.setTime(rs.getTimestamp(DATA_REG));
                Blob img = rs.getBlob(AVATAR); // ATIVAR ISTO
                String desc = rs.getString(DESC);
                int numrec = rs.getInt(NUM_RECEITAS);
                int valaval = rs.getInt(VAL_AVAL);
                int numaval = rs.getInt(NUM_AVAL);
                int dadoscomp = rs.getInt(DADOS_COMP);
                int rm = rs.getInt(APAGADO);
                int tipo = rs.getInt(TIPO);
                
                user = new Utilizador(tipo,nick,nome,email,pw,(GregorianCalendar) datareg, null, desc, numrec,valaval,numaval,dadoscomp,rm);
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
                sql = "INSERT INTO Utilizadores(nomeUtilizador, nome, email, password, dataRegisto, tipo) "
                        + "VALUES (?,?,?,?,?,?)";
                
            } else {
                sql = "";
            }
            PreparedStatement pstm = ConexaoBD.getConexao().prepareStatement(sql);
            pstm.setString(1, value.getNick());
            pstm.setString(NOME, value.getNome());
            pstm.setString(EMAIL, value.getEmail());
            pstm.setString(PW, value.getPassw());
            Timestamp datareg = new Timestamp(value.dataRegisto().getTimeInMillis());
            pstm.setTimestamp(DATA_REG, datareg);            
            pstm.setInt(6, value.getTipo());
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
            String sql = "UPDATE Utilizadores SET apagado = 1 WHERE nomeUtilizador = '"+nick+"'";
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
            String sql = "SELECT NOMEUTILIZADOR FROM UTILIZADORES u WHERE u.APAGADO = 0";
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
            String sql = "SELECT NOMEUTILIZADOR FROM UTILIZADORES u WHERE u.APAGADO = 0";
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
