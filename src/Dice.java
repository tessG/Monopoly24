import java.util.Random;

public class Dice {

    public boolean isDouble = false;

    public int rollDiceSum() {
        Random r = new Random() ;
        int firstDice = r.nextInt(6)+1; //Bound bruges til at liminicere den
        int secondDice = r.nextInt(6)+1;
        if(firstDice == secondDice){
            isDouble = true;
        }
        int sum;
        sum = firstDice + secondDice;
        return sum;
    }
}


