/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.bs.estoque.model.cliente;

/**
 *
 * @author Misael
 */
public class Cliente {
    private long codigo;
    private String nome;
    private String endereco;
    private String cep;
    private String fone;
    private String email;

    /**
     * @return the codigo
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
