/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dalonsoperez
 */
public class Exercicio6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Caixa obx = new Caixa(0);
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        obx.modificarFondos(true, 5);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercicio6.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        obx.modificarFondos(false, 10);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Exercicio6.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        

        t2.start();
        t1.start();

        
    }
}
