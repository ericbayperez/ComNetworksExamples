import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private int balance = 0;

    ReentrantLock lock = new ReentrantLock();

    public void printBalance(){
        System.out.println("The balance is: " + balance);
    }

    public void deposit(){
        for(int i = 0; i < 1000000; i++){
            lock.lock();
            try {
                balance = balance + 1;
            }
            finally {
                lock.unlock();
            }
        }
    }
}
