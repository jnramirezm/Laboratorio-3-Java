package Interface;

public interface dGame {


    /**
     * Obtiene el nombre (String) del jugador al que le toca realizar su turno dentro del juego.
     * @return nombre (String), corresponde al nombre de un jugador que esta registrado dentro del juego, al cual le pertenece el turno en el momento.
     */
    public String whoseTurnIsIt();

    /**
     * Obtiene el status (String) de la partida, a traves del estado Partida.
     * @return status (String), corresponde al estado actual de la partida pero en forma de String.
     */
    public String status();

    /**
     * Convierte el juego en String, con su contenido igualmente a String.
     * @return salida (String), que corresponde al juego en forma de String, el modo de juego, el total de players. el mazo de juego, el status , los players y la mesa en el momento.
     */
    public String toString();

    /**
     * Metodo que obtiene un boolean, True si el juego es igual el juego entregado.
     * @param o (Object), que contiene el contenido de un DobbleGame.
     * @return boolean, dependiendo si los juegos comparados son iguales o no.
     */
    public boolean equals(Object o);
}
