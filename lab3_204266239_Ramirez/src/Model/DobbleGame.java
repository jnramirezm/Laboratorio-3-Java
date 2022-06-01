package Model;
import java.util.ArrayList;
import java.util.Collections;

public class DobbleGame {
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

    public Dobble getCardsSet() {
        return cardsSet;
    }

    public void setCardsSet(Dobble cardsSet) {
        this.cardsSet = cardsSet;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Integer getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(Integer totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public Integer getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(Integer estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    public Dobble getMesa() {
        return mesa;
    }

    public void setMesa(Dobble mesa) {
        this.mesa = mesa;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

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

    @Override
    public String toString() {
        String salida = new String();
        salida = "  -------- Juego --------\n" + "Modo de juego: " + getModo() +"\nCapacidad de jugadores : " + getTotalPlayers()  +  "\nMazo en juego = " + getCardsSet() +"\n";
        if( getEstadoPartida() == 0){
        salida = salida + "La partida se encuentra en proceso de registro de jugadores\n";
        }
        if( getEstadoPartida() == 1){
        salida = salida + "La partida esta en proceso\n";
        }
        if( getEstadoPartida() == 2){
        salida = salida + "La partida esta finalizada\n";
        }
        for(int i = 0; i < getPlayers().size(); i++) {
            salida = salida + getPlayers().get(i) + "\n";
        }
        if(getMesa().size() >= 1){
            salida = salida + "Mesa del juego = " + getMesa();
        }
        return salida;
    }

}
