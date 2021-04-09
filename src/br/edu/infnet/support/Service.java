/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.support;

import br.edu.infnet.Application;
import static br.edu.infnet.Application.formatDoubleReal;
import br.edu.infnet.model.fornecedores.Fornecedor;
import br.edu.infnet.model.produtos.Cotacao;
import br.edu.infnet.model.produtos.Produto;
import br.edu.infnet.model.produtos.ProdutoCotacaoEFornecedor;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Calendar;

/**
 *
 * @author Yuri Galdino
 *
 */
public class Service {

    //Dados
    static ArrayList<Produto> produtos = new ArrayList<Produto>();
    static ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
    static ArrayList<ProdutoCotacaoEFornecedor> produtosECotacoesEFornecedores = new ArrayList<ProdutoCotacaoEFornecedor>();

    //General info
    static String nome = "";
    static int codigoDeBarra = 0;
    static int qtd = 0;
    static double cotacao = 0;

    static int idService = 0;

    //productUpdate()
    static int indice = 0;
    static int codigo = 0;

    public static void main(String[] args) {
        produtos.add(new Produto("Papel higiênico Neve", 5112517));
        produtos.add(new Produto("Café Pilão 500g", 5196523));
        produtos.add(new Produto("Café Três Corações 500g", 5196524));
        produtos.add(new Produto("Sabonete líquido Fiorucci Erva Doce 5L", 542453));
        produtos.add(new Produto("Sabonete líquido o Boticário 400ml", 542452));

        //Fornecedores fixos
        fornecedores.add(new Fornecedor("Supermercado Mundial", "Varejista"));
        fornecedores.add(new Fornecedor("Supermercado Guanabara", "Varejista"));
        fornecedores.add(new Fornecedor("Supermercado Campeão", "Varejista"));

        produtosECotacoesEFornecedores.add(new ProdutoCotacaoEFornecedor(
                new Produto("Papel higiênico Neve", 5112517),
                new Cotacao(34.00, 2),
                new Fornecedor("Supermercado Mundial", "Varejista")));

        produtosECotacoesEFornecedores.add(new ProdutoCotacaoEFornecedor(
                new Produto("Café Pilão 500g", 5196523),
                new Cotacao(11.99, 3),
                new Fornecedor("Supermercado Mundial", "Varejista")));

        produtosECotacoesEFornecedores.add(new ProdutoCotacaoEFornecedor(
                new Produto("Papel higiênico Neve", 5112517),
                new Cotacao(29.00, 3),
                new Fornecedor("Supermercado Guanabara", "Varejista")));
        
        produtosECotacoesEFornecedores.add(new ProdutoCotacaoEFornecedor(
                new Produto("Café Pilão 500g", 5196523),
                new Cotacao(8.99, 2),
                new Fornecedor("Supermercado Guanabara", "Varejista")));

        produtosECotacoesEFornecedores.add(new ProdutoCotacaoEFornecedor(
                new Produto("Sabonete líquido o Boticário 400ml", 542452),
                new Cotacao(25.99, 1),
                new Fornecedor("Supermercado Mundial", "Varejista")));

        produtosECotacoesEFornecedores.add(new ProdutoCotacaoEFornecedor(
                new Produto("Café Pilão 500g", 5196523),
                new Cotacao(8.99, 5),
                new Fornecedor("Supermercado Campeão", "Varejista")));

    }

    //Scanner de Nome, Códiggo de barra e Quantidade 
    public static void productInfo() {
        Scanner input = new Scanner(System.in);

        System.out.println("Nome, Marca e Peso em g (Exemplo: Batata Ruffles 57g) ↓");
        String inputStringNome = input.nextLine();

        if (inputStringNome.isEmpty() || inputStringNome.isBlank()) {
            System.out.println("ERRO: Esta entrada não pode estar vazia.");
            productInfo();
        }
        nome = inputStringNome;

        if (idService == 0) {
            System.out.println("Número de código de barra (Exemplo: 5101259) ↓");
        } else if (idService == 1) {
            System.out.println("Número de código de barra do produto a ser atualizado ↓");
        }
        try {

            if (idService == 0) {
                int inputIntCodigo = input.nextInt();
                for (Produto p : produtos) {
                    if (p.getCodigoDeBarra() == inputIntCodigo) {
                        System.out.println("ERRO: Código de barra já cadastrado no Sistema.\n");
                        productInfo();
                    }

                }
                codigoDeBarra = inputIntCodigo;
            } else if (idService == 1) {
                int inputIntCodigo = input.nextInt();
                for (Produto p : produtos) {
                    if (p.getCodigoDeBarra() == inputIntCodigo) {
                        codigo = inputIntCodigo;
                        indice = produtos.indexOf(p);
                        break;
                    }
                }
                if (codigo == 0) {
                    System.out.println("ERRO: Este número de código de barra não existe no sistema.\nRegistre um produto com o mesmo ou refaça o processo de atualização.");
                    productUpdate();

                }

                codigoDeBarra = inputIntCodigo;
            }

        } catch (InputMismatchException err) {
            System.out.println("ERRO: Esta entrada só aceita números.\n");
            productInfo();
        }

//        try {
//            System.out.println("Quantidade de itens (Exemplo: 2) ↓");
//            int inputQtdInt = input.nextInt();
//
//            qtd = inputQtdInt;
//
//            //Catch error when its not a int
//        } catch (InputMismatchException err) {
//            System.out.println("ERRO: Esta entrada só aceita itens do tipo inteiro.");
//            productInfo();
//        }
//
////        
//        System.out.println("Cotação do produto (em R$, Exemplo: 2,59) ↓");
//
//        try {
//            double inputQtdDouble = input.nextDouble();
//
//            cotacao = inputQtdDouble;
//
//            //Catch error when its not a double
//        } catch (InputMismatchException err) {
//            System.out.println("ERRO: Utilize vírgula e valores decimais válidos.");
//            productInfo();
//        }
    }

    public static void productRegister() {

        System.out.println("\n~REGISTRO DE UM NOVO PRODUTO~");

        //Infos gerais de qualquer produto
        productInfo();

        Produto produto = new Produto(nome, codigoDeBarra);

        //add to arrayList
        produtos.add(produto);

        System.out.println("O seguinte produto foi registrado:\n"
                + "\nDescrição: " + nome
                //                + "\nQuantidade: " + qtd
                + "\nNúmero Código de Barra: " + codigoDeBarra
                //                + "\nCotação: " + Application.formatDoubleReal(cotacao)
                + "\nÍndice na lista: " + produtos.indexOf(produto));

        br.edu.infnet.Application.main(new String[0]);
    }

    public static void productUpdate() {

        int indexOfLastProduct = (produtos.size()) - 1;

        System.out.println("\n~ATUALIZAÇÃO DE UM PRODUTO~");

        Scanner input = new Scanner(System.in);

        System.out.println("[1] Por índice.\n" + "[2] Por número de código de barra.");

        try {

            int inputChoiceInt = input.nextInt();

            if (inputChoiceInt == 1) {

                idService = 0;

                System.out.println("Índice do produto a ser atualizado ↓");

                try {

                    int inputIntIndiceCodigo = input.nextInt();
                    indice = inputIntIndiceCodigo;

                    if (indice < -1 || indice > indexOfLastProduct) {
                        System.out.println("ERRO: O index " + indice + " não existe na lista de produtos.\nTente índices entre 0 e " + indexOfLastProduct + ".\n");
                        productUpdate();
                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números.\n");
                    productUpdate();
                }

                productInfo();

                Produto produto = new Produto(nome, codigoDeBarra);

                System.out.println("\nO produto de índice " + indice + " foi atualizado de:\n"
                        + "\nDescrição: " + produtos.get(indice).getNome()
                        //                        + "\nQuantidade: " + produtos.get(indice).getQtd()
                        + "\nNúmero Código de Barra: " + produtos.get(indice).getCodigoDeBarra()
                        //                        + "\nCotação: " + Application.formatDoubleReal(produtos.get(indice).getCotacao())
                        + "\nÍndice na lista: " + produtos.indexOf(produtos.get(indice)));

                //add to arrayList in specific index
                produtos.set(indice, produto);

                System.out.println("-------------------------------------------------------\n" + "Para:\n"
                        + "\nDescrição: " + nome
                        //                        + "\nQuantidade: " + qtd
                        + "\nNúmero Código de Barra: " + codigoDeBarra
                        //                        + "\nCotação: " + Application.formatDoubleReal(cotacao)
                        + "\nÍndice na lista: " + produtos.indexOf(produto)
                        + "\n-------------------------------------------------------");

                br.edu.infnet.Application.main(new String[0]);

            } else if (inputChoiceInt == 2) {

                idService = 1;
                productInfo();

                Produto produto = new Produto(nome, codigoDeBarra);

                System.out.println("O produto de número " + codigo + " foi atualizado de:\n"
                        + "\nDescrição: " + produtos.get(indice).getNome()
                        //                        + "\nQuantidade: " + produtos.get(indice).getQtd()
                        + "\nNúmero Código de Barra: " + produtos.get(indice).getCodigoDeBarra()
                        //                        + "\nCotação: " + Application.formatDoubleReal(produtos.get(indice).getCotacao())
                        + "\nÍndice na lista: " + produtos.indexOf(produtos.get(indice)));

                //add to arrayList in specific index
                produtos.set(indice, produto);

                System.out.println("-------------------------------------------------------\n" + "Para:\n"
                        + "\nDescrição: " + nome
                        //                        + "\nQuantidade: " + qtd
                        + "\nNúmero Código de Barra: " + codigoDeBarra
                        //                        + "\nCotação: " + Application.formatDoubleReal(cotacao)
                        + "\nÍndice na lista: " + produtos.indexOf(produto)
                        + "\n-------------------------------------------------------");

                br.edu.infnet.Application.main(new String[0]);

            } else {
                System.out.println("ERRO: Digite uma opção válida.");
                productUpdate();
            }

        } catch (InputMismatchException err) {
            System.out.println("ERRO: Esta entrada só aceita números.\n");
            productUpdate();
        }

    }

    public static void productDelete() {

        int indexOfLastProduct = (produtos.size()) - 1;

        System.out.println("\n~REMOÇÃO DE PRODUTOS~");

        Scanner input = new Scanner(System.in);

        System.out.println("[1] Por índice.\n" + "[2] Por número de código de barra.");

        try {

            int inputChoiceInt = input.nextInt();

            if (inputChoiceInt == 1) {

                System.out.println("Índice do produto a ser deletado ↓");

                try {

                    int inputIntIndiceCodigo = input.nextInt();
                    indice = inputIntIndiceCodigo;

                    if (indice < -1 || indice > indexOfLastProduct) {
                        System.out.println("ERRO: O index " + indice + " não existe na lista de produtos.\nTente índices entre 0 e " + indexOfLastProduct + ".\n");
                        productDelete();
                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números.\n");
                    productDelete();
                }

                System.out.println("\n-------------------------------------------------------" + "\nProduto a ser deletado:");

                System.out.println("\nDescrição: " + produtos.get(indice).getNome()
                        //                        + "\nQuantidade: " + produtos.get(indice).getQtd()
                        + "\nNúmero Código de Barra: " + produtos.get(indice).getCodigoDeBarra()
                        //                        + "\nCotação: " + Application.formatDoubleReal(produtos.get(indice).getCotacao())
                        + "\nÍndice na lista: " + produtos.indexOf(produtos.get(indice)) + "\n-------------------------------------------------------");

                System.out.println("\nDeletar produto?");
                System.out.println("[1] Sim.\n"
                        + "[2] Não.");

                try {

                    int inputIntChoice = input.nextInt();

                    if (inputIntChoice == 1) {
                        produtos.remove(indice);
                        System.out.println("Produto removido com sucesso!");

                        br.edu.infnet.Application.main(new String[0]);

                    } else if (inputIntChoice == 2) {
                        System.out.println("Produto não removido.");

                        br.edu.infnet.Application.main(new String[0]);
                    } else {
                        System.out.println("ERRO: Escolha uma opção válida.\n");
                        productDelete();
                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números. Refaça o processo de remoção de produto.\n");
                    productDelete();
                }

            } else if (inputChoiceInt == 2) {

                System.out.println("Número de código de barra do produto a ser deletado ↓");

                try {

                    int inputIntCodigo = input.nextInt();
                    for (Produto p : produtos) {
                        if (p.getCodigoDeBarra() == inputIntCodigo) {
                            codigo = inputIntCodigo;
                            indice = produtos.indexOf(p);
                            break;
                        }
                    }
                    if (codigo == 0) {
                        System.out.println("ERRO: Este número de código de barra não existe no sistema.\nRevise seu código de barra e tente novamente.");
                        productDelete();

                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números.\n");
                    productDelete();
                }

                System.out.println("\n-------------------------------------------------------" + "\nProduto a ser deletado:");

                System.out.println("\nDescrição: " + produtos.get(indice).getNome()
                        //                        + "\nQuantidade: " + produtos.get(indice).getQtd()
                        + "\nNúmero Código de Barra: " + produtos.get(indice).getCodigoDeBarra()
                        //                        + "\nCotação: " + Application.formatDoubleReal(produtos.get(indice).getCotacao())
                        + "\nÍndice na lista: " + produtos.indexOf(produtos.get(indice)) + "\n-------------------------------------------------------");

                System.out.println("\nDeletar produto?");
                System.out.println("[1] Sim.\n"
                        + "[2] Não.");

                try {

                    int inputIntChoice = input.nextInt();

                    if (inputIntChoice == 1) {
                        produtos.remove(indice);
                        System.out.println("Produto removido com sucesso!");

                        for (Produto p : produtos) {
                            System.out.println("\nDescrição: " + p.getNome()
                                    //                                    + "\nQuantidade: " + p.getQtd()
                                    + "\nNúmero Código de Barra: " + p.getCodigoDeBarra()
                                    //                                    + "\nCotação: " + Application.formatDoubleReal(p.getCotacao())
                                    + "\nÍndice na lista: " + produtos.indexOf(p));
                        }

                        br.edu.infnet.Application.main(new String[0]);

                    } else if (inputIntChoice == 2) {
                        System.out.println("Produto não removido.");

                        br.edu.infnet.Application.main(new String[0]);
                    } else {
                        System.out.println("ERRO: Escolha uma opção válida.\n");
                        productDelete();
                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números. Refaça o processo de remoção de produto.\n");
                    productDelete();
                }

            } else {
                System.out.println("ERRO: Digite uma opção válida.");
                productDelete();
            }

        } catch (InputMismatchException err) {
            System.out.println("ERRO: Esta entrada só aceita números.\n");
            productDelete();
        }
    }

    public static void checkSpecificProduct() {

        int indexOfLastProduct = (produtos.size()) - 1;

        System.out.println("\n~CONSULTA DE PRODUTO ESPECÍFICO~");

        Scanner input = new Scanner(System.in);

        System.out.println("[1] Por índice.\n" + "[2] Por número de código de barra.");

        try {

            int inputChoiceInt = input.nextInt();

            if (inputChoiceInt == 1) {

                System.out.println("Índice do produto ↓");

                try {

                    int inputIntIndiceCodigo = input.nextInt();
                    indice = inputIntIndiceCodigo;

                    if (indice < -1 || indice > indexOfLastProduct) {
                        System.out.println("ERRO: O index " + indice + " não existe na lista de produtos.\nTente índices entre 0 e " + indexOfLastProduct + ".\n");
                        checkSpecificProduct();
                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números.\n");
                    checkSpecificProduct();
                }

                System.out.println("\n-------------------------------------------------------" + "\nProduto com índice " + indice + ":");

                System.out.println("\nDescrição: " + produtos.get(indice).getNome()
                        //                        + "\nQuantidade: " + produtos.get(indice).getQtd()
                        + "\nNúmero Código de Barra: " + produtos.get(indice).getCodigoDeBarra()
                        //                        + "\nCotação: " + Application.formatDoubleReal(produtos.get(indice).getCotacao())
                        + "\nÍndice na lista: " + produtos.indexOf(produtos.get(indice)) + "\n-------------------------------------------------------");

                while (inputChoiceInt == 1) {

                    System.out.println("\nChecar mais produtos?");
                    System.out.println("[1] Sim.\n"
                            + "[2] Não.");

                    int n1 = input.nextInt();
                    if (n1 == 1) {

                        try {
                            System.out.println("Índice do produto ↓");

                            int inputIntIndiceCodigo = input.nextInt();
                            indice = inputIntIndiceCodigo;

                            if (indice < -1 || indice > indexOfLastProduct) {
                                System.out.println("ERRO: O index " + indice + " não existe na lista de produtos.\nTente índices entre 0 e " + indexOfLastProduct + ".\n");
                                checkSpecificProduct();
                            }

                        } catch (InputMismatchException err) {
                            System.out.println("ERRO: Esta entrada só aceita números.\n");
                            checkSpecificProduct();
                        }

                        System.out.println("\n-------------------------------------------------------" + "\nProduto com índice " + indice + ":");

                        System.out.println("\nDescrição: " + produtos.get(indice).getNome()
                                //                                + "\nQuantidade: " + produtos.get(indice).getQtd()
                                + "\nNúmero Código de Barra: " + produtos.get(indice).getCodigoDeBarra()
                                //                                + "\nCotação: " + Application.formatDoubleReal(produtos.get(indice).getCotacao())
                                + "\nÍndice na lista: " + produtos.indexOf(produtos.get(indice)) + "\n-------------------------------------------------------");

                    }
                    if (n1 == 2) {
                        br.edu.infnet.Application.main(new String[0]);
                        break;
                    }

                }

            } else if (inputChoiceInt == 2) {

                System.out.println("Número de código de barra do produto ↓");

                try {

                    int inputIntCodigo = input.nextInt();
                    for (Produto p : produtos) {
                        if (p.getCodigoDeBarra() == inputIntCodigo) {
                            codigo = inputIntCodigo;
                            indice = produtos.indexOf(p);
                            break;
                        }
                    }
                    if (codigo == 0) {
                        System.out.println("ERRO: Este número de código de barra não existe no sistema.\nRevise seu código de barra e tente novamente.");
                        checkSpecificProduct();

                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números.\n");
                    checkSpecificProduct();
                }

                System.out.println("\n-------------------------------------------------------" + "\nProduto com código " + codigo + ":");

                System.out.println("\nDescrição: " + produtos.get(indice).getNome()
                        //                        + "\nQuantidade: " + produtos.get(indice).getQtd()
                        + "\nNúmero Código de Barra: " + produtos.get(indice).getCodigoDeBarra()
                        //                        + "\nCotação: " + Application.formatDoubleReal(produtos.get(indice).getCotacao())
                        + "\nÍndice na lista: " + produtos.indexOf(produtos.get(indice)) + "\n-------------------------------------------------------");
                codigo = 0;
                indice = 0;

                while (inputChoiceInt == 2) {

                    System.out.println("\nChecar mais produtos?");
                    System.out.println("[1] Sim.\n"
                            + "[2] Não.");

                    int n1 = input.nextInt();
                    if (n1 == 1) {

                        try {
                            System.out.println("Número de código de barra do produto ↓");

                            int inputIntCodigo = input.nextInt();
                            for (Produto p : produtos) {
                                if (p.getCodigoDeBarra() == inputIntCodigo) {
                                    codigo = inputIntCodigo;
                                    indice = produtos.indexOf(p);
                                    break;
                                }
                            }
                            if (codigo == 0) {
                                System.out.println("ERRO: Este número de código de barra não existe no sistema.\nRevise seu código de barra e tente novamente.");
                                checkSpecificProduct();

                            }

                        } catch (InputMismatchException err) {
                            System.out.println("ERRO: Esta entrada só aceita números.\n");
                            checkSpecificProduct();
                        }

                        System.out.println("\n-------------------------------------------------------" + "\nProduto com código " + codigo + ":");

                        System.out.println("\nDescrição: " + produtos.get(indice).getNome()
                                //                                + "\nQuantidade: " + produtos.get(indice).getQtd()
                                + "\nNúmero Código de Barra: " + produtos.get(indice).getCodigoDeBarra()
                                //                                + "\nCotação: " + Application.formatDoubleReal(produtos.get(indice).getCotacao())
                                + "\nÍndice na lista: " + produtos.indexOf(produtos.get(indice)) + "\n-------------------------------------------------------");
                        codigo = 0;
                        indice = 0;

                    }
                    if (n1 == 2) {
                        br.edu.infnet.Application.main(new String[0]);
                        break;
                    }

                }

            } else {
                System.out.println("ERRO: Digite uma opção válida.");
                checkSpecificProduct();
            }

        } catch (InputMismatchException err) {
            System.out.println("ERRO: Esta entrada só aceita números.\n");
            checkSpecificProduct();
        }

    }

    public static void checkAllProducts() {

        System.out.println("\n~CONSULTA DE TODOS OS PRODUTOS~");

        for (Produto p : produtos) {
            System.out.println("\nDescrição: " + p.getNome()
                    //                    + "\nQuantidade: " + p.getQtd()
                    + "\nNúmero Código de Barra: " + p.getCodigoDeBarra()
                    //                    + "\nCotação: " + Application.formatDoubleReal(p.getCotacao())
                    + "\nÍndice na lista: " + produtos.indexOf(p));
        }

        br.edu.infnet.Application.main(new String[0]);
    }

    public static void quotationRegister() {
        int indexOfLastProduct = (produtos.size()) - 1;

        System.out.println("\n~CADASTRO E ATUALIZAÇÃO DE COTAÇÕES DE PRODUTOS~");

        System.out.println("\nEscolha um dos fornecedores ↓\n");

        for (Fornecedor f : fornecedores) {
            System.out.println("[" + fornecedores.indexOf(f) + "] " + f.getNome());

        }
        Scanner input = new Scanner(System.in);

        try {

            int inputChoiceInt = input.nextInt();
            //Mundial
            if (inputChoiceInt == 0) {
                for (Produto p : produtos) {
                    System.out.println("[" + produtos.indexOf(p) + "] " + p.getNome());
                }

                try {

                    int inputIntIndiceCodigo = input.nextInt();
                    indice = inputIntIndiceCodigo;

                    if (indice < -1 || indice > indexOfLastProduct) {
                        System.out.println("ERRO: O index " + indice + " não existe na lista de produtos.\nTente índices entre 0 e " + indexOfLastProduct + ".\n");
                        quotationRegister();
                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números.\n");
                    quotationRegister();
                }

                try {
                    System.out.println("Quantidade de itens (Exemplo: 2) ↓");
                    int inputQtdInt = input.nextInt();

                    qtd = inputQtdInt;

                    //Catch error when its not a int
                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita itens do tipo inteiro.");
                    quotationRegister();
                }

//        
                System.out.println("Cotação do produto (em R$, Exemplo: 2,59) ↓");

                try {
                    double inputQtdDouble = input.nextDouble();

                    cotacao = inputQtdDouble;

                    //Catch error when its not a double
                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Utilize vírgula e valores decimais válidos.");
                    quotationRegister();
                }

                Produto produto = new Produto(produtos.get(indice).getNome(), produtos.get(indice).getCodigoDeBarra());
                Cotacao cotacao = new Cotacao(Service.cotacao, qtd);
                Fornecedor fornecedor = fornecedores.get(0);

                ProdutoCotacaoEFornecedor PCF = new ProdutoCotacaoEFornecedor(produto, cotacao, fornecedor);

                for (ProdutoCotacaoEFornecedor pcf : produtosECotacoesEFornecedores) {
                    if (PCF.getCodigoDeBarra() == pcf.getCodigoDeBarra() && PCF.getFornecedorNome() == pcf.getFornecedorNome()) {
                        produtosECotacoesEFornecedores.set(produtosECotacoesEFornecedores.indexOf(pcf), pcf);

                        System.out.println("A cotação e quantidade deste produto foram atualizados neste fornecedor. Os dados ficaram assim:\n"
                                + "\nDescrição: " + PCF.getNome()
                                + "\nNúmero Código de Barra: " + PCF.getCodigoDeBarra()
                                + "\nQuantidade: " + PCF.getQtd()
                                + "\nCotação: " + Application.formatDoubleReal(PCF.getCotacao() * PCF.getQtd()) + " (" + Application.formatDoubleReal(PCF.getCotacao()) + " a unidade)"
                                + "\nFornecedor: " + PCF.getFornecedorNome() + " (" + PCF.getFornecedorAtividade() + ")"
                                //+ "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(produtosECotacoesEFornecedores.get(indice)) 
                                + "\n-------------------------------------------------------");

                        br.edu.infnet.Application.main(new String[0]);
                    }
                }

                produtosECotacoesEFornecedores.add(PCF);

                System.out.println("A cotação e quantidade deste produto foram adicionados neste fornecedor. Os dados ficaram assim:\n"
                        + "\nDescrição: " + PCF.getNome()
                        + "\nNúmero Código de Barra: " + PCF.getCodigoDeBarra()
                        + "\nQuantidade: " + PCF.getQtd()
                        + "\nCotação: " + Application.formatDoubleReal(PCF.getCotacao() * PCF.getQtd()) + " (" + Application.formatDoubleReal(PCF.getCotacao()) + " a unidade)"
                        + "\nFornecedor: " + PCF.getFornecedorNome() + " (" + PCF.getFornecedorAtividade() + ")"
                        //+ "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(produtosECotacoesEFornecedores.get(indice)) 
                        + "\n-------------------------------------------------------");

                br.edu.infnet.Application.main(new String[0]);

                //Guanabara
            } else if (inputChoiceInt == 1) {
                for (Produto p : produtos) {
                    System.out.println("[" + produtos.indexOf(p) + "] " + p.getNome());
                }

                try {

                    int inputIntIndiceCodigo = input.nextInt();
                    indice = inputIntIndiceCodigo;

                    if (indice < -1 || indice > indexOfLastProduct) {
                        System.out.println("ERRO: O index " + indice + " não existe na lista de produtos.\nTente índices entre 0 e " + indexOfLastProduct + ".\n");
                        quotationRegister();
                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números.\n");
                    quotationRegister();
                }

                try {
                    System.out.println("Quantidade de itens (Exemplo: 2) ↓");
                    int inputQtdInt = input.nextInt();

                    qtd = inputQtdInt;

                    //Catch error when its not a int
                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita itens do tipo inteiro.");
                    quotationRegister();
                }

//        
                System.out.println("Cotação do produto (em R$, Exemplo: 2,59) ↓");

                try {
                    double inputQtdDouble = input.nextDouble();

                    cotacao = inputQtdDouble;

                    //Catch error when its not a double
                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Utilize vírgula e valores decimais válidos.");
                    quotationRegister();
                }

                Produto produto = new Produto(produtos.get(indice).getNome(), produtos.get(indice).getCodigoDeBarra());
                Cotacao cotacao = new Cotacao(Service.cotacao, qtd);
                Fornecedor fornecedor = fornecedores.get(1);

                ProdutoCotacaoEFornecedor PCF = new ProdutoCotacaoEFornecedor(produto, cotacao, fornecedor);

                for (ProdutoCotacaoEFornecedor pcf : produtosECotacoesEFornecedores) {
                    if (PCF.getCodigoDeBarra() == pcf.getCodigoDeBarra() && PCF.getFornecedorNome() == pcf.getFornecedorNome()) {
                        produtosECotacoesEFornecedores.set(produtosECotacoesEFornecedores.indexOf(pcf), pcf);

                        System.out.println("A cotação e quantidade deste produto foram atualizados neste fornecedor. Os dados ficaram assim:\n"
                                + "\nDescrição: " + PCF.getNome()
                                + "\nNúmero Código de Barra: " + PCF.getCodigoDeBarra()
                                + "\nQuantidade: " + PCF.getQtd()
                                + "\nCotação: " + Application.formatDoubleReal(PCF.getCotacao() * PCF.getQtd()) + " (" + Application.formatDoubleReal(PCF.getCotacao()) + " a unidade)"
                                + "\nFornecedor: " + PCF.getFornecedorNome() + " (" + PCF.getFornecedorAtividade() + ")"
                                //+ "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(produtosECotacoesEFornecedores.get(indice)) 
                                + "\n-------------------------------------------------------");

                        br.edu.infnet.Application.main(new String[0]);
                    }
                }

                produtosECotacoesEFornecedores.add(PCF);

                System.out.println("A cotação e quantidade deste produto foram adicionados neste fornecedor. Os dados ficaram assim:\n"
                        + "\nDescrição: " + PCF.getNome()
                        + "\nNúmero Código de Barra: " + PCF.getCodigoDeBarra()
                        + "\nQuantidade: " + PCF.getQtd()
                        + "\nCotação: " + Application.formatDoubleReal(PCF.getCotacao() * PCF.getQtd()) + " (" + Application.formatDoubleReal(PCF.getCotacao()) + " a unidade)"
                        + "\nFornecedor: " + PCF.getFornecedorNome() + " (" + PCF.getFornecedorAtividade() + ")"
                        //+ "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(produtosECotacoesEFornecedores.get(indice)) 
                        + "\n-------------------------------------------------------");

                br.edu.infnet.Application.main(new String[0]);

            } else if (inputChoiceInt == 2) {

                for (Produto p : produtos) {
                    System.out.println("[" + produtos.indexOf(p) + "] " + p.getNome());
                }

                try {

                    int inputIntIndiceCodigo = input.nextInt();
                    indice = inputIntIndiceCodigo;

                    if (indice < -1 || indice > indexOfLastProduct) {
                        System.out.println("ERRO: O index " + indice + " não existe na lista de produtos.\nTente índices entre 0 e " + indexOfLastProduct + ".\n");
                        quotationRegister();
                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números.\n");
                    quotationRegister();
                }

                try {
                    System.out.println("Quantidade de itens (Exemplo: 2) ↓");
                    int inputQtdInt = input.nextInt();

                    qtd = inputQtdInt;

                    //Catch error when its not a int
                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita itens do tipo inteiro.");
                    quotationRegister();
                }

//        
                System.out.println("Cotação do produto (em R$, Exemplo: 2,59) ↓");

                try {
                    double inputQtdDouble = input.nextDouble();

                    cotacao = inputQtdDouble;

                    //Catch error when its not a double
                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Utilize vírgula e valores decimais válidos.");
                    quotationRegister();
                }

                Produto produto = new Produto(produtos.get(indice).getNome(), produtos.get(indice).getCodigoDeBarra());
                Cotacao cotacao = new Cotacao(Service.cotacao, qtd);
                Fornecedor fornecedor = fornecedores.get(2);

                ProdutoCotacaoEFornecedor PCF = new ProdutoCotacaoEFornecedor(produto, cotacao, fornecedor);

                for (ProdutoCotacaoEFornecedor pcf : produtosECotacoesEFornecedores) {
                    if (PCF.getCodigoDeBarra() == pcf.getCodigoDeBarra() && PCF.getFornecedorNome() == pcf.getFornecedorNome()) {
                        produtosECotacoesEFornecedores.set(produtosECotacoesEFornecedores.indexOf(pcf), pcf);

                        System.out.println("A cotação e quantidade deste produto foram atualizados neste fornecedor. Os dados ficaram assim:\n"
                                + "\nDescrição: " + PCF.getNome()
                                + "\nNúmero Código de Barra: " + PCF.getCodigoDeBarra()
                                + "\nQuantidade: " + PCF.getQtd()
                                + "\nCotação: " + Application.formatDoubleReal(PCF.getCotacao() * PCF.getQtd()) + " (" + Application.formatDoubleReal(PCF.getCotacao()) + " a unidade)"
                                + "\nFornecedor: " + PCF.getFornecedorNome() + " (" + PCF.getFornecedorAtividade() + ")"
                                //+ "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(produtosECotacoesEFornecedores.get(indice)) 
                                + "\n-------------------------------------------------------");

                        br.edu.infnet.Application.main(new String[0]);
                    }
                }

                produtosECotacoesEFornecedores.add(PCF);

                System.out.println("A cotação e quantidade deste produto foram adicionados neste fornecedor. Os dados ficaram assim:\n"
                        + "\nDescrição: " + PCF.getNome()
                        + "\nNúmero Código de Barra: " + PCF.getCodigoDeBarra()
                        + "\nQuantidade: " + PCF.getQtd()
                        + "\nCotação: " + Application.formatDoubleReal(PCF.getCotacao() * PCF.getQtd()) + " (" + Application.formatDoubleReal(PCF.getCotacao()) + " a unidade)"
                        + "\nFornecedor: " + PCF.getFornecedorNome() + " (" + PCF.getFornecedorAtividade() + ")"
                        //+ "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(produtosECotacoesEFornecedores.get(indice)) 
                        + "\n-------------------------------------------------------");

                br.edu.infnet.Application.main(new String[0]);

            } else {
                System.out.println("ERRO: Digite uma opção válida.");
                quotationRegister();
            }

        } catch (InputMismatchException err) {
            System.out.println("ERRO: Esta entrada só aceita números.\n");
            quotationRegister();
        }

    }

    public static void quotationDelete() {

        ArrayList<Integer> avaiableIndex = new ArrayList<Integer>();

        System.out.println("\n~REMOÇÃO DE COTAÇÕES DE PRODUTOS~");

        System.out.println("\nEscolha um dos fornecedores ↓\n");

        for (Fornecedor f : fornecedores) {
            System.out.println("[" + fornecedores.indexOf(f) + "] " + f.getNome());

        }
        Scanner input = new Scanner(System.in);

        try {

            int inputChoiceInt = input.nextInt();
            //Mundial
            if (inputChoiceInt == 0) {
                for (ProdutoCotacaoEFornecedor pcf : produtosECotacoesEFornecedores) {
                    if (pcf.getFornecedorNome().equals("Supermercado Mundial")) {

                        System.out.println("\nDescrição: " + pcf.getNome()
                                + "\nNúmero Código de Barra: " + pcf.getCodigoDeBarra()
                                + "\nQuantidade: " + pcf.getQtd()
                                + "\nCotação: " + Application.formatDoubleReal(pcf.getCotacao() * pcf.getQtd()) + " (" + Application.formatDoubleReal(pcf.getCotacao()) + " a unidade)"
                                + "\nFornecedor: " + pcf.getFornecedorNome() + " (" + pcf.getFornecedorAtividade() + ")"
                                + "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(pcf)
                                + "\n-------------------------------------------------------");

                        avaiableIndex.add(produtosECotacoesEFornecedores.indexOf(pcf));
                    }
                }

                if (avaiableIndex.isEmpty()) {
                    System.out.println("Não existem cotações/quantidades a serem deletados para este Fornecedor.");
                    br.edu.infnet.Application.main(new String[0]);

                }

                System.out.println("\nÍndice na lista da cotação/quantidade a ser deletado (Disponíveis: " + avaiableIndex + ")  ↓");

                try {

                    int inputIntIndiceCodigo = input.nextInt();
                    indice = inputIntIndiceCodigo;

                    if (indice < -1) {
                        System.out.println("ERRO: O index inputado," + indice + " não pode ser negativo.\n");
                        quotationDelete();
                    } else if (avaiableIndex.contains(indice)) {

                        produtosECotacoesEFornecedores.remove(indice);
                        avaiableIndex.remove(Integer.valueOf(indice));

                        System.out.println("A cotação/quantidade com índice " + indice + " foi deletado com sucesso.");
                        br.edu.infnet.Application.main(new String[0]);
                    } //provavelmente nunca vai cair aqui
                    else {
                        System.out.println("Este índice não existe nessa lista. Nada alterado.");
                        br.edu.infnet.Application.main(new String[0]);

                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números.\n");
                    quotationDelete();
                }

                //Guanabara
            } else if (inputChoiceInt == 1) {
                for (ProdutoCotacaoEFornecedor pcf : produtosECotacoesEFornecedores) {
                    if (pcf.getFornecedorNome().equals("Supermercado Guanabara")) {

                        System.out.println("\nDescrição: " + pcf.getNome()
                                + "\nNúmero Código de Barra: " + pcf.getCodigoDeBarra()
                                + "\nQuantidade: " + pcf.getQtd()
                                + "\nCotação: " + Application.formatDoubleReal(pcf.getCotacao() * pcf.getQtd()) + " (" + Application.formatDoubleReal(pcf.getCotacao()) + " a unidade)"
                                + "\nFornecedor: " + pcf.getFornecedorNome() + " (" + pcf.getFornecedorAtividade() + ")"
                                + "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(pcf)
                                + "\n-------------------------------------------------------");

                        avaiableIndex.add(produtosECotacoesEFornecedores.indexOf(pcf));
                    }
                }

                if (avaiableIndex.isEmpty()) {
                    System.out.println("Não existem cotações/quantidades a serem deletados para este Fornecedor.");
                    br.edu.infnet.Application.main(new String[0]);

                }

                System.out.println("\nÍndice na lista da cotação/quantidade a ser deletado (Disponíveis: " + avaiableIndex + ")  ↓");

                try {

                    int inputIntIndiceCodigo = input.nextInt();
                    indice = inputIntIndiceCodigo;

                    if (indice < -1) {
                        System.out.println("ERRO: O index inputado," + indice + " não pode ser negativo.\n");
                        quotationDelete();
                    } else if (avaiableIndex.contains(indice)) {

                        produtosECotacoesEFornecedores.remove(indice);
                        avaiableIndex.remove(Integer.valueOf(indice));

                        System.out.println("A cotação/quantidade com índice " + indice + " foi deletado com sucesso.");
                        br.edu.infnet.Application.main(new String[0]);
                    } //provavelmente nunca vai cair aqui
                    else {
                        System.out.println("Este índice não existe nessa lista. Nada alterado.");
                        br.edu.infnet.Application.main(new String[0]);

                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números.\n");
                    quotationDelete();
                }

            } else if (inputChoiceInt == 2) {
                for (ProdutoCotacaoEFornecedor pcf : produtosECotacoesEFornecedores) {
                    if (pcf.getFornecedorNome().equals("Supermercado Campeão")) {

                        System.out.println("\nDescrição: " + pcf.getNome()
                                + "\nNúmero Código de Barra: " + pcf.getCodigoDeBarra()
                                + "\nQuantidade: " + pcf.getQtd()
                                + "\nCotação: " + Application.formatDoubleReal(pcf.getCotacao() * pcf.getQtd()) + " (" + Application.formatDoubleReal(pcf.getCotacao()) + " a unidade)"
                                + "\nFornecedor: " + pcf.getFornecedorNome() + " (" + pcf.getFornecedorAtividade() + ")"
                                + "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(pcf)
                                + "\n-------------------------------------------------------");

                        avaiableIndex.add(produtosECotacoesEFornecedores.indexOf(pcf));
                    }
                }

                if (avaiableIndex.isEmpty()) {
                    System.out.println("Não existem cotações/quantidades a serem deletados para este Fornecedor.");
                    br.edu.infnet.Application.main(new String[0]);

                }

                System.out.println("\nÍndice na lista da cotação/quantidade a ser deletado (Disponíveis: " + avaiableIndex + ")  ↓");

                try {

                    int inputIntIndiceCodigo = input.nextInt();
                    indice = inputIntIndiceCodigo;

                    if (indice < -1) {
                        System.out.println("ERRO: O index inputado," + indice + " não pode ser negativo.\n");
                        quotationDelete();
                    } else if (avaiableIndex.contains(indice)) {

                        produtosECotacoesEFornecedores.remove(indice);
                        avaiableIndex.remove(Integer.valueOf(indice));

                        System.out.println("A cotação/quantidade com índice " + indice + " foi deletado com sucesso.");
                        br.edu.infnet.Application.main(new String[0]);
                    } //provavelmente nunca vai cair aqui
                    else {
                        System.out.println("Este índice não existe nessa lista. Nada alterado.");
                        br.edu.infnet.Application.main(new String[0]);

                    }

                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Esta entrada só aceita números.\n");
                    quotationDelete();
                }

            } else {
                System.out.println("ERRO: Digite uma opção válida.");
                quotationDelete();
            }

        } catch (InputMismatchException err) {
            System.out.println("ERRO: Esta entrada só aceita números.\n");
            quotationDelete();
        }
    }

    public static void quotationList() {

        ArrayList<Integer> avaiableIndex = new ArrayList<Integer>();

        System.out.println("\n~LISTAGEM DE COTAÇÕES E PRODUTOS~");

        System.out.println("[1] Listagem por produto.\n"
                + "[2] Listagem por fornecedor.\n"
                + "[3] Listagem de produtos de mesma cotação."
        );

        Scanner input = new Scanner(System.in);

        try {

            int inputChoiceInt = input.nextInt();
            //Listagem por produto
            if (inputChoiceInt == 1) {

                System.out.printf("%-40s %-20s %-20s %-20s", "Nome do produto:", "Preço (Mundial):", "Preço (Guanabara):", "Preço (Campeão):");
                System.out.println("\n");

                String nomeP = "";
                String cotacaoMundial = "N/D";
                String cotacaoGuanabara = "N/D";
                String cotacaoCampeao = "N/D";

                for (Produto p : produtos) {
                    nomeP = p.getNome();

                    for (ProdutoCotacaoEFornecedor pcf : produtosECotacoesEFornecedores) {
                        if (pcf.getFornecedorNome().equals("Supermercado Mundial")) {

                            if (p.getCodigoDeBarra() == pcf.getCodigoDeBarra()) {
                                cotacaoMundial = Double.toString(pcf.getCotacao());
                            }

                        } else if (pcf.getFornecedorNome().equals("Supermercado Guanabara")) {

                            if (p.getCodigoDeBarra() == pcf.getCodigoDeBarra()) {
                                cotacaoGuanabara = Double.toString(pcf.getCotacao());
                            }

                        } else if (pcf.getFornecedorNome().equals("Supermercado Campeão")) {

                            if (p.getCodigoDeBarra() == pcf.getCodigoDeBarra()) {
                                cotacaoCampeao = Double.toString(pcf.getCotacao());
                            }

                        }
                    }

                    if (cotacaoMundial != "N/D") {

                        String cotacaoMundialFormatted = formatDoubleReal(Double.parseDouble(cotacaoMundial));
                        cotacaoMundial = cotacaoMundialFormatted;
                    }
                    if (cotacaoGuanabara != "N/D") {

                        String cotacaoGuanabaraFormatted = formatDoubleReal(Double.parseDouble(cotacaoGuanabara));
                        cotacaoGuanabara = cotacaoGuanabaraFormatted;
                    }
                    if (cotacaoCampeao != "N/D") {

                        String cotacaoCampeaoFormatted = formatDoubleReal(Double.parseDouble(cotacaoCampeao));
                        cotacaoCampeao = cotacaoCampeaoFormatted;
                    }

                    System.out.printf("%-40s %-20s %-20s %-20s \n", nomeP, cotacaoMundial, cotacaoGuanabara, cotacaoCampeao);
                    cotacaoMundial = "N/D";
                    cotacaoGuanabara = "N/D";
                    cotacaoCampeao = "N/D";
                }
                br.edu.infnet.Application.main(new String[0]);

            } //Listagem por fornecedor   
            else if (inputChoiceInt == 2) {

                System.out.println("\nProdutos no Supermercado Mundial:" + "\n-------------------------------------------------------");
                for (ProdutoCotacaoEFornecedor pcf : produtosECotacoesEFornecedores) {
                    if (pcf.getFornecedorNome().equals("Supermercado Mundial")) {

                        System.out.println("\nDescrição: " + pcf.getNome()
                                + "\nNúmero Código de Barra: " + pcf.getCodigoDeBarra()
                                + "\nQuantidade: " + pcf.getQtd()
                                + "\nCotação: " + Application.formatDoubleReal(pcf.getCotacao() * pcf.getQtd()) + " (" + Application.formatDoubleReal(pcf.getCotacao()) + " a unidade)"
                                + "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(pcf));
                    }
                }

                System.out.println("\nProdutos no Supermercado Guanabara:" + "\n-------------------------------------------------------");
                for (ProdutoCotacaoEFornecedor pcf : produtosECotacoesEFornecedores) {
                    if (pcf.getFornecedorNome().equals("Supermercado Guanabara")) {

                        System.out.println("\nDescrição: " + pcf.getNome()
                                + "\nNúmero Código de Barra: " + pcf.getCodigoDeBarra()
                                + "\nQuantidade: " + pcf.getQtd()
                                + "\nCotação: " + Application.formatDoubleReal(pcf.getCotacao() * pcf.getQtd()) + " (" + Application.formatDoubleReal(pcf.getCotacao()) + " a unidade)"
                                + "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(pcf));
                    }
                }

                System.out.println("\nProdutos no Supermercado Campeão:" + "\n-------------------------------------------------------");
                for (ProdutoCotacaoEFornecedor pcf : produtosECotacoesEFornecedores) {
                    if (pcf.getFornecedorNome().equals("Supermercado Campeão")) {

                        System.out.println("\nDescrição: " + pcf.getNome()
                                + "\nNúmero Código de Barra: " + pcf.getCodigoDeBarra()
                                + "\nQuantidade: " + pcf.getQtd()
                                + "\nCotação: " + Application.formatDoubleReal(pcf.getCotacao() * pcf.getQtd()) + " (" + Application.formatDoubleReal(pcf.getCotacao()) + " a unidade)"
                                + "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(pcf));
                    }
                }

                br.edu.infnet.Application.main(new String[0]);

            } //Listagem de produtos de mesma cotação 
            else if (inputChoiceInt == 3) {

                System.out.println("Cotação do produto (em R$, Exemplo: 8,99) ↓");

                boolean validNumber = false;

                try {
                    double inputQtdDouble = input.nextDouble();

                    //cotacao = inputQtdDouble;
                    for (ProdutoCotacaoEFornecedor pcf : produtosECotacoesEFornecedores) {
                    if (pcf.getCotacao() == inputQtdDouble) {
                        indice = produtos.indexOf(pcf);
                        validNumber = true;

                        System.out.println("\nDescrição: " + pcf.getNome()
                                + "\nNúmero Código de Barra: " + pcf.getCodigoDeBarra()
                                + "\nQuantidade: " + pcf.getQtd()
                                + "\nCotação: " + Application.formatDoubleReal(pcf.getCotacao() * pcf.getQtd()) + " (" + Application.formatDoubleReal(pcf.getCotacao()) + " a unidade)"
                                + "\nFornecedor: " + pcf.getFornecedorNome() + " (" + pcf.getFornecedorAtividade() + ")"
                                + "\nÍndice na lista: " + produtosECotacoesEFornecedores.indexOf(pcf));
                    }
                }

                    if (validNumber == false) {
                        System.out.println("ERRO: Não existem produtos com essa cotação.");
                    }

                    br.edu.infnet.Application.main(new String[0]);

                    //Catch error when its not a double
                } catch (InputMismatchException err) {
                    System.out.println("ERRO: Utilize vírgula e valores decimais válidos.");
                    quotationList();
                }

            } else {
                System.out.println("ERRO: Digite uma opção válida.");
                quotationList();
            }

        } catch (InputMismatchException err) {
            System.out.println("ERRO: Esta entrada só aceita números.\n");
            quotationList();
        }
    }
}
