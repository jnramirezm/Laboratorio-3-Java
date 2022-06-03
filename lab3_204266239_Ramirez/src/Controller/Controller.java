package Controller;

import Model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Controller {
    private Game game;

    public Controller(Game game){
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Boolean estaRegistrado(){
        Game game = getGame();
        return game.getEstaRegistrado();
    }
    public void registradoconexito(){
        Game game = getGame();
        game.setEstaRegistrado(true);
    }

    public void register(String name){
        Game game = getGame();
        if(name.equals("CPU")){
            System.out.println("Nombre reservado, no puede registrar este nombre!");
            return;
        }

        if(game.getUsuarios().size() == 0){
            System.out.println("Se ha registrado con Exito!");
            game.setRegistrado(name);
            game.getUsuarios().add(name);
            registradoconexito();
            return;

        }
        for(int i = 0; i < game.getUsuarios().size(); i++){
            if(game.getUsuarios().get(i).equals(name)){
                System.out.println("Este jugador ya esta registrado");
                return;
            }
        }
        game.getUsuarios().add(name);
        System.out.println("Se ha registrado con Exito!");
    }

    public void crearGame(Integer n, Integer nE, String m){
        Game game = getGame();
        if(n == 0 || n == 1){
            System.out.println("El numero de jugadores debe ser igual o mayor a 2.");
            return;
        }
        if(nE == 0 || nE == 1 || nE == 2 ){
            System.out.println("El numero de elementos debe ser igual o mayor a 3.");
            return;
        }
        game.setDobbleGame(new DobbleGame(n,nE,m)) ;
        DobbleGame dGame = getGame().getDobbleGame();
        if(!dGame.getCardsSet().isDobble()){
            System.out.println("Este mazo no es de tipo Dobble!- - - - \n Vuelva a crear su Juego");
            return;
        }
        Player fPlayer = new Player(getGame().getRegistrado());
        game.getDobbleGame().getPlayers().add(fPlayer);
        game.setGameCreado(true);
        System.out.println("El juego ha sido creado con exito!");
    }

    public void registerGame(String name) {
        Game game = getGame();
        if (game.getDobbleGame().getPlayers().size() >= game.getDobbleGame().getTotalPlayers()) {
            System.out.println("Ya esta el total de jugadores registrados para este juego!.");
            return;
        }
        if(name.equals("CPU")){
            System.out.println("Nombre reservado, no puede registrar este nombre!");
            return;
        }
        for(int i = 0; i < game.getDobbleGame().getPlayers().size(); i++) {
            if (game.getDobbleGame().getPlayers().get(i).getName().equals(name)) {
                System.out.println("Este nombre ya esta registrado!");
                return;
            }
        }
        Player nPlayer = new Player(name);
        game.getDobbleGame().getPlayers().add(nPlayer);
        System.out.println("Se ha registrado el jugador con exito!.");
    }

    public String VisibletoString(){
        String salida = new String();
        Game game = getGame();
        salida = "Turno del jugador : " + game.getDobbleGame().whoseTurnIsIt() + "        ";
        for(int i = 0; i < game.getDobbleGame().getPlayers().size(); i++){
            if(game.getDobbleGame().getPlayers().get(i).getName().equals(game.getDobbleGame().whoseTurnIsIt())){
                salida = salida + " Turno: " + game.getDobbleGame().getPlayers().get(i).getTurn();
                salida = salida + "    Puntaje: " + game.getDobbleGame().getPlayers().get(i).getScore() +"\n";
            }
        }
        salida = salida + "\n      ---      ---- Cartas en Mesa ----      ---      \n" + "          " + game.getDobbleGame().getMesa().mesatoString() + "\n";
        salida = salida + " ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n  ";
        return salida;
    }

    public void nullGame(String modo) {
        Game game = getGame();
        if (modo.equals("Stack")) {
            if(game.getDobbleGame().getCardsSet().size() < 2 && game.getDobbleGame().getMesa().size() != 2){
                game.getDobbleGame().setEstadoPartida(2);
                return;
            }
            if(game.getDobbleGame().getMesa().size() == 0){
                game.getDobbleGame().getMesa().anadir(game.getDobbleGame().getCardsSet().nthCard(0));
                game.getDobbleGame().getMesa().anadir(game.getDobbleGame().getCardsSet().nthCard(1));
                game.getDobbleGame().getCardsSet().eliminarCarta(game.getDobbleGame().getCardsSet().nthCard(0));
                game.getDobbleGame().getCardsSet().eliminarCarta(game.getDobbleGame().getCardsSet().nthCard(0));
            }
        }
    }

    public void passGame(String name){
        Game game = getGame();
        for(int i = 0; i < getGame().getDobbleGame().getPlayers().size(); i++){
            if(game.getDobbleGame().getPlayers().get(i).getName().equals(name)){
               int turn = game.getDobbleGame().getPlayers().get(i).getTurn();
               game.getDobbleGame().getPlayers().get(i).setTurn(turn+1);
            }
        }
    }

    public String elementComun(Card c1, Card c2){
        String element = new String();
        for(int i = 0; i < c1.size(); i++){
            for(int j = 0; j < c2.size(); j++){
                if(c1.get(i).equals(c2.get(j))){
                    element = c1.get(i);
                }
            }
        }
        return element;
    }

    public void playGame(String modo, String element, String name){
        Game game = getGame();
        if(modo.equals("Stack")){
            if(!name.equals("CPU")){
                String eComun = elementComun(game.getDobbleGame().getMesa().nthCard(0),game.getDobbleGame().getMesa().nthCard(1));
                if( eComun.equals(element)){
                    for(int i = 0; i < game.getDobbleGame().getPlayers().size(); i++ ){
                        if(game.getDobbleGame().getPlayers().get(i).getName().equals(name)){
                            int score = game.getDobbleGame().getPlayers().get(i).getScore();
                            game.getDobbleGame().getPlayers().get(i).setScore(score+1);
                            System.out.println("   ---   Ha acertado en el elemento en comun!:)    ---   \n");
                            game.getDobbleGame().getPlayers().get(i).getCards().anadir(game.getDobbleGame().getMesa().nthCard(0));
                            game.getDobbleGame().getPlayers().get(i).getCards().anadir(game.getDobbleGame().getMesa().nthCard(1));
                            game.getDobbleGame().setMesa(new Dobble());
                            passGame(name);
                        }
                    }
                }
                else{
                    System.out.println("   ---   Se ha equivocado en el Elemento en comun!   ---   \n");
                    passGame(name);
                }
            }
            if(name.equals("CPU")){
                Random rnd = new Random();
                String eComun = elementComun(game.getDobbleGame().getMesa().nthCard(0),game.getDobbleGame().getMesa().nthCard(1));
                ArrayList<String> lProb = new ArrayList<>();
                lProb.add(eComun);
                int index = rnd.nextInt((game.getDobbleGame().getMesa().nthCard(0).size()));
                if(!game.getDobbleGame().getMesa().nthCard(0).get(index).equals(eComun)){
                    lProb.add(game.getDobbleGame().getMesa().nthCard(0).get(index));
                }
                Random rnd2 = new Random();
                int index2 = rnd2.nextInt(lProb.size());
                if(lProb.get(index2).equals(eComun)){
                    for(int i = 0; i < game.getDobbleGame().getPlayers().size(); i++ ){
                        if(game.getDobbleGame().getPlayers().get(i).getName().equals(name)){
                            int score = game.getDobbleGame().getPlayers().get(i).getScore();
                            game.getDobbleGame().getPlayers().get(i).setScore(score+1);
                            game.getDobbleGame().getPlayers().get(i).getCards().anadir(game.getDobbleGame().getMesa().nthCard(0));
                            game.getDobbleGame().getPlayers().get(i).getCards().anadir(game.getDobbleGame().getMesa().nthCard(1));
                            game.getDobbleGame().setMesa(new Dobble());
                            passGame(name);
                        }
                    }
                }
                else{
                    passGame(name);
                }
            }
        }
    }

    public String finishGame(){
        Game game = getGame();
        ArrayList<Player> players = game.getDobbleGame().getPlayers();
        ArrayList<Integer> totalScore = new ArrayList<>();
        String salida = new String();
        for(int i = 0; i < players.size(); i++){
            totalScore.add(players.get(i).getScore());
        }
        int mScore = Collections.max(totalScore);
        int cont = 0;
        for(int j =0; j < players.size(); j++){
            if(mScore == players.get(j).getScore()){
                cont = cont + 1;
            }
        }
        if(cont == 1){
            for(int k = 0; k < players.size(); k++){
                if(players.get(k).getScore() == mScore){
                    salida = salida + "\n     El Ganador del juego es : "+players.get(k).getName() + "\n     con un Puntaje de " + mScore +"\n" ;
                    salida = salida + "\n  ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----\n ";
                    return salida;
                }
            }
        }
        salida = "\n     Hubo un empate entre los jugadores : |  ";
        for(int h = 0; h < players.size(); h++){
            if(players.get(h).getScore() == mScore){
                salida = salida + players.get(h).getName() + "  ";
            }
        }
        salida = salida + "|";
        salida = salida + " \n     Ambos jugadores tuvieron un total de " + mScore + " Puntos\n";
        salida = salida + "\n  ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n";
        return salida;
    }
}
