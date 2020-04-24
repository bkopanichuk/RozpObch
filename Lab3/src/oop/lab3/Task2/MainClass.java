package oop.lab3.Task2;

import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        Armchair armchair = new Armchair();
        Object queue = new Object();
        Hairdresser hairdresser = new Hairdresser(armchair, queue);
        int numberOfClients = 5;

        LinkedList<Client> clients = new LinkedList<>();
        for (int i = 0; i < numberOfClients; i++) {
            clients.add(new Client(armchair, queue));
        }

        for (int i = 0; i < numberOfClients; i++) {
            try {
                clients.get(i).thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        hairdresser.thread.interrupt();

        System.out.println("\n\nEND OF MAIN\n\n");

    }
}
