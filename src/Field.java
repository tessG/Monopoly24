
public class Field  {
    private String label;
    private int ID;
    private int cost;
    private int income;
    private String option;

    public Field (  int ID, String label, int cost, int income){
        this.label = label;
        this.ID = ID;
        this.cost = cost;
        this.income = income;
    }

    @Override
    public String toString() {
        return ID + label;
    }

    public String onLand(Player p){
        String s = p.getName() + " er landet på " + this;
        return s;
    }

    public String processResponse(Player p){
        return null;
    }

    protected String onAccept(Player p){
        p.pay(cost);
        String s = "Det er sket";
        return s;
    }

    protected String onReject(Player p){
        int s = p.account.getbalance() * 0.1;
        p.pay(s);
        String msg = "10 procent af din saldo beregnet";
        return msg;


    }
}
