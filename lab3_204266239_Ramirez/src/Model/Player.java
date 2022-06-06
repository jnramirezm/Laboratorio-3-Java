package Model;
import Interface.InterfPlayer;

import java.util.ArrayList;
import java.util.Objects;

public class Player implements InterfPlayer {
    private String name;
    private Integer turn;
    private Integer score;
    private Dobble cards;

    public Player(String name){
        this.name = name;
        this.turn = 0;
        this.score = 0;
        this.cards = new Dobble();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Dobble getCards() {
        return cards;
    }

    public void setCards(Dobble cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(turn, player.turn) && Objects.equals(score, player.score) && Objects.equals(cards, player.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, turn, score, cards);
    }

    @Override
    public String toString() {
        String salida = new String();
        if(getCards().size() >= 1  ){
            salida = "Jugador " + getName() + "= Puntos: " + getScore() + " Turno: " + getTurn() + " Cartas en mano: " + getCards().cartasJugadortoString();
            return salida;
        }
        salida = "Jugador " + getName() + "= Puntos: " + getScore() + " Turno: " + getTurn();
        return salida;
    }
}
