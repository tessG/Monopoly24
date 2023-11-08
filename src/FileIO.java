import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {

       public ArrayList<String> readPlayerData(String path) {
        ArrayList<String> data = new ArrayList<>();
        //instantier File
        File file = new File(path);

        try {
            Scanner scan = new Scanner(file);
            scan.nextLine(); //Skip header
            while (scan.hasNextLine()) {
                String s = scan.nextLine();// Hele linjen vil stå i én string   ==>  "Egon, 200"
                data.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return data;
    }

    public void savePlayerData(ArrayList<Player> players){
     try

    {
        FileWriter writer = new FileWriter("src/data.txt");
        writer.write("Name,Balance" + "\n");
        for (Player c : players) {
            String textTosave = c.getName() + "," + c.getBalance();
            writer.write(textTosave + "\n");//Egon,5200
        }
        writer.close();
    } catch(IOException e)
    {
        System.out.println("noget gik galt ved skrivning til fil");
    }

}
    public String[] readBoardData(String path, int length) {
        int count = 0;
        String[] data = new String[length];
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine(); //Skip header
            while (scan.hasNextLine()) {
                String s = scan.nextLine();// Hele linjen vil stå i én string   ==>  "Egon, 200"
                data[count] = s;
                count++;
            }
        }catch(FileNotFoundException e){
            System.out.println("file not found");
        }
        return data;
    }



    /* String[] length;
   public ArrayList<String> readBoardData(String path, int length) {
        ArrayList<String> boardData = new ArrayList<>();

        File file = new File(path);


        try {
            Scanner scan = new Scanner(file);
            //scan.nextLine(); //Skip header
            while (scan.hasNextLine()) {
                String s = scan.nextLine();// Hele linjen vil stå i én string   ==>  "Egon, 200"
                boardData.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }

        return boardData;

    }*/
}
