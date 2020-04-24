package oop.lab4.Task2;

import java.util.concurrent.locks.ReadWriteLock;

public class NatureTread extends Thread {
    ReadWriteLock rwLock;
    Garden garden;
    NatureTread(ReadWriteLock rwLock, Garden garden){
        this.rwLock = rwLock;
        this.garden = garden;
    }
    @Override
    public void run(){
        while(true) {
            rwLock.writeLock().lock();
            garden.nature();
            rwLock.writeLock().unlock();
        }
    }
}
