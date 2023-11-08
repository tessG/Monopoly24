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
        s+= "\n Træk et kort fra bunken: "+ card.getMessage();
        return s;
    }
    public String onAccept(Player p) {
        if (option.equals("payment")) {
            p.pay(cost);
        } else if(option.equals("receive")) {
            p.recieve(cost);
        } else if(option.equals("1")){
            p.updatePosition(40-p.getPosition());
        } else if(option.equals("11")) {
            if(p.getPosition()<11) {
                p.updatePosition(11-p.getPosition());
            } else {
                p.updatePosition(40-p.getPosition()+11);
            }
        } else if(option.equals("40")) {
            p.updatePosition(40-p.getPosition());
        } else if(option.equals("collect")) {
            p.collectFromAll(income);
        }
        return "";
    }
    //
}

