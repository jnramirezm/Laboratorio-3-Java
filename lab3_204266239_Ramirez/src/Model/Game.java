package Model;
import java.util.ArrayList;

/**
 * Clase que simula un juego dentro de una aplicacion, este consta de un dobbleGame (DobbleGame (Contiene el juego de cartas dobble con sus respectivos contenidos)),
 * usuarios (Lista de nombres), un boolean estaRegistrado, el nombre del primer usuario registrado en la aplicacion y un boolean para saber si se creo el juego.
 * @version 11.0.15
 * @autor Juan Ramirez Montero
 */

public class Game {
    private DobbleGame dobbleGame;
    private ArrayList<String> usuarios;
    private Boolean estaRegistrado = false;
    private String registrado;
    private Boolean gameCreado = false;

    public Game(){
        this.usuarios = new ArrayList<>();
    }

    /**
     * Obtiene el dobbleGame (DobbleGame) de la aplicacion.
     * @return dobbleGame (DobbleGame), el juego que se utiliza en la aplicacion.
     */
    public DobbleGame getDobbleGame() {
        return dobbleGame;
    }

    /**
     * Modifica el juego (DobbleGame) que esta en la aplicacion.
     * @param game (DobbleGame). Corresponde al juego que se quiere cambiar dentro de la aplicion
     */
    public void setDobbleGame(DobbleGame game) {
        this.dobbleGame = game;
    }

    /**
     * Obtiene el registrado (String) que es un nombre del usuario registado en la aplicacion.
     * @return
     */
    public String getRegistrado() {
        return registrado;
    }

    /**
     * Modifica al user registrado (String)
     * @param registrad (String), corresponde al nombre de un usuario que se registra en la aplicacion
     */

    public void setRegistrado(String registrad) {
        registrado = registrad;
    }

    /**
     * Obtiene a usuarios (Lista de String) de la aplicacion.
     * @return usuarios (Lista de String), que contiene los nombres de los usuairos registrados
     */

    public ArrayList<String> getUsuarios() {
        return usuarios;
    }

    /**
     * Modifica la lista de usuarois (Strings) del game.
     * @param usuarios (Lista de strings), corresponde a una lista de strings con los nombre de los usuarios.
     */

    public void setUsuarios(ArrayList<String> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     * Obtiene un boolean de estaRegistrado
     * @return estaRegistrado (Boolean), este se vuelve true cuando la primera persona se registra correctamente a la aplicacion.
     */
    public Boolean getEstaRegistrado() {
        return estaRegistrado;
    }

    /**
     * Modifica el estado de estaRegistrado(Boolean)
     * @param estaRegistrado (Boolean), corresponde a un valor tipo boolean, que sirve para su luego uso en el menu.
     */

    public void setEstaRegistrado(Boolean estaRegistrado) {
        this.estaRegistrado = estaRegistrado;
    }

    /**
     * Obtiene un boolean GameCreado de la aplicaicon.
     * @return gameCreado (Boolean), corresponde a si el juego ya fye creado dentro de la aplicacion.
     */

    public Boolean getGameCreado() {
        return gameCreado;
    }

    /**
     * Modifica el estado de GameCreado (Boolean) de la apliaacion.
     * @param gameCreado (Boolean), corresponde a un boolean con el cual quiere ser modificado el estado dle juego.
     */

    public void setGameCreado(Boolean gameCreado) {
        this.gameCreado = gameCreado;
    }
}
