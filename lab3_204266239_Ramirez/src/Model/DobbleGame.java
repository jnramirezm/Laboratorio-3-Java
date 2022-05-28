package Model;
import java.util.ArrayList;

public class DobbleGame {
    private Dobble cardsSet;
    private ArrayList<Player> players;
    private Integer totalPlayers;
    private Integer estadoPartida;
    private Dobble mesa;
    private String modo;
    private Boolean estaRegistrado;

    public DobbleGame(Integer tplayers, Integer tdeck, String mgame ){
        this.cardsSet = new Dobble(tdeck, 0);
        this.totalPlayers = tplayers;
        this.modo = mgame;
        this.players = new ArrayList<Player>();
        this.estadoPartida = 0;
        this.mesa = new Dobble();
        this.estaRegistrado = false;
    }

    public Dobble getCardsSet() {
        return cardsSet;
    }

    public void setCardsSet(Dobble cardsSet) {
        this.cardsSet = cardsSet;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Integer getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(Integer totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public Integer getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(Integer estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    public Dobble getMesa() {
        return mesa;
    }

    public void setMesa(Dobble mesa) {
        this.mesa = mesa;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Boolean getEstaRegistrado() {
        return estaRegistrado;
    }

    public void setEstaRegistrado(Boolean estaRegistrado) {
        this.estaRegistrado = estaRegistrado;
    }
}
