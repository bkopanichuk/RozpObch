package oop.lab4.Task2;

import java.util.concurrent.locks.ReadWriteLock;

public class GardenerTread extends Thread {
    ReadWriteLock rwLock;
    Garden garden;
    GardenerTread(ReadWriteLock rwLock, Garden garden){
        this.rwLock = rwLock;
        this.garden = garden;
    }
    @Override
    public void run() {
        while (true) {
        rwLock.writeLock().lock();
        garden.gardener();
        rwLock.writeLock().unlock();
        }
    }
}
