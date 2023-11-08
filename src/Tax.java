public class Tax extends Field{
    public Tax(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);
        this.cost = cost;
    }




    public String onLand(Player p){
        String s = "\n Vil du betale fast beløb på" +this.cost+"Kr? Tast J for ja \n (Ellers trækker vi et beløb, der svarer til 10% af dine aktiver)";
        return s;
    }

    @Override
    protected String onAccept(Player p){
        p.pay(cost,p);

        return "Det er nu sket";

    }

    @Override
    protected String onReject(Player p){
      int rejectCost =  p.getBalance()/10;
        return "Du er nu blevet trukket"+ rejectCost;

    }
}