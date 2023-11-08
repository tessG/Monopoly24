public class Tax extends Field{
    public Tax(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);
    }




    @Override
    protected String onAccept(Player p){
        return "";

    }

    @Override
    protected String onReject(Player p){
        return "";

    }
}