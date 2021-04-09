/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.model.produtos;

import br.edu.infnet.model.fornecedores.Fornecedor;
import br.edu.infnet.model.produtos.Cotacao;

/**
 *
 * @author Yuri Galdino
 *
 * main features: - cadastrar produtos.
 */
//Tentei estender a classe Fornecedor (tornando esta abstrata),mas sem sucesso. 
public class Produto implements CadastrarProduto {

    String nome;
    int codigoDeBarra;

//    public Produto(String nome, int codigoDeBarra) {
//        this.nome = nome;
//        this.codigoDeBarra = codigoDeBarra;
//        //Deu bom
////        Cotacao cotation = new Cotacao(cotacao);
////        this.cotacao = cotation.valor;
//    }
    
    public Produto(String nome, int codigoDeBarra) {
        this.nome = nome;
        this.codigoDeBarra = codigoDeBarra;
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        //Adicionar a uma lista ou array.
    }

    public String getNome() {
        return nome;
    }

    public int getCodigoDeBarra() {
        return codigoDeBarra;
    }


}
