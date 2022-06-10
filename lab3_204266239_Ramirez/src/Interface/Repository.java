package Interface;

public interface Repository {
    public void register(String name);
    public Integer score(String name);
    public void crearGame(Integer n, Integer nE, String m);
    public void registerGame(String name);
    public String userToString();
    public String VisibletoString();

    /**
     * Metodo que crea un agrega una Cpu al juego y comienza el juego.
     */
    public void createPlayervCpu();

    /**
     * Metodo que modifica el juego, anadiendo 2 CPU al juego, para que empiezen una partida jugando entre ellas.
     */
    public void createCpuvCpu();

    public void nullGame(String modo);
    public void passGame(String name);
    public void playGame(String modo, String element, String name);
    public String finishGame();

}
