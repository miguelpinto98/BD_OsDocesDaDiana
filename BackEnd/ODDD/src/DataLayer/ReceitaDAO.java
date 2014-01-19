package DataLayer;

import BusinessLayer.Receita;
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

public class ReceitaDAO implements Map<Integer, Receita>{

    private String nomeCategoria;
    
    public static int ID_RECEITA = 1;
    public static int NOME = 2;
    public static int DESCRICAO = 3;
    public static int NR_IMAGENS = 4;
    public static int DATA_PUBLICACAO = 5;
    public static int CATEGORIA = 6;
    public static int NOME_UTILIZADOR = 7;
    public static int VALOR_AVALIACOES = 8;
    public static int NR_AVALIACOES = 9;
    public static int TOTAL_CALORIAS = 10;
    public static int APAGADO = 11;
    
    public ReceitaDAO(){
    }
    
    public ReceitaDAO(String nCat) {
        this.nomeCategoria = nCat;
    }

    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM RECEITAS";
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
            String sql = "SELECT * FROM RECEITAS";
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
            String sql = "SELECT * FROM RECEITAS r WHERE r.IDRECEITA = "+id;
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
    public Receita get(Object key) {
        Receita rec = null;
        try {
            int id = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM RECEITAS r WHERE r.IDRECEITA = "+id+" and u.APAGADO = "+0;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                String nomeReceita = rs.getString(NOME);
                String descricao = rs.getString(DESCRICAO);
                int nrImagens = rs.getInt(NR_IMAGENS);
                Calendar dataPub = GregorianCalendar.getInstance();
                dataPub.setTime(rs.getTimestamp(DATA_PUBLICACAO));
                //String categoria = rs.getString(CATEGORIA);
                String user = rs.getString(NOME_UTILIZADOR);
                int valorAvaliacoes = rs.getInt(VALOR_AVALIACOES); // ALTERAR CASO MUDE NA CLASSE RECEITA
                int nrAvaliacoes = rs.getInt(NR_AVALIACOES);
                int totalCalorias = rs.getInt(TOTAL_CALORIAS); // ALTERAR CASO MUDE NA CLASSE RECEITA
                int rm = rs.getInt(APAGADO);
                
                rec = new Receita(id, nomeReceita, descricao, nrImagens, (GregorianCalendar) dataPub, this.nomeCategoria, user, valorAvaliacoes, nrAvaliacoes, totalCalorias, rm);
            }            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return rec;
    }

    @Override
    public Receita put(Integer key, Receita value) {
        Receita rec = null;
        try {
            String sql = null;
            if(!this.containsKey(key)) {
                sql = "INSERT INTO Receita(idReceita, nome, descricao, nrImagens, dataPublicacao, categoria, nomeUtilizador, valorAvaliacoes, nrAvaliacoes, totalCalorias, apagado)"
                        + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                
            } else {
                sql = "";
            }
            PreparedStatement pstm = ConexaoBD.getConexao().prepareStatement(sql);
            pstm.setInt(ID_RECEITA, value.getId());
            pstm.setString(NOME, value.getNome());
            pstm.setString(DESCRICAO, value.getDesc());
            pstm.setInt(NR_IMAGENS, value.getNimgs());
            Timestamp dataPub = new Timestamp(value.getDatapub().getTimeInMillis());
            pstm.setTimestamp(DATA_PUBLICACAO, dataPub);
            pstm.setString(CATEGORIA, this.nomeCategoria);
            pstm.setString(NOME_UTILIZADOR, value.getUser());
            pstm.setInt(VALOR_AVALIACOES, value.getVavaliacoes());
            pstm.setInt(NR_AVALIACOES, value.getNavaliacoes());
            pstm.setInt(TOTAL_CALORIAS, value.getTotalCal());
            pstm.setInt(APAGADO, value.getRemovido());
            pstm.execute();
            
            rec = value;
            pstm.close();
        } catch (SQLException e) {
        }
        return rec;
    }

    @Override
    public Receita remove(Object key) {
        Receita rec = null;
        try {
            int id = (Integer) key;
            String sql = "UPDATE Receitas SET apagado = 1 WHERE idReceita = "+id;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return rec;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Receita> m) {
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
            String sql = "SELECT IDRECEITA FROM RECEITAS r WHERE r.APAGADO = 0";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getInt(ID_RECEITA));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Collection<Receita> values() {
        Collection<Receita> res = new HashSet<>();
        try {
            String sql = "SELECT IDRECEITA FROM RECEITAS r WHERE r.APAGADO = 0";
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(this.get(rs.getInt(ID_RECEITA)));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Set<Entry<Integer, Receita>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
}
