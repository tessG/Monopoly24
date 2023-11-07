
public class Field {
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
        return null;
    }

    protected String onReject(Player p){
        return null;
    }
}
