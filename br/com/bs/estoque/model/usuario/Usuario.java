/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bs.estoque.model.usuario;

/**
 *
 * @author Misael
 */
public class Usuario {
    private int id;
    private String login;
    private String pwd;
    private int categoria;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login == null ? "" : login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public int getCategoria(){
        return categoria;
    }
    
    public void setCategoria(int _categoria){
        this.categoria = _categoria;
    }
}
