public class Chance extends Field{
    public Chance(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);
    }




    @Override
    public String onLand(Player p){
        String s = p.getName() + " er landet på " + this;
        return s;
    }
}

