/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bs.estoque.model.usuario;

import br.com.bs.estoque.model.database.mysql.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Misael
 */
public class UsuarioDAO {
    public boolean salva(Usuario usuario) {
        String sql = "insert into usuario(nome, pwd) values(?,?,?);";
        try {
            PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getPwd());
            
            return !stmt.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*public Usuario buscaPorNome(String nome) {
        Usuario resultado = null;
        try {
            String sql = "select id,nome,endereco,cep,fone, email from cliente where nome like '%" + nome + "%'";
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
*/
    public boolean atualiza(Usuario usuario) {
        String sql = "update usuario set nome = '?', pwd = ? where id = ?;";
        try {
            PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getPwd());            
            int res = stmt.executeUpdate();
            return (res > 0);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    /*public List<Cliente> lista() {
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
*/
    public boolean exclui(long id) {
        String sql = "delete from usuario where id = ?";
        try {
            PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
            stmt.setLong(1, id);
            return stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public boolean verificaUsuario(Usuario usuario){
        String sql = "select * from usuario where nome = ? and pwd = ?";
        
        try{
            PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getPwd());            
            ResultSet rs = stmt.executeQuery();
            if(rs.first()){                
                return true;
            }
        }catch(SQLException exc){
            exc.printStackTrace();
        }
        return false;
    }
    
    public Usuario getUsuarioByName(String usrName){
        Usuario result = null;
        String sql = "select * from usuario where nome = ?";
        
        try{
            PreparedStatement stmt = ConnectionFactory.getConn().prepareStatement(sql);
            stmt.setString(1, usrName);
            ResultSet rs = stmt.executeQuery();
            if(rs.first()){
                result = new Usuario();
                result.setId(rs.getInt("id"));
                result.setLogin(rs.getString("nome"));
                result.setPwd(rs.getString("pwd"));
                result.setCategoria(rs.getInt("categoria"));
            }
        }catch(SQLException exc){
            exc.printStackTrace();                 
        }
        return result;
    }
}
