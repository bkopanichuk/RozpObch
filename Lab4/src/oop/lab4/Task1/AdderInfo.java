package oop.lab4.Task1;

public class AdderInfo  extends Thread{
    PhoneBook phoneBook;
    ReadWriteLock rwLock;
    String name;
    String phone;
    AdderInfo(PhoneBook phoneBook, ReadWriteLock rwLock, String name, String phone){
        this.phoneBook = phoneBook;
        this.rwLock = rwLock;
        this.name = name;
        this.phone = phone;
    }
    @Override
    public void run(){
            try {
                rwLock.lockWrite();
                System.out.println("Add info" + name + " " + phone);
                phoneBook.addInfo(name, phone);
                rwLock.unlockWrite();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
