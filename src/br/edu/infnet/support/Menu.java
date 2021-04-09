/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.support;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Yuri Galdino
 */
public class Menu {

    //Output variable
    static int choiceApproved;

    public static int menu() {
        System.out.println("\n-------------------------\nACME - Sistema de Compras\n-------------------------\nMENU:\n");

        System.out.println("[1] Cadastrar produtos.\n"
                + "[2] Atualizar produtos.\n"
                + "[3] Deletar produtos.\n"
                + "[4] Consultar produto específico.\n"
                
                //listar → retorna todos os registros.
                + "[5] Consultar todos os produtos.\n"
                + "\n"
                
                //listarPor… → retorna N registros segundo um critério.
                + "[6] Cadastrar e atualizar cotações/quantidade de produtos.\n"
                + "[7] Deletar cotações/quantidade de produtos.\n"
                + "[8] Listar cotações/quantidade de produtos.\n"
                + "[9] Sair.");
    
        System.out.println("Digite escolha abaixo ↓");

        Scanner input = new Scanner(System.in);

        //Try/Catch to check if the input is int
        try {
            int choice = input.nextInt();
            //Check if the input is a valid number.
            if (choice > 9 || choice < 1) {
                System.out.println("ERRO: O número digitado não é válido.");
                redoMenuChoice();

            } else {
                //Pass checked value to output variable "choiceApproved"
                choiceApproved = choice;
            }
            //Catch error when its not a number
        } catch (InputMismatchException err) {
            System.out.println("ERRO: Esta entrada só aceita números inteiros.");
            redoMenuChoice();
        }

        return choiceApproved;
    }

    public static void redoMenuChoice() {
        System.out.println("\nPor favor, escolha uma das opções permitidas...\n");

        //Thread.sleep for 2.4 seconds
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        //Force user to choose again.
        menu();
    }
}
