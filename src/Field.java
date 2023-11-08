
public class Field {
    private String label;
    private int ID;
    protected int cost;
    protected int income;
    protected String option;

    public Field(int ID, String label, int cost, int income) {
        this.label = label;
        this.ID = ID;
        this.cost = cost;
        this.income = income;
    }

    @Override
    public String toString() {
        return ID + label;
    }

    public String onLand(Player p) {
        String s = p.getName() + " er landet på " + this;
        return s;
    }

    public void processResponse(String response, Player p) {
        if (response.equalsIgnoreCase("Y")) {
            onAccept(p);
        } else if (response.equalsIgnoreCase("N")) {
            onReject(p);
        }
    }

    protected String onAccept(Player p) {
        return null;
    }

    protected String onReject(Player p) {
        return null;
    }
}
