package Controller;

import Interface.Repository;
import Model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Controller
 * Clase que simula un controlador, es donde se encuentran todos los metodos para hacer funcionar la aplicacion Game, contiene un Game.
 * @version 11.0.15
 * @autor Juan Ramirez Montero
 */

public class Controller implements Repository {
    private Game game;

    public Controller(Game game){
        this.game = game;
    }

    /**
     * Obtiene el game (Game) con el cual se realizan los metodos para que funcione la aplicacion
     * @return game (Game), aplicacion a la cual se le reazilaran los metodos.
     */

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Obtien el boolean estaRegistrado.
     * @return estaRegistrado(Boolean) de la aplicacion game.
     */

    public Boolean estaRegistrado(){
        Game game = getGame();
        return game.getEstaRegistrado();
    }

    /**
     * Modifica el estado de estaRegistrado (Boolean) de la aplicacion game, modificandolo como True.
     */

    public void registradoconexito(){
        Game game = getGame();
        game.setEstaRegistrado(true);
    }

    /**
     * Metodo que modifica el estado de la partida del juego DObbleGame.
     * @param n (Integer), corresponde al estado de la partida al cual se quiere modificar.
     */

    public void setEstadoP(Integer n){
        Game game = getGame();
        game.getDobbleGame().setEstadoPartida(n);
    }

    /**
     * Metodo que obtiene el modo de juego de un juego (DobbleGmame)
     * @return String que corresponde al modo de juego.
     */
    public String getModoGame(){
        Game game = getGame();
        return game.getDobbleGame().getModo();
    }

    /**
     * Metodo que obtiene el estado del juego (DobbleGame)
     * @return Integer, que corresponde al estado del juego.
     */

    public Integer getEstadoGame(){
        Game game = getGame();
        return game.getDobbleGame().getEstadoPartida();
    }

    /**
     *  Obtiene al User que esta registrado en la aplicacion
     * @return String, corresponde al nombre del usuaruio.
     */

    public String getUserRegistrado(){
        Game game = getGame();
        return  game.getRegistrado();
    }

    /**
     * Modifica al  usuario Registrado con el usuario dado.
     * @param name (String), corresponde el nombre al cual se quiere modificar el nuevo registrado.
     */

    public void setUserR(String name){
        Game game = getGame();
        game.setRegistrado(name);
    }

    /**
     * Obtiene al usuario que esta en la posicion n de la Lista.
     * @param n (Integer), corresponde al index que se quiere encontrar en la lista
     * @return (String) corresponde a un usuario registrado en la aplicacion.
     */
    public String getUsern(Integer n){
        Game game = getGame();
        return game.getUsuarios().get(n);
    }

    /**
     * Modifica el boolean GameCreado por el boolean dado por parametro
     * @param b (boolean), corresponde al boolean por el cual se quiere modifciar el gameCreado.
     */

    public void setGameC(boolean b){
        Game game = getGame();
        game.setGameCreado(b);
    }

    /**
     * Obtiene la cantidad de jugadores que estan registrados en la partida
     * @return Integer, corresponde al total de jugadores registrados en el momento
     */

    public Integer sizePlayers(){
        Game game = getGame();
        return game.getDobbleGame().getPlayers().size();
    }

    /**
     * Obtiene el Total de jugadores que pueden registrarse en una partida
     * @return Integer, que corresponde al total de jugadores que pueden registrarse en un juego
     */

    public  Integer totalPlayers(){
        Game game = getGame();
        return game.getDobbleGame().getTotalPlayers();
    }
    /**
     * Metodo que obtiene el nombre del jugador que le corresponde el turno
     * @return String, corresponde al nombre del jugador del turno actual.
     */
    public String turnoJugador(){
        Game game = getGame();
        return game.getDobbleGame().whoseTurnIsIt();
    }

    /**
     * Metodo que registra a un user en la aplicacion.
     * @param name (String), nombre del usuario que se registra en la aplicacion.
     */

    public void register(String name){
        Game game = getGame();
        if(name.contains("CPU")){
            System.out.println("Nombre reservado, no puede registrar este nombre!");
            return;
        }

        if(game.getUsuarios().size() == 0){
            System.out.println("Se ha registrado con Exito!");
            game.setRegistrado(name);
            game.getUsuarios().add(name);
            registradoconexito();
            return;

        }
        for(int i = 0; i < game.getUsuarios().size(); i++){
            if(game.getUsuarios().get(i).equals(name)){
                System.out.println("Este jugador ya esta registrado");
                return;
            }
        }
        game.getUsuarios().add(name);
        System.out.println("Se ha registrado con Exito!");
    }

    /**
     * Metodo que obtiene el Score de un Player a traves de su nombre.
     *
     * @param name (String), corresponde al nombre de algun jugador de la partida.
     * @return Integer que corresponde al total de puntos que tiene el jugador al momento de utilizar el metodo.
     */

    public Integer score(String name){
        int score = 0;
        Game game = getGame();
        for(int i = 0; i < game.getDobbleGame().getPlayers().size(); i++ ){
            if(name.equals(game.getDobbleGame().getPlayers().get(i).getName())){
                score = game.getDobbleGame().getPlayers().get(i).getScore();
            }
        }
        return score;
    }

    /**
     * Metodo que crea un game en la aplicacion, con los parametros dados por el usuario.
     *
     * @param n (Integer) corresponde al numero de elementos que tendra una carta
     * @param nE (Integer) corresponde al numero de jugadores que podra tener el juego.
     * @param m (String) corresponde al modo de juego que selecciona el usuario.
     */

    public void crearGame(Integer n, Integer nE, String m){
        Game game = getGame();
        if(n == 0 || n == 1){
            System.out.println("El numero de jugadores debe ser igual o mayor a 2.");
            return;
        }
        if(nE == 0 || nE == 1 || nE == 2 ){
            System.out.println("El numero de elementos debe ser igual o mayor a 3.");
            return;
        }
        game.setDobbleGame(new DobbleGame(n,nE,m)) ;
        DobbleGame dGame = getGame().getDobbleGame();
        if(!dGame.getCardsSet().isDobble()){
            System.out.println("Este mazo no es de tipo Dobble!- - - - \n Vuelva a crear su Juego");
            return;
        }
        Player fPlayer = new Player(getGame().getRegistrado());
        game.getDobbleGame().getPlayers().add(fPlayer);
        game.setGameCreado(true);
        System.out.println("El juego ha sido creado con exito!");
    }

    /**
     * Metodo que registra a un Player al juego creado.
     *
     * @param name (String), corresponde al nombre del jugador que se quiere registrar.
     */

    public void registerGame(String name) {
        Game game = getGame();
        if (game.getDobbleGame().getPlayers().size() >= game.getDobbleGame().getTotalPlayers()) {
            System.out.println("Ya esta el total de jugadores registrados para este juego!.");
            return;
        }
        if(name.contains("CPU")){
            System.out.println("Nombre reservado, no puede registrar este nombre!");
            return;
        }
        for(int i = 0; i < game.getDobbleGame().getPlayers().size(); i++) {
            if (game.getDobbleGame().getPlayers().get(i).getName().equals(name)) {
                System.out.println("Este nombre ya esta registrado!");
                return;
            }
        }
        Player nPlayer = new Player(name);
        game.getDobbleGame().getPlayers().add(nPlayer);
        System.out.println("Se ha registrado el jugador con exito!.");
    }

    /**
     * Metodo que transforma la Lista de usuarios a String para ser mostrado por pantalla.
     * @return String, que son los nombres de los usuarios registrados en la aplicacion.
     */

    public String userToString(){
        String salida = new String();
        Game game = getGame();
        ArrayList<String> userList = game.getUsuarios();
        salida = "Los usuarios registrados para cambiar son: \n";
        for(int i = 0; i < userList.size(); i++){
            salida = salida + (i+1)+ " " + userList.get(i) + "  ";
        }
        return salida;
    }

    /**
     * Metodo que crea un String con los contenidos del juegos visibles para el jugador al cual le corresponde el turno,
     * este string contiene, el nombre del jugador que le corresponde el turno, los puntos del jugador, el turno y las cartas que estan en mesa.
     * @return String, que es utilizado para mostrar por consola.
     */

    public String VisibletoString(){
        String salida = new String();
        Game game = getGame();
        salida = "Turno del jugador : " + game.getDobbleGame().whoseTurnIsIt() + "        ";
        for(int i = 0; i < game.getDobbleGame().getPlayers().size(); i++){
            if(game.getDobbleGame().getPlayers().get(i).getName().equals(game.getDobbleGame().whoseTurnIsIt())){
                salida = salida + " Turno: " + game.getDobbleGame().getPlayers().get(i).getTurn();
                salida = salida + "    Puntaje: " + score(game.getDobbleGame().getPlayers().get(i).getName()) +"\n";
            }
        }
        salida = salida + "\n      ---      ---- Cartas en Mesa ----      ---      \n" + "          " + game.getDobbleGame().getMesa().mesatoString() + "\n";
        salida = salida + " ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n  ";
        return salida;
    }

    /**
     * Metodo que crea un agrega una Cpu al juego y comienza el juego.
     */
    public void createPlayervCpu(){
        Game game = getGame();
        game.getDobbleGame().setTotalPlayers(2);
        Player cpu = new Player("CPU");
        game.getDobbleGame().getPlayers().add(cpu);
        game.getDobbleGame().setEstadoPartida(1);
    }

    /**
     * Metodo que modifica el juego, anadiendo 2 CPU al juego, para que empiezen una partida jugando entre ellas.
     */
    public void createCpuvCpu(){
        Game game = getGame();
        game.getDobbleGame().setTotalPlayers(2);
        game.getDobbleGame().setPlayers(new ArrayList<Player>());
        Player cpu1 = new Player("CPU");
        Player cpu2 = new Player("CPU1");
        game.getDobbleGame().getPlayers().add(cpu1);
        game.getDobbleGame().getPlayers().add(cpu2);
        game.getDobbleGame().setEstadoPartida(1);
    }

    /**
     * Metodo que retira 2 cartas del cardsSet(Dobble) para dejarlas en mesa.
     * @param modo (String), corresponde al modo que se utiliza en el juego.
     */

    public void nullGame(String modo) {
        Game game = getGame();
        if (modo.equals("Stack")) {
            if(game.getDobbleGame().getCardsSet().size() < 2 && game.getDobbleGame().getMesa().size() != 2){
                game.getDobbleGame().setEstadoPartida(2);
                return;
            }
            if(game.getDobbleGame().getMesa().size() == 0){
                game.getDobbleGame().getMesa().anadir(game.getDobbleGame().getCardsSet().nthCard(0));
                game.getDobbleGame().getMesa().anadir(game.getDobbleGame().getCardsSet().nthCard(1));
                game.getDobbleGame().getCardsSet().eliminarCarta(game.getDobbleGame().getCardsSet().nthCard(0));
                game.getDobbleGame().getCardsSet().eliminarCarta(game.getDobbleGame().getCardsSet().nthCard(0));
            }
        }
    }

    /**
     * Metodo que realiza la accion Pass del jugador, le suma 1 turno al jugador al cual le toca realizar su turno.
     * @param name (String), nombre del jugador que realiza la accion Pass.
     */

    public void passGame(String name){
        Game game = getGame();
        for(int i = 0; i < getGame().getDobbleGame().getPlayers().size(); i++){
            if(game.getDobbleGame().getPlayers().get(i).getName().equals(name)){
               int turn = game.getDobbleGame().getPlayers().get(i).getTurn();
               game.getDobbleGame().getPlayers().get(i).setTurn(turn+1);
            }
        }
    }

    /**
     * Metodo que obtiene el elemento en comun entre 2 cartas.
     * @param c1 (Card), corresponde a una carta a comparar
     * @param c2 (Card), corresponde a la segunda carta a comparar.
     * @return String, que es el elemento en comun entre las 2 cartas a la cual se le hizo la comparacion.
     */

    public String elementComun(Card c1, Card c2){
        String element = new String();
        for(int i = 0; i < c1.size(); i++){
            for(int j = 0; j < c2.size(); j++){
                if(c1.get(i).equals(c2.get(j))){
                    element = c1.get(i);
                }
            }
        }
        return element;
    }

    /**
     * Metodo que realiza la accion de jugar al juego Dobble, dependiendo del modo de juego.
     *  Stack : Si el jugador acierta el elemento en comun entre las cartas de la mesa, a este se le agregan las cartas a sus cartas y se le suma puntaje y se le suma el turno
     *  si este falla en el elemento en comun, se le suma un turno y no se realiza ninguna accion mas.
     *
     *   caso CPU: La CPU elige al azar entre 2 elementos en comun para realizar su jugada.
     *
     * @param modo (String), corresponde al modo de juego que tiene el juego.
     * @param element (String), corresponde al elemento que el jugador entrego y se compara si acierta con el elemento en comun entre las cartas de la mesa.
     * @param name  (String), nombre del jugador que realizo el turno.
     */

    public void playGame(String modo, String element, String name){
        Game game = getGame();
        if(modo.equals("Stack")){
            if(!name.contains("CPU")){
                String eComun = elementComun(game.getDobbleGame().getMesa().nthCard(0),game.getDobbleGame().getMesa().nthCard(1));
                if( eComun.equals(element)){
                    for(int i = 0; i < game.getDobbleGame().getPlayers().size(); i++ ){
                        if(game.getDobbleGame().getPlayers().get(i).getName().equals(name)){
                            int score = game.getDobbleGame().getPlayers().get(i).getScore();
                            game.getDobbleGame().getPlayers().get(i).setScore(score+1);
                            System.out.println("   ---   Ha acertado en el elemento en comun!:)    ---   \n");
                            game.getDobbleGame().getPlayers().get(i).getCards().anadir(game.getDobbleGame().getMesa().nthCard(0));
                            game.getDobbleGame().getPlayers().get(i).getCards().anadir(game.getDobbleGame().getMesa().nthCard(1));
                            game.getDobbleGame().setMesa(new Dobble());
                            passGame(name);
                        }
                    }
                }
                else{
                    System.out.println("   ---   Se ha equivocado en el Elemento en comun!   ---   \n");
                    passGame(name);
                }
            }
            if(name.contains("CPU")){
                Random rnd = new Random();
                String eComun = elementComun(game.getDobbleGame().getMesa().nthCard(0),game.getDobbleGame().getMesa().nthCard(1));
                ArrayList<String> lProb = new ArrayList<>();
                lProb.add(eComun);
                int index = rnd.nextInt((game.getDobbleGame().getMesa().nthCard(0).size()));
                if(!game.getDobbleGame().getMesa().nthCard(0).get(index).equals(eComun)){
                    lProb.add(game.getDobbleGame().getMesa().nthCard(0).get(index));
                }
                Random rnd2 = new Random();
                int index2 = rnd2.nextInt(lProb.size());
                if(lProb.get(index2).equals(eComun)){
                    for(int i = 0; i < game.getDobbleGame().getPlayers().size(); i++ ){
                        if(game.getDobbleGame().getPlayers().get(i).getName().equals(name)){
                            int score = game.getDobbleGame().getPlayers().get(i).getScore();
                            game.getDobbleGame().getPlayers().get(i).setScore(score+1);
                            System.out.println("   --- La CPU Ha acertado en el elemento en comun!   --- \n            ----- El elemento fue: "+ eComun +" -----   \n");
                            game.getDobbleGame().getPlayers().get(i).getCards().anadir(game.getDobbleGame().getMesa().nthCard(0));
                            game.getDobbleGame().getPlayers().get(i).getCards().anadir(game.getDobbleGame().getMesa().nthCard(1));
                            game.getDobbleGame().setMesa(new Dobble());
                            passGame(name);
                        }
                    }
                }
                else{
                    System.out.println("   --- La CPU Ha fallado el elemento en comun!   --- \n           ----- El elemento fue: "+ lProb.get(index2) +" -----   \n");
                    passGame(name);
                }
            }
        }
    }

    /**
     * Metodo crea un String con el juego finalizado, entregando (si se cumple) el ganador o los jugadores empatados.
     * @return String , que corresponde al ganador o jugadores empatados.
     */

    public String finishGame(){
        Game game = getGame();
        ArrayList<Player> players = game.getDobbleGame().getPlayers();
        ArrayList<Integer> totalScore = new ArrayList<>();
        String salida = new String();
        for(int i = 0; i < players.size(); i++){
            totalScore.add(players.get(i).getScore());
        }
        int mScore = Collections.max(totalScore);
        int cont = 0;
        for(int j =0; j < players.size(); j++){
            if(mScore == players.get(j).getScore()){
                cont = cont + 1;
            }
        }
        if(cont == 1){
            for(int k = 0; k < players.size(); k++){
                if(players.get(k).getScore() == mScore){
                    salida = salida + "\n     El Ganador del juego es : "+players.get(k).getName() + "\n     con un Puntaje de " + mScore +"\n" ;
                    salida = salida + "\n  ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----\n ";
                    return salida;
                }
            }
        }
        salida = "\n     Hubo un empate entre los jugadores : |  ";
        for(int h = 0; h < players.size(); h++){
            if(players.get(h).getScore() == mScore){
                salida = salida + players.get(h).getName() + "  ";
            }
        }
        salida = salida + "|";
        salida = salida + " \n     Ambos jugadores tuvieron un total de " + mScore + " Puntos\n";
        salida = salida + "\n  ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- \n";
        return salida;
    }
}
