package thread.sync;

public class WithdrawTask implements Runnable {

    private BankAccount account;
    private int amount;

    public WithdrawTask(final BankAccount account, final int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        account.withdraw(amount);
    }
}
