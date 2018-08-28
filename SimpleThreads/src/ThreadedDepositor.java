
public class ThreadedDepositor implements Runnable{

    private final BankAccount bankAccount;


    public ThreadedDepositor(BankAccount ba){
        this.bankAccount = ba;
    }

    @Override
    public void run() {
        bankAccount.deposit();
    }
}
