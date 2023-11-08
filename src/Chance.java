public class Chance extends Field{
    public Chance(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);
    }




    @Override
    public String onLand(Player p){
        Card card = Game.cardDeck.getNext();
        String s = super.onLand(p);
        this.cost = card.getIncome();
        this.income = card.getIncome();
        this.option = card.getEvent();
        s += "\n Træk et kort fra bunken: "+card.getMessage();
        return s;
    }

    public String onAccept(Player p) {

        if(option.equalsIgnoreCase("payment")){
            p.pay(cost);
            System.out.println("Du skal betale :"+cost+",-");
        }
        else if(option.equalsIgnoreCase("receive")){
            p.recieve(cost);
            System.out.println("Du modtager :"+cost+",-");
        }
        else if (option.equalsIgnoreCase("1")) {
            p.updatePosition(40-p.getPosition());
        }
        return "";
    }
}
