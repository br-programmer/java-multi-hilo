/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi.hilo;

import java.util.Random;

/**
 *
 * @author user
 */
public class Cliente {

    int id;
    String nombre;
    double saldo;

    Cliente(int id, String nombre, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    void consultarSaldo(long initialTime) {
        System.out.println("La consulta de " + this.nombre
                + " EMPIEZA EN "
                + (System.currentTimeMillis() - initialTime) / 1000 + " seg \n");

        simularConsult();
        System.out.println("El cliente " + this.nombre + " tiene " + this.saldo + " de saldo");

        System.out.println("La consulta de " + this.nombre
                + " TERMINA EN "
                + (System.currentTimeMillis() - initialTime) / 1000 + " seg\n");
    }

    private void simularConsult() {
        try {
            Random r = new Random();
            int mili = 500 + r.nextInt((3000 + 1) - 500);
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            System.out.println("Error " + e);
            Thread.currentThread().interrupt();
        }
    }
}
