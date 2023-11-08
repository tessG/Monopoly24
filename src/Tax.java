public class Tax extends Field{
    public Tax(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);
    }

    @Override
    protected String onAccept(Player p){
        p.pay(cost);
        return "Du har betalt " + cost + " i skat";
    }

    @Override
    protected String onReject(Player p){
        int procent10 = (p.getBalance()/100)*10;
        p.pay(procent10);
        return "Du har betalt 10% af din saldo, som er : "+procent10;

    }
    protected String onLand(Player p){
        String s = super.onLand(p);
         s += "\n"+"Vil du betale fast beløb på "+this.cost+"kr? Tast J for ja "+"\n"+"(Ellers trækker vi et beløb der svarer til 10% af dine aktiver)";
        return s;
    }
}