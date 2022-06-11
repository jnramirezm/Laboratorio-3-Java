package Interface;

public interface Repository {

    /**
     * Metodo que registra a un user en la aplicacion.
     * @param name (String), nombre del usuario que se registra en la aplicacion.
     */
    public void register(String name);

    /**
     * Metodo que obtiene el Score de un Player a traves de su nombre.
     *
     * @param name (String), corresponde al nombre de algun jugador de la partida.
     * @return Integer que corresponde al total de puntos que tiene el jugador al momento de utilizar el metodo.
     */
    public Integer score(String name);

    /**
     * Metodo que crea un game en la aplicacion, con los parametros dados por el usuario.
     * @param n (Integer) corresponde al numero de elementos que tendra una carta
     * @param nE (Integer) corresponde al numero de jugadores que podra tener el juego.
     * @param m (String) corresponde al modo de juego que selecciona el usuario.
     */
    public void crearGame(Integer n, Integer nE, String m);

    /**
     * Metodo que registra a un Player al juego creado.
     *
     * @param name (String), corresponde al nombre del jugador que se quiere registrar.
     */
    public void registerGame(String name);

    /**
     * Metodo que transforma la Lista de usuarios a String para ser mostrado por pantalla.
     * @return String, que son los nombres de los usuarios registrados en la aplicacion.
     */
    public String userToString();

    /**
     * Metodo que crea un String con los contenidos del juegos visibles para el jugador al cual le corresponde el turno,
     * este string contiene, el nombre del jugador que le corresponde el turno, los puntos del jugador, el turno y las cartas que estan en mesa.
     * @return String, que es utilizado para mostrar por consola.
     */
    public String VisibletoString();

    /**
     * Metodo que crea un agrega una Cpu al juego y comienza el juego.
     */
    public void createPlayervCpu();

    /**
     * Metodo que modifica el juego, anadiendo 2 CPU al juego, para que empiezen una partida jugando entre ellas.
     */
    public void createCpuvCpu();

    /**
     * Metodo que retira 2 cartas del cardsSet(Dobble) para dejarlas en mesa.
     * @param modo (String), corresponde al modo que se utiliza en el juego.
     */
    public void nullGame(String modo);

    /**
     * Metodo que realiza la accion Pass del jugador, le suma 1 turno al jugador al cual le toca realizar su turno.
     * @param name (String), nombre del jugador que realiza la accion Pass.
     */
    public void passGame(String name);

    /**
     * Metodo que realiza la accion de jugar al juego Dobble, dependiendo del modo de juego.
     * @param modo (String), corresponde al modo de juego que tiene el juego.
     * @param element (String), corresponde al elemento que el jugador entrego y se compara si acierta con el elemento en comun entre las cartas de la mesa.
     * @param name  (String), nombre del jugador que realizo el turno.
     */
    public void playGame(String modo, String element, String name);

    /**
     * Metodo crea un String con el juego finalizado, entregando (si se cumple) el ganador o los jugadores empatados.
     * @return String , que corresponde al ganador o jugadores empatados.
     */
    public String finishGame();

}
