public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        Account accountSrc = bank.createAccount(1);
        Account accountDist = bank.createAccount(2);

        Thread t1 = new Thread(()->{
            accountSrc.setAmount(5000);
            accountDist.setAmount(5000);
            bank.transferMoney(1,2, 1000);
        });

        t1.start();
        t1.join();

        System.out.println(accountSrc.getAmount());
        System.out.println(accountDist.getAmount());
    }
}
