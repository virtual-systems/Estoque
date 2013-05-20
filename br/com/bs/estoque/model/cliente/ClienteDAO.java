package br.com.bs.estoque.model.cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.bs.estoque.model.database.mysql.ConnectionFactory;
import java.awt.TrayIcon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ClienteDAO {
    public static final String  SALVA_CLIENTE_OK = "Cliente CADASTRADO com sucesso.";
    public static final String  ATUALIZA_CLIENTE_OK = "Cliente ATUALIZADO com sucesso.";
    public static final String  EXCLUI_CLIENTE_OK = "Cliente EXCLUÍDO com sucesso.";
    public static final String  DEFAULT_CLIENTE_ERROR_MSG = "ERRO ao cadastrar cliente.";
    public static final String  DUPLICATE_CLIENTE_ENTRY_ERROR = "ERRO ao cadastrar cliente:\nJá existe"
            + " um cliente cadastrado com este código.";
    
    public String salva(Cliente cliente) {
        String sql = "insert into cliente(nome, endereco,cep,fone,email,codigo) values(?,?,?,?,?,?);";
        try {
            PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getFone());
            stmt.setString(5, cliente.getEmail());
            stmt.setLong(6, cliente.getCodigo());
            if(!stmt.execute())
                return SALVA_CLIENTE_OK;
        }catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException exc){
            return DUPLICATE_CLIENTE_ENTRY_ERROR;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DEFAULT_CLIENTE_ERROR_MSG;
    }

    public Cliente buscaPorNome(String nome) {
        Cliente resultado = null;
        try {
            String sql = "select codigo,nome,endereco,cep,fone, email from cliente where nome like '%" + nome + "%'";
            Statement stmt = ConnectionFactory.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.first()) {
                resultado = new Cliente();
                resultado.setCodigo(rs.getLong(1));
                resultado.setNome(rs.getString(2));
                resultado.setEndereco(rs.getString(3));
                resultado.setCep(rs.getString(4));
                resultado.setFone(rs.getString(5));
                resultado.setEmail(rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public boolean atualiza(Cliente cliente) {
        String sql = "update cliente set nome = '?', endereco = '?',"
                + "cep = '?', fone = '?', email = ? where codigo = ?;";
        try {
            PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getFone());
            stmt.setString(5, cliente.getEmail());
            stmt.setLong(6, cliente.getCodigo());
            int res = stmt.executeUpdate();
            return (res > 0);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public List<Cliente> lista() {
        List<Cliente> result = new ArrayList();

        String sql = "select * from cliente";
        try {
            Statement stmt = ConnectionFactory.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Cliente tmpCli;
            while (rs.next()) {
                tmpCli = new Cliente();
                tmpCli.setCodigo(rs.getLong("codigo"));
                tmpCli.setNome(rs.getString("nome"));
                tmpCli.setEndereco(rs.getString("endereco"));
                tmpCli.setCep(rs.getString("cep"));
                tmpCli.setFone(rs.getString("fone"));
                tmpCli.setEmail(rs.getString("email"));
                result.add(tmpCli);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean exclui(long codigo) {
        String sql = "delete from cliente where codigo = ?";
        try {
            PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
            stmt.setLong(1, codigo);
            return stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}