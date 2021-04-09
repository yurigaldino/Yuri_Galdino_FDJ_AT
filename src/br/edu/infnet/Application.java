/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet;

import br.edu.infnet.support.Menu;
import br.edu.infnet.support.Service;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Yuri Galdino
 */
public class Application {

    static boolean initialData = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (initialData == false) {
            // Take this out and run just when program starts
            br.edu.infnet.support.Service.main(new String[0]);
            initialData = true;
        }

        int choice = Menu.menu();

        //If/Else way
        if (choice == 1) {
            Service.productRegister();
        } else if (choice == 2) {
            Service.productUpdate();
        } else if (choice == 3) {
            Service.productDelete();
        } else if (choice == 4) {
            Service.checkSpecificProduct();
        } else if (choice == 5) {
            Service.checkAllProducts();
        } else if (choice == 6) {
            Service.quotationRegister();
        } else if (choice == 7) {
            Service.quotationDelete();
        } else if (choice == 8) {
            Service.quotationList();
        } else if (choice == 9) {
            System.out.println("\nObrigado por utilizar nosso sistema.\n");
            System.exit(0);
        }
    }

    //Funções auxiliares
    public static String typeOf(Object o) {
        return o.getClass().getSimpleName();
    }

    public static boolean isValid(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c < 'A' || c > 'Z') && (c < 'a' || c > 'z')) {
                return false;
            }
        }
        return true;
    }

    public static String formatDoubleReal(double d) {
        Locale locale = new Locale("pt", "BR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        return numberFormat.format(d);
    }

    public static double randomQuoation(String size) {
        double randomQuotation = 0;

        if (size.equals("s")) {
            randomQuotation = ThreadLocalRandom.current().nextDouble(0, 9);
        } else if (size.equals("m")) {
            randomQuotation = ThreadLocalRandom.current().nextDouble(9, 29);
        } else if (size.equals("b")) {
            randomQuotation = ThreadLocalRandom.current().nextDouble(29, 70);
        }
        return randomQuotation;
    }

}
