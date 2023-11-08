public class Account {

    private int balance;


    public void deposit(int amount){
        this.balance += amount;

    }

    public void withdraw(int amount){

    }

    public int getBalance() {
        return this.balance;
    }
}
