package Model;
import Interface.InterfPlayer;

/**
 * Clase que simula a un jugador, este contiene un nombre (String), turno y score (Integers) y un mazo de cartas (Dobble)
 * @version 11.0.15
 * @autor Juan Ramirez Montero
 */

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

    /**
     * Obtiene el name (String) del jugador.
     * @return name (String), que corresponde al nombre del jugador.
     */

    public String getName() {
        return name;
    }

    /**
     * Modifica el nombre del jugador
     * @param name (String), corresponde al nombre del jugador
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el Turn (Integer) del jugador.
     * @return turn (Integer) que corresponde al turno del jugador.
     */

    public Integer getTurn() {
        return turn;
    }

    /**
     * Modifica el turno (Integer) del jugador.
     * @param turn (Integer) que corresponde al turno que le pertenece al jugador.
     */
    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    /**
     * Obtiene el score (Integer) del jugador
     * @return score (Integer) que corresponde al score del jugador.
     */

    public Integer getScore() {
        return score;
    }

    /**
     * Modifica el score (Integer) del jugador.
     * @param score (Integer), que corresponde al score nuevo al cual se quiere modificar
     */

    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * Obtiene las cartas (Dobble) correspondientes al jugador.
     * @return cards (Dobble) que corresponden las cartas que posee el jugador.
     */

    public Dobble getCards() {
        return cards;
    }

    /**
     * Modifica las cartas de un jugador (Player)
     * @param cards (Dobble), cartas a modificar.
     */

    public void setCards(Dobble cards) {
        this.cards = cards;
    }

    /**
     * Metodo que obtiene un boolean, entre la comparacion de 2 jugadores.
     * @param o (Object), que corresponde a los contenidos de un Player.
     * @return boolean, dependiendo si los players comparados son iguales o no.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals( player.name) && (turn == player.turn) && (score == player.score) && cards.equals(player.cards);
    }

    /**
     * Convierte el player con su correspondiente contenido a String, mostrado el nombre, turno, sus cartas en mano y el puntaje.
     * @return salida (String), que corresponde al Player con su contenido en string.
     */
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
