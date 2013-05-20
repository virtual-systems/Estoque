/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bs.estoque.control;

import br.com.bs.estoque.model.cliente.Cliente;
import br.com.bs.estoque.model.produto.Produto;
import br.com.bs.estoque.model.usuario.Usuario;
import java.util.List;

/**
 * Controller para ações permitidas a todos os usuários.
 * Ações que requerem privilégios de administrador estão contidas em AdminController
 * @see br.com.bs.estoque.dominio.control.AdminController
 * @author Misael Ferreira
 */
public class SimpleUserController {
    public List<Usuario> listaUsuarios(){
        return null;
    }
    
    public Usuario getUsuarioPorNome(String nome){
        return null;
    }
    
    public Usuario getUsuarioPorId(int id){
        return null;
    }
    
    public List<Cliente> listaClientes(){
        return null;
    }
    
    public Cliente getClientePorNome(String nome){
        return null;
    }
    
    public Cliente getClientePorId(int id){
        return null;
    }
    
    public List<Produto> listaProdutos(){
        return null;
    }
    
    public Produto getProdutoPorNome(String nome){
        return null;
    }
    
    public Produto getProdutoPorId(int id){
        return null;
    }
}
