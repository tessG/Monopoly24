import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();
    FileIO io = new FileIO();
    TextUI ui = new TextUI();
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
                registerPlayer(name, balance);

                                      // placerer objektet i listen med kunder
            }
        }else{
            runPlayerSetupDialog();
        }
        testCode();
        endGame();
    }

    private void runPlayerSetupDialog() {

        String input = "";
        while(players.size() < 6 ){
            input = ui.getInput("Skriv navn på spiller: ");
            if(input.equalsIgnoreCase("Q")){
                if(players.size()>1){
                    break;
                }else{
                    input = ui.getInput("Skriv navn på spiller: ");
                }
            }
         registerPlayer(input, 30000);
        }
    }

    private void registerPlayer(String name, int balance) {


        Player p = new Player(name, balance); //bruger de indlæste værdier til at konstruere et player objekt (instansiering)
        players.add(p);
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
        displayPlayers();
        System.out.println("Første kunde får 1000kr");
        players.get(0).deposit(1000);

        System.out.println("\n Sidste kunde får 2000 kr");
        Player lastCustomer = players.get(players.size()-1);
        lastCustomer.deposit(2000);

        System.out.println("\n Ny tilstand efter manipulation: ");
        displayPlayers();
    }
    private void displayPlayers() {
        String s ="\n";
        for (Player p:players) {
            //  s += p.toString();
            s = s.concat(p.toString()+"\n");
        }

        ui.displayMessage(s);
    }
}
