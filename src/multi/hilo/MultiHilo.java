/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multi.hilo;

/**
 *
 * @author user
 */
public class MultiHilo implements Runnable {

    Cliente cliente;
    private long initialTime;

    public MultiHilo(Cliente cliente, long initialTime) {
        this.cliente = cliente;
        this.initialTime = initialTime;
    }

    //3 clientes estan consultando su saldo simultáneamente calcule sus tiempos
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        Cambia los nombres de los clientes
        Cliente jean = new Cliente(1, "Jean", 2000.0);
        Cliente brayan = new Cliente(2, "Brayan", 1300.0);
        Cliente diego = new Cliente(3, "Diego", 4500.0);
        long initialTime = System.currentTimeMillis();
//        Tambien cambia los nombres de las hilos
        Runnable r1 = new MultiHilo(jean, initialTime);
        Runnable r2 = new MultiHilo(brayan, initialTime);
        Runnable r3 = new MultiHilo(diego, initialTime);
        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();
    }

    @Override
    public void run() {
        this.cliente.consultarSaldo(this.initialTime);
    }

}
