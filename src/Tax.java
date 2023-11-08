public class Tax extends Field  {



    public Tax(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);
    }

    @Override
    public String onLand(Player p){
        String s = super.onLand(p);
        s += "\n Vil du betale fast beløb på " +this.cost+ " Tast J fpr at ja \n (ellers trækker vi et beløb der svarer til 10 % af dine aktiver";
        return s;
    }

}
