public class Property extends Field {
    private final int serieID;
    protected Player owner;

    public Property(int ID, String label, int cost, int income, int serieID) {
        super(ID, label, cost, income);
        this.serieID = serieID;
    }

    @Override
    public String toString() {
        return super.toString() + serieID;
    }

    @Override
    public String onLand(Player p) {
        String msg = super.onLand(p);

        if (owner == null) {
            option = "buy";
            msg += "Vil du købe? (Y/N)";
            return msg;
        } else {
            option = "payRent";
            msg += "Du skal betale " + income + ". Tast Y for at acceptere:";
            return msg;
        }
    }

    @Override
    protected String onAccept(Player p) {
        if (option.equalsIgnoreCase("buy")) {
            p.buyProperty(cost);
            owner = p;
        } else if (option.equalsIgnoreCase("payRent")) {
            p.pay(income, owner);
        }
        return "";
    }

    @Override
    protected String onReject(Player p) {
        return "";
    }
}
