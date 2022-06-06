package Interface;

public interface Repository {
    public void register(String name);
    public Integer score(String name);
    public String status();
    public void crearGame(Integer n, Integer nE, String m);
    public void registerGame(String name);
    public String userToString();
    public String VisibletoString();
    public void nullGame(String modo);
    public void passGame(String name);
    public void playGame(String modo, String element, String name);
    public String finishGame();

}
