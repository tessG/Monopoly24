public class Player {
    private String name;
    int balance;

    public Player(String name, int balance, Account account){
        this.name = name;
        this.balance = balance;
        this.account = account;
    }

    @Override
    public String toString() {
        return  name + ": " + balance;
    }

    public void deposit(int amount){
        this.balance += amount;

    }

    public String getName() {
        return this.name;
    }
}
