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
            String fieldType = row[1].toLowerCase();
            String label = row[2];
            int cost = Integer.parseInt(row[3].trim());
            int income = Integer.parseInt(row[4].trim());
            String serieID =  row[5].trim();
            Field f = null;

            switch (fieldType) {
                case "start":
                    //f = new Start(id, label, cost, income);
                    break;
                case "plot":
                    f = new Plot(id, label, cost, income, Integer.parseInt(serieID));
                    break;
                case "chance":
                    //f = new Chance(id, label, cost, income);
                    break;
                case "tax":
                    //f = new Tax(id, label, cost, income);
                    break;
                case "shippingline":
                    f = new ShippingLine(id, label, cost, income, Integer.parseInt(serieID));
                    break;
                case "parking":
                    //f = new Parking (id,label,cost,income);
                    break;
                case "brewery":
                    f = new Brewery(id, label, cost, income, Integer.parseInt(serieID));
                    break;
                case "prison":
                    //f = new Prison (id, labe cost, income);
                    break;
                default:
                    f = new Field(id, label, cost, income);
            }

            fields[i] = f;
        }
    }
    
    public Field getField(int id){
//handeling the off-by one error by substracting 1
        return fields[id-1];
    }
}
