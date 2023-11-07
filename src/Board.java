import java.util.ArrayList;

public class Board {
    private Field[] fields;
    private String[] data;

    private ArrayList<Field> properties = new ArrayList<>();


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
            //int whatIsTessSmoking = Integer.parseInt(row[5]);
            Field f = null;
            switch(f){

                case "Start": f = new Start(ID,label,income,cost);
                    break;

                case "Prison": f = new Prison(ID,label,income,cost);
                    break;

                case "Chance": f = new Chance(ID,label,income,cost);
                    break;

                case "Brewery": f = new Brewery(ID,label,income,cost);
                    break;

                case "Plot": f = new Plot(ID,label,income,cost);
                    break;

                case "ShippingLine": f = new ShippingLine(ID,label,income,cost);
                    break;

                case "Tax": f = new Tax(ID,label,income,cost);
                    break;

                case "Parkering": f = new Parkering(ID,label,income,cost);
                    break;

                default: f = new Field(id,label,cost,income);

            }

            if(f instanceof Property){

                properties.add(f);

            }
        }
    }

    public Field getField(int id){
//handeling the off-by one error by substracting 1
        return fields[id-1];
    }
}
