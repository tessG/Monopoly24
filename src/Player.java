import java.util.ArrayList;

public class Player {
    private String name;
    int balance;

    private Account account;
    private ArrayList<Card> cards;

    private ArrayList<Deed> deeds;

    private int position;

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

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return balance;
    }

    public int getPosition() {
        return position;
    }

    public int updatePosition(int value){
        int newPosition = this.position + value;
        if (newPosition > 40)
        {
            // Field startField = board.getField(1);
            // this.recieve(startField.getIncome());
            newPosition -= 40;
        }
        return newPosition;

    }

    public void buyProperty(int amount){
    }

    public void pay(int amount,Player recipient){
    }
    public void pay(int amount){

    }

    public void collect(int amount){

    }

    public void recieve(int amount){

    }
}

