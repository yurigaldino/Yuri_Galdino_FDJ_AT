/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.model.fornecedores;

import java.util.ArrayList;

/**
 *
 * @author Yuri Galdino
 */
public class Fornecedor extends Contato {

    String nome;
    String atividade; //Exemplo: Bebidas, Roupas, Materiais de limpeza
    //ArrayList produtos;
    //static ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
    
    public Fornecedor(String nome, String atividade) {
        this.nome = nome;
        this.atividade = atividade;
    }

    public Fornecedor(String nome, String atividade, String endereco, String email, String telefone) {
        this.nome = nome;
        this.atividade = atividade;
        setEndereco(endereco);
        setEmail(email);
        setTelefone(telefone);
    }

    public String getNome() {
        return nome;
    }

    public String getAtividade() {
        return atividade;
    }

}
