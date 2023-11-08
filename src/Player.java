import java.util.ArrayList;

public class Player {
    private String name;
   private int balance;
   private Account account;
   private ArrayList<Card> cards;

   private ArrayList<Deed> deeds;
   private int position;

    public Player(String name, int balance){
        this.name = name;
        this.balance = balance;
        this.account = new Account();

    }

    @Override
    public String toString() {
        return  name + ": " + balance;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public int updatePosition(int value){
        int newPosition = this.position + value ;
        if(newPosition>40){
            newPosition -= 40;
        }
        return newPosition;
    }

    public void buyProperty(int amount){

    }

    public void pay(int amount, Player recipient){

    }
    public void pay(int amount){

    }

    public void collect(int amount){

    }


    public void recieve(int amount){

    }

    public Account getAccount(){
       return this.account;
    }
}

