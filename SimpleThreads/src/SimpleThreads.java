public class SimpleThreads {

    public static void main(String[] args) throws InterruptedException {

        BankAccount accountSerial = new BankAccount();

        accountSerial.deposit();
        accountSerial.deposit();
        accountSerial.printBalance();

        BankAccount accountParallel = new BankAccount();

        ThreadedDepositor aliceDepositor = new ThreadedDepositor(accountParallel);
        ThreadedDepositor bobDepositor = new ThreadedDepositor(accountParallel);

        Thread aliceThread = new Thread(aliceDepositor);
        Thread bobThread = new Thread(bobDepositor);

        aliceThread.start();
        bobThread.start();

        aliceThread.join();
        bobThread.join();

        accountParallel.printBalance();

    }
}
