import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    FileIO io = new FileIO();
    int maxPlayers;

    public Game(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setup(){
        //Læse data ind

        ArrayList<String> data = io.readPlayerData("src/data.txt");
        if(data.size()>0) {
            for (String s : data) {
                String[] row = s.split(",");              // s splittes to strings ==>  "Egon", "200"

                String name = row[0];                           // ==> "Egon"
                int balance = Integer.parseInt(row[1].trim());  // Konverterer string til int "200" ==> 200

                Player p = new Player(name, balance); //bruger de indlæste værdier til at konstruere et player objekt (instansiering)
                players.add(p);                       // placerer objektet i listen med kunder
            }
        }else{
            TextUI ui = new TextUI();
            String input = "";
            while(players.size() < 6 ){
                input = ui.getInput("Skriv navn på spiller: ");

                Player p = new Player(input, 30000);
                players.add(p);
            }

        }
        testCode();
    }
    public void endGame(){
        //Gemme ændringer (data persistence)
        io.savePlayerData(players);
    }
    private void testCode() {
        /* Denne kode foretager nogle ændringer i player objekterne for at teste at data bliver gemt korrekt
        Første player får 1000kr
        Sidste player får 2000 kr
         */
        printPlayers();
        System.out.println("Første kunde får 1000kr");
        players.get(0).deposit(1000);

        System.out.println("\n Sidste kunde får 2000 kr");
        Player lastCustomer = players.get(players.size()-1);
        lastCustomer.deposit(2000);

        System.out.println("\n Ny tilstand efter manipulation: ");
        printPlayers();
    }
    private void printPlayers() {
        for (Player p:players) {
            System.out.println(p);
        }
    }
}
