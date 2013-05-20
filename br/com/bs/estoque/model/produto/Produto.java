package br.com.bs.estoque.model.produto;

public class Produto {
    
    private String id,nome, descricao, preco, quantidade,dataAtualizacao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String res = nome;
        if(res.length() > 10)
        res = res.substring(0,10);
        this.nome = res;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String res = descricao;
        if(res.length() > 30)
            res = res.substring(0,30);
        this.descricao = res;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    /**
     * @return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the dataAtualizacao
     */
    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    /**
     * @param dataAtualizacao the dataAtualizacao to set
     */
    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
