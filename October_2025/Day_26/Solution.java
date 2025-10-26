class Bank {

    long[] bal;

    public Bank(long[] balance) {
        this.bal = balance;
    }

    private boolean valid(int acc) {
        return acc >= 1 && acc <= bal.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!valid(account1) || !valid(account2)) return false;
        if (bal[account1 - 1] < money) return false;
        bal[account1 - 1] -= money;
        bal[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!valid(account)) return false;
        bal[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!valid(account)) return false;
        if (bal[account - 1] < money) return false;
        bal[account - 1] -= money;
        return true;
    }
} 
