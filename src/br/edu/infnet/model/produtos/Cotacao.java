/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.model.produtos;

/**
 *
 * @author Yuri Galdino
 *
 * main features: 
 * - cadastrar cotações. 
 * - consultar cotações por produto. -
 * - imprimir produtos cotados de uma determinada cotação.
 */

public class Cotacao {
    
    
    //int codigoDeBarra;
    double valor;
    int qtd;


    
    public Cotacao(double valor, int qtd) {
        this.valor = valor;
        this.qtd = qtd;
    }
}
