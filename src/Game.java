import java.util.ArrayList;

public class Game {
    public static ArrayList<Player> players = new ArrayList<>();
    private FileIO io = new FileIO();
    private TextUI ui = new TextUI();
    private int maxPlayers;
    private Player currentPlayer;
    public static CardDeck cardDeck;
    private Board board;
    private Dice dice;
    public Game(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        dice = new Dice();
    }

    public void setup(){
        //Læse data ind
        String[] carddata = io.readBoardData("data/carddata.csv", 15);
        cardDeck = new CardDeck(carddata);


        System.out.println(cardDeck.getNext().getMessage());

        String[] fielddata = io.readBoardData("data/fielddata.csv", 40);
        board = new Board(fielddata);

        System.out.println(board.getField(40));


        ArrayList<String> data = io.readPlayerData("src/data.txt");
        if(data.size()>0) {
            if (ui.getInput("Fortsætte gemt spil? Y/N").equalsIgnoreCase("Y")) {
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
        }else{
            runPlayerSetupDialog();
        }
        //testCode();

        this.displayPlayers();
        this.runGameLoop();
       this.endGame();

    }

    private void runPlayerSetupDialog() {

        String input = "";
        while(players.size() < 6 ){
            input = ui.getInput("Skriv navn på spiller: ");
            if(input.equalsIgnoreCase("Q")){
                if(players.size()>1){
                    break;
                }else{
                    input = ui.getInput("Der skal være mindst 2 spillere. Skriv navn på spiller: ");
                }
            }
         registerPlayer(input, 30000);
        }

    }

    private void registerPlayer(String name, int balance) {
        Player p = new Player(name, balance); //bruger de indlæste værdier til at konstruere et player objekt (instansiering)
        players.add(p);
    }

    private void runGameLoop(){
        int count = 0;

        String  input = "Y";
        while(input.equalsIgnoreCase("Y")){
            currentPlayer = players.get(count);
            throwAndMove();
            input = ui.getInput("Fortsæt? Y/N");
            count++;
            if(count == players.size()){
                count = 0;
            }
        }


    }

    private void throwAndMove() {

        ui.displayMessage("Det er "+currentPlayer.getName()+"'s tur");
        /**
         * Kast terninger
         * Vis hvad der blev slået
         * opdater spillerens position på brættet
         * Få fat i feltet spilleren er landet på
         * *
         */
        int result = dice.rollDiceSum();
        int newPosition = currentPlayer.updatePosition(result);

        Field f = board.getField(newPosition);

   landAndAct(f);


    }

    private void landAndAct(Field f) {
        /* Få fat i den besked spilleren skal se når han lander på et felt
         * Vis beskeden og afvent spillerens svar
         * modtag og send svaret til feltet
         * vis spillerens saldo*/
        String msg = f.onLand(currentPlayer);
        ui.displayMessage(msg);
    }


    public void endGame(){
        //Gemme ændringer (data persistence)
        io.savePlayerData(players);
    }

    private void displayPlayers() {
        String s ="\nGame status:\n";

        for (Player p:players) {
            //  s += p.toString();
            s = s.concat(p.toString()+"\n");
        }

        ui.displayMessage(s);
    }
}
