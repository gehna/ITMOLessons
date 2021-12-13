import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Bank extends Thread{
    private ConcurrentMap<Long, Account> accMap = new ConcurrentHashMap<>();
    public Account createAccount(long userId){
        Account newAccount = new Account(userId);
        return newAccount;
    }
    public double getAmount(long accId){
        return accMap.get(accId).getAmount();
    }
    public void blockAccount(long accId){
        accMap.get(accId).setBlocked(true);
    }
    public boolean isAccountBlocked(long accId){
        return accMap.get(accId).isBlocked();
    }
    public synchronized void changeAmount(long accId, double amount) throws RuntimeException{
        if (accMap.get(accId).isBlocked()){
            throw new RuntimeException("Change amount fails. The account is blocked");
        }
        if (amount > 0){
            accMap.get(accId).setAmount(getAmount(accId)+amount);
        } else if (getAmount(accId)-amount<0) {
            throw new RuntimeException("Change amount fails. Not enough money");
        } else if (getAmount(accId)-amount>=0){
            accMap.get(accId).setAmount(getAmount(accId)-amount);
        }
        notify();
    }
    public void transferMoney(long srcAccId, long dstAccId, double amount) throws RuntimeException {
        if (accMap.get(srcAccId).isBlocked()||accMap.get(dstAccId).isBlocked()){
            throw new RuntimeException("Transfer money fails. One of the accounts is blocked");
        }
        if (accMap.get(srcAccId).getAmount()<amount){
            throw new RuntimeException("Transfer money fails. Not enough money to send");
        }

        final Object o1 = new Object();
        final Object o2 = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (o1) {
                    changeAmount(srcAccId, -amount);
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (o2) {
                    changeAmount(dstAccId, amount);
                }
            }
        };
        t1.start();
        t2.start();
    }
}
