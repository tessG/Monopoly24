public class Player {
    String name;
    int balance;

    public Player(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return  name + ": " + balance;
    }

    public void deposit(int amount){
        this.balance += amount;

    }
}
