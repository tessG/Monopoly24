import java.util.Random;

public class Dice {
private final int max=6;
private final int min=1;
public boolean isDouble;
    public int rollDiceSum(){
        int sum=  (int) (Math.random()*(max-min))+min;
        int sum1=  (int) (Math.random()*(max-min))+min;
        int total=sum+sum1;
        if(sum==sum1) {
        isDouble=true;
            System.out.println("samme tal: "+sum+" "+sum1);}
        return total;
    }

}

