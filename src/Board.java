public class Board {
    private Field[] fields;
    private String[] data;

    public Board(String[] data){
        this.data = data;
        fields = new Field[40];
        createFields(data);
    }

    private void createFields(String[] data){
        for (int i = 0; i < fields.length; i++) {
            String[] row = data[i].split(",");
            int id = Integer.parseInt(row[0]);
            String option = row[1];
            String label = row[2];
            int cost = Integer.parseInt(row[3].trim());
            int income = Integer.parseInt(row[4].trim());
            int serieID = Integer.parseInt(row[5]);
            Field f = null;
            switch (Fieldtype) {
                //case "Start": f = new Start(id, label, income, cost);
                    //break;
                case "Plot": f = new Plot(id, label, income, cost, serieID);
                break;
                //case "Chance": f = new Chance (id, label, income, cost);
                //break;
                //case "Tax": f = new Tax(id, label, income, cost);
                //break;
                case "Brewery": f = new Brewery(id, label, income, cost, serieID) ;
                break;
                case "ShippingLine": f = new ShippingLine(id, label, income, cost, serieID);
                break;
                //case "Parkering": f = new Parking(id, label, income, cost);
                //break;
                default: f = new Field(id,label,cost,income);
                break;
            }
            fields[i] = f;
        }
    }

    public Field getField(int id){
//handeling the off-by one error by substracting 1
        return fields[id-1];
    }
}
