package Controller;

import Model.*;
import java.util.ArrayList;

public class Controller {
    private DobbleGame game;

    public Controller(DobbleGame game){
        this.game = game;
    }

    public DobbleGame getGame() {
        return game;
    }

    public void setGame(DobbleGame game) {
        this.game = game;
    }

    public void register(String name){
        DobbleGame game = getGame();
        if( game.getTotalPlayers() > game.getPlayers().size()){
            System.out.println("Ya se ha registrado el total de jugadores para la partida");
            return;
        }
        for(int i = 0; i < game.getTotalPlayers(); i++){
            if(game.getPlayers().get(i).getName().equals(name)){
                System.out.println("Este jugador ya esta registrado");
            }
        }
        Player newPlayer = new Player(name);
        game.getPlayers().add(newPlayer);
    }

}
