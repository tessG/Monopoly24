public class Account {

    private int balance;

    public void withdraw(int amount){
        this.balance -= amount;

    }
    public void deposit(int amount){
        this.balance += amount;

    }

    public int getBalance() {
        return balance;
    }

}
