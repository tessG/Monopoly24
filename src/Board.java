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
            //int whatIsTessSmoking = Integer.parseInt(row[5]);
            Field f = new Field(id,label,cost,income);
            fields[i] = f;
        }
    }

    public Field getField(int id){
//handeling the off-by one error by substracting 1
        return fields[id-1];
    }
}
