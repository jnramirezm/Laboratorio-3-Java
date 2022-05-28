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
        for(int i = 0; i < game.getUsuarios().size(); i++){
            if(game.getUsuarios().get(i).equals(name)){
                System.out.println("Este jugador ya esta registrado");
            }
        }
        game.getUsuarios().add(name);
    }

}
