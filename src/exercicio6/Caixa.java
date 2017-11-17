/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio6;

/**
 *
 * @author dalonsoperez
 */
public class Caixa {

    private int fondos;

    public Caixa(int fondos) {
        this.fondos = fondos;
    }

    public void modificarFondos(boolean ingreso, int cantidad) throws InterruptedException {
        if (ingreso) {
            Thread.sleep(1000);
            fondos += cantidad;
            System.out.println("Ingreso. Fondos = " + fondos + ".\n");
            synchronized (this) {
                if (fondos >= cantidad * 2) {
                    System.out.println("Ingreso necesario realizado.\n");
                    notify();
                }
            } 

        } else {
            Thread.sleep(1000);
            synchronized (this) {
                if (fondos < cantidad) {
                    System.out.println("Esperando...\n");
                    wait();
                }
            }
            fondos -= cantidad;
            System.out.println("Retirada. Fondos = " + fondos + ".\n");
        }
        mostrar();
    }

    private void mostrar() {
        System.out.println("Quedan " + fondos + " fondos.\n\n");
    }
}
