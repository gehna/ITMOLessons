import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Bank {
    private final ConcurrentMap<Long, Account> accMap = new ConcurrentHashMap<>();

    public Account createAccount(long userId) {
        Account newAccount = new Account(userId);
        accMap.put(userId, newAccount);
        return newAccount;
    }

    private double getAmount(long accId) {
        return accMap.get(accId).getAmount();
    }

    private void changeAmount(long accId, double amount) throws RuntimeException {
        if (accMap.get(accId).isBlocked()) {
            throw new RuntimeException("Change amount fails. The account is blocked");
        }
        if (amount > 0) {
            accMap.get(accId).setAmount(getAmount(accId) + amount);
        } else if (getAmount(accId) - amount < 0) {
            throw new RuntimeException("Change amount fails. Not enough money");
        } else if (getAmount(accId) - amount >= 0) {
            accMap.get(accId).setAmount(getAmount(accId) + amount);
        }
    }

    public void transferMoney(long srcAccId, long dstAccId, double amount) throws RuntimeException {
        if (accMap.get(srcAccId).isBlocked() || accMap.get(dstAccId).isBlocked()) {
            throw new RuntimeException("Transfer money fails. One of the accounts is blocked");
        }
        if (accMap.get(srcAccId).getAmount() < amount) {
            throw new RuntimeException("Transfer money fails. Not enough money to send");
        }

        synchronized (this) {
            changeAmount(srcAccId, -amount);
            changeAmount(dstAccId, amount);
        }

    }
}
