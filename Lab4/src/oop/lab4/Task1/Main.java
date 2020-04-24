package oop.lab4.Task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock rwLock = new ReadWriteLock();
        PhoneBook phoneBook = new PhoneBook();

        AdderInfo adderInfo1 = new AdderInfo(phoneBook,rwLock, "first", "8734953");
        AdderInfo adderInfo2 = new AdderInfo(phoneBook,rwLock, "second", "4366");
        AdderInfo adderInfo3 = new AdderInfo(phoneBook,rwLock, "third", "43624");
        AdderInfo adderInfo4 = new AdderInfo(phoneBook,rwLock, "forth", "2346");

        DeleterInfo deleterInfo1 = new DeleterInfo(phoneBook, rwLock, 2);
        DeleterInfo deleterInfo2 = new DeleterInfo(phoneBook, rwLock, 3);

        Finder finder1 = new Finder(phoneBook, rwLock, true, "forth");
        Finder finder2 = new Finder(phoneBook, rwLock, true, "tenth");
        Finder finder3 = new Finder(phoneBook, rwLock, false, "4366");

        adderInfo1.start();
        adderInfo2.start();
        adderInfo3.start();
        adderInfo4.start();

        deleterInfo1.start();
        deleterInfo2.start();

        finder1.start();
        finder2.start();
        finder3.start();

        Thread.sleep(100);
        phoneBook.closeWriter();
    }
}
