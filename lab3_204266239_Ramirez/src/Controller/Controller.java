package Controller;

import Model.*;
import java.util.ArrayList;

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
        if(game.getUsuarios().size() == 0){
            game.setRegistrado(name);
        }
        for(int i = 0; i < game.getUsuarios().size(); i++){
            if(game.getUsuarios().get(i).equals(name)){
                System.out.println("Este jugador ya esta registrado");
            }
        }
        game.getUsuarios().add(name);
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

    public void nullGame(String modo) {
        if (modo.equals("Stack")) {
            Game game = getGame();
            game.getDobbleGame().getMesa().anadir(game.getDobbleGame().getCardsSet().get(0));
            game.getDobbleGame().getMesa().anadir(game.getDobbleGame().getCardsSet().get(1));
            game.getDobbleGame().getCardsSet().eliminarCarta(0);
            game.getDobbleGame().getCardsSet().eliminarCarta(1);
        }
    }
}
