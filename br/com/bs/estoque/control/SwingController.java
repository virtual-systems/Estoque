/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bs.estoque.control;
import br.com.bs.estoque.model.cliente.Cliente;
import br.com.bs.estoque.model.cliente.ClienteDAO;
import br.com.bs.estoque.model.produto.Produto;
import br.com.bs.estoque.model.produto.ProdutoDAO;

/**
 *
 * @author Misael Ferreira
 */
public class SwingController {
    private ProdutoDAO produtoDao;
    private ClienteDAO clienteDao;
    private static SwingController instance;
    
    private SwingController(){
        produtoDao = new ProdutoDAO();
        clienteDao = new ClienteDAO();
    }
    
    public static SwingController getInstance(){
        if(instance == null)
            instance = new SwingController();
        return instance;
    }
    
    public String salvaProduto(Produto p){
        return produtoDao.salva(p);
    }
    
    public String salvaCliente(Cliente c){
        return clienteDao.salva(c);
    }

    public String atualizaProduto(Produto p) {
        return produtoDao.atualiza(p);
    }
}
