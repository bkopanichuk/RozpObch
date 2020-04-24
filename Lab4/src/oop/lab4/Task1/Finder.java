package oop.lab4.Task1;

public class Finder extends Thread {
    PhoneBook phoneBook;
    ReadWriteLock rwLock;
    boolean findByName;
    String toFind;
    Finder(PhoneBook phoneBook, ReadWriteLock rwLock, boolean findByName, String toFind){
        this.phoneBook = phoneBook;
        this.rwLock = rwLock;
        this.toFind = toFind;
        this.findByName = findByName;
    }
    @Override
    public void run(){
        try {
            rwLock.lockRead();
            if(findByName){
                phoneBook.findByName(toFind);
            }else{
                phoneBook.findByPhone(toFind);
            }
            rwLock.unlockRead();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
