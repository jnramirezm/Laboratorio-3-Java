package Model;
import java.util.ArrayList;

public class Game {
    private DobbleGame dobbleGame;
    private ArrayList<String> usuarios;
    private Boolean estaRegistrado = false;
    private String registrado;
    private Boolean gameCreado = false;

    public Game(){
        this.usuarios = new ArrayList<>();
    }

    public DobbleGame getDobbleGame() {
        return dobbleGame;
    }

    public void setDobbleGame(DobbleGame game) {
        this.dobbleGame = game;
    }

    public String getRegistrado() {
        return registrado;
    }

    public void setRegistrado(String registrad) {
        registrado = registrad;
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

    public Boolean getGameCreado() {
        return gameCreado;
    }

    public void setGameCreado(Boolean gameCreado) {
        this.gameCreado = gameCreado;
    }
}
