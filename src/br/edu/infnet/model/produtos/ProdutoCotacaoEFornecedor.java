/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.model.produtos;

import br.edu.infnet.model.fornecedores.Fornecedor;

/**
 *
 * @author Yuri Galdino
 */
public class ProdutoCotacaoEFornecedor {

    Produto produto;
    Cotacao cotacao;
    Fornecedor fornecedor;

    public ProdutoCotacaoEFornecedor(Produto produto, Cotacao cotacao, Fornecedor fornecedor) {
        this.produto = produto;
        this.cotacao = cotacao;
        this.fornecedor = fornecedor;
    }

    public String getNome() {
        return produto.getNome();
    }

    public int getCodigoDeBarra() {
        return produto.getCodigoDeBarra();
    }
    
    public double getCotacao() {
        return cotacao.valor;
    }
    
    public int getQtd() {
        return cotacao.qtd;
    }
    
    public String getFornecedorNome() {
        return fornecedor.getNome();
    }
    
    public String getFornecedorAtividade() {
        return fornecedor.getAtividade();
    }
}
