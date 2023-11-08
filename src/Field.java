
public class Field {
    private String label;
    private int ID;
    public int cost;
    public int income;
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

    public String processResponse(String response, Player p){
        String msg = "";
        if(response.equalsIgnoreCase("y")){
            msg = onAccept(p);
        } else if(response.equalsIgnoreCase("n")){
            msg = onReject(p);
        }
        return msg;
    }

    protected String onAccept(Player p){
        return null;
    }

    protected String onReject(Player p){
        return null;
    }


}
