import java.io.File;
import java.util.ArrayList;

public class CardDeck {
   // String[] carddata;
     int count = 0;

     ArrayList<Card> cards = new ArrayList<>();

    CardDeck(String[] carddata) {
      //carddata = new String[100];
      createCards(carddata);

    }

    public Card getNext() {
         Card c = cards.get(count);
        count++;
        if(count >= cards.size()){
            count=0;
        }
        return c;
    }

    public void createCards (String[] carddata){
        for(int i = 0;i < carddata.length ;i++){
            String[] values = carddata[i].split(",");
            String message = values[0];
            int income = Integer.parseInt(values[1].trim());
            int cost = Integer.parseInt(values[2].trim());
            String event = values[3];
            Card c = new Card(message,income,cost,event);
            cards.add(c);

        }

    }

}
