package Model;

import Interface.dGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Clase que simula un juego del juego de cartas Dobble, el cual contiene un cardsSet (Dobble), que es el mazo que contiene las cartas para su uso en el juego,
 * players (Lista de jugadores), totalPlayers (Integer) que sirve para limitar la cantidad de jugadores que pueden unirse a la partida, estadoPartida (Integer),
 * que corresponde al estado de la partida (Tiene 3 estados, Preparacion, En juego, finalizado), mesa (Dobble) que son las cartas visibles para los jugadores
 *  y un modo (String)
 *  @version 11.0.15
 *  @autor Juan Ramirez Montero
 */

public class DobbleGame implements dGame {
    private Dobble cardsSet;
    private ArrayList<Player> players;
    private Integer totalPlayers;
    private Integer estadoPartida;
    private Dobble mesa;
    private String modo;

    public DobbleGame(Integer tplayers, Integer tdeck, String mgame ){
        this.cardsSet = new Dobble(tdeck, 0);
        this.totalPlayers = tplayers;
        this.modo = mgame;
        this.players = new ArrayList<Player>();
        this.estadoPartida = 0;
        this.mesa = new Dobble();
    }

    /**
     * Obtiene el mazo de cartas (Dobble) del juego
     * @return cardsSet (Dobble), que corresponde al mazo del juego
     */
    public Dobble getCardsSet() {
        return cardsSet;
    }

    public void setCardsSet(Dobble cardsSet) {
        this.cardsSet = cardsSet;
    }

    /**
     * Obtiene a los jugadores (Lista de jugadores) que estan registrados en el juego
     * @return players (Lista de jugadores), que corresponden a los jugadores del juego.
     */

    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Modifica a los jugadores (Lista de jugadores) que estan en el juego.
     * @param players (Lista de jugadores). Corresponde a la lista actualizada de jugadores del juego.
     */

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Obtiene el total de jugadores (Integer) que pueden registrarse a un juego.
     * @return totalPlayers (Integer). Corresponde al total de jugadores que pueden registrarse.
     */

    public Integer getTotalPlayers() {
        return totalPlayers;
    }

    /**
     * Modifica el totalPlayers (Integer) del juego.
     * @param totalPlayers (Integer). corresponde a un entero que permitira saber la nueva cantidad de jugadores que pueden registrarse al juego.
     */

    public void setTotalPlayers(Integer totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    /**
     * Obtiene el estado de Partida (Integer) del juego.
     * @return (Integer) que permitira saber el estado que se encuentra la partida, 0-1-2, Preparacion, En juego, finalizado.
     */

    public Integer getEstadoPartida() {
        return estadoPartida;
    }

    /**
     * Modifica el estado de la partida (Integer) del juego.
     * @param estadoPartida (Integer). corresponde a la modificacion que se quiere realizar el juego, cambiando su estado.
     */

    public void setEstadoPartida(Integer estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    /**
     * Obtiene la mesa (Dobble) del juego, son las cartas visibles para los jugadores y donde se realizan las comparaciones de cartas.
     * @return mesa (Dobble), que corresponde a la mesa con cartas visibles del juego.
     */

    public Dobble getMesa() {
        return mesa;
    }

    /**
     * Modifica la mesa (Dobble) del juego.
     * @param mesa (Dobble). Corresponde a la mesa que se quiere modificar dentro del juego.
     */

    public void setMesa(Dobble mesa) {
        this.mesa = mesa;
    }

    /**
     * Obtiene el modo (String) de juego del juego.
     * @return modo (String) corresponde al modo de juego del juego
     */

    public String getModo() {
        return modo;
    }

    /**
     *
     * @param
     */

    public void setModo(String modo) {
        this.modo = modo;
    }

    /**
     * Metodo que obtiene un boolean, True si el juego es igual el juego entregado.
     * @param o (Object), que contiene el contenido de un DobbleGame.
     * @return boolean, dependiendo si los juegos comparados son iguales o no.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DobbleGame dbGame = (DobbleGame) o;
        int contePlayers = 0;
        for(int i = 0; i < getPlayers().size(); i++) {
            for (int j = 0; j < dbGame.getPlayers().size(); j++) {
                if (getPlayers().get(i).equals(dbGame.getPlayers().get(j))) {
                    contePlayers = contePlayers + 1;
                }
            }
        }
        return cardsSet.equals(dbGame.cardsSet) && (contePlayers == getPlayers().size()) && (getPlayers().size() == dbGame.getPlayers().size()) && Objects.equals(totalPlayers, dbGame.totalPlayers) && Objects.equals(estadoPartida, dbGame.estadoPartida) && mesa.equals(dbGame.mesa) && Objects.equals(modo, dbGame.modo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardsSet, players, totalPlayers, estadoPartida, mesa, modo);
    }

    /**
     * Obtiene el nombre (String) del jugador al que le toca realizar su turno dentro del juego.
     * @return nombre (String), corresponde al nombre de un jugador que esta registrado dentro del juego, al cual le pertenece el turno en el momento.
     */

    public String whoseTurnIsIt(){
        ArrayList<Player> players = getPlayers();
        ArrayList<Integer> totalTurnos = new ArrayList<>();
        for(int i = 0; i < players.size(); i++){
            totalTurnos.add(players.get(i).getTurn());
        }
        int mTurn = Collections.max(totalTurnos);
        int cont = 0;
        for(int j =0; j < players.size(); j++){
            if(mTurn == players.get(j).getTurn()){
                cont = cont + 1;
            }
        }
        if(cont != players.size()){
            for(int k = 0 ; k < players.size(); k ++){
                if(players.get(k).getTurn() < mTurn){
                    return players.get(k).getName();
                }
            }
        }
        return players.get(0).getName();
    }

    /**
     * Obtiene el status (String) de la partida, a traves del estado Partida.
     * @return status (String), corresponde al estado actual de la partida pero en forma de String.
     */

    public String status(){
        String salida = new String();
        Integer ePartida = getEstadoPartida();
        if(ePartida == 0){
            salida = "La partida se encuentra en proceso de registro de jugadores\\n\"";
        }
        if(ePartida == 1){
            salida = "Partida en progreso";
        }
        if(ePartida == 2){
            salida = "Partida finalizada";
        }
        return salida;
    }

    /**
     * Convierte el juego en String, con su contenido igualmente a String.
     * @return salida (String), que corresponde al juego en forma de String, el modo de juego, el total de players. el mazo de juego, el status , los players y la mesa en el momento.
     */

    @Override
    public String toString() {
        String salida = new String();
        salida = "  -------- Juego --------\n" + "Modo de juego: " + getModo() +"\nCapacidad de jugadores : " + getTotalPlayers()  +  "\nMazo en juego = " + getCardsSet() +"\n";
        String status = status();
        salida = salida + status;
        for(int i = 0; i < getPlayers().size(); i++) {
            salida = salida + getPlayers().get(i) + "\n";
        }
        if(getMesa().size() >= 1){
            salida = salida + "Mesa del juego = " + getMesa();
        }
        return salida;
    }

}
