package Model;
import java.util.ArrayList;

public class Player {
    private String name;
    private Integer turn;
    private Integer score;
    private ArrayList<Card> cards;

    public Player(String name){
        this.name = name;
        this.turn = 0;
        this.score = 0;
        this.cards = new ArrayList<>();
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

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

}
