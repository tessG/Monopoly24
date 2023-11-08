public class Building extends Plot{
    public Building(int ID, String label, int cost, int income, int serieID) {
        super(ID, label, cost, income, serieID);
    }
@Override
    protected String onAccept(Player p){
        return null;
    }
@Override
    protected String onReject(Player p){
        return null;
    }
}
