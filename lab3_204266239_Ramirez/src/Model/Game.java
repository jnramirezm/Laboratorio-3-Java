package Model;
import java.util.ArrayList;

public class Game {
    private ArrayList<DobbleGame> games;
    private ArrayList<String> usuarios;
    private Boolean estaRegistrado = false;

    public Game(){
        this.usuarios = new ArrayList<>();
        this.games = new ArrayList<DobbleGame>();
    }

    public ArrayList<DobbleGame> getGames() {
        return games;
    }

    public void setGames(ArrayList<DobbleGame> games) {
        this.games = games;
    }

    public ArrayList<String> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<String> usuarios) {
        this.usuarios = usuarios;
    }

    public Boolean getEstaRegistrado() {
        return estaRegistrado;
    }

    public void setEstaRegistrado(Boolean estaRegistrado) {
        this.estaRegistrado = estaRegistrado;
    }
}
