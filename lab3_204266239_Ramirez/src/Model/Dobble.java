package Model;

import Interface.cardsSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Clase que simula un Mazo de tipo Dobble (Que tiene un tipo de caracteristicas especiales para el juego)
 * el cual contiene un mazo (Listas de cartas).
 * @version 11.0.15
 * @autor Juan Ramirez Montero
 */
public class Dobble implements cardsSet{
    private ArrayList<Card> deck;

    public Dobble(){
        this.deck = new ArrayList<>();
    }

    public Dobble(Integer num, Integer maxC){
        int numE = num - 1;
        ArrayList<String> elements = new ArrayList<String>();
        deck = new ArrayList<>();
        for(int i=1; i<= numE+1; i++){
            elements.add(Integer.toString(i));
        }
        ;
        deck.add(new Card(elements));
        for(int j = 1; j<= numE; j++){
            Card card1 = new Card();
            card1.anadirElement(Integer.toString(1));
            for(int k = 1; k<= numE; k++){
                card1.anadirElement(Integer.toString((numE * j + (k+1))));
            }
            Collections.shuffle(card1.getElements());
            deck.add(card1);
        }
        for (int u = 1; u <= numE; u++){
            for(int l = 1; l <= numE; l++){
                Card card2 = new Card();
                card2.anadirElement(Integer.toString((u+1)));
                for(int p = 1; p <= numE; p++){
                    card2.anadirElement(Integer.toString((numE+2+numE*(p-1)+(((u-1)*(p-1)+l-1)%numE))));
                }
                Collections.shuffle(card2.getElements());
                deck.add(card2);
            }
        }
        if(maxC > 1){
            ArrayList<Card> deck2 = new ArrayList<>();
            for(int y = 0; y < maxC; y++){
                deck2.add(deck.get(y));
            }
            this.deck = deck2;
        }
        Collections.shuffle(deck);
    }

    /**
     * Obtiene el deck (Lista de Cartas) del Dobble
     * @return deck (Lista de Cartas) todas las cartas del deck.
     */

    public ArrayList<Card> getDeck() {
        return deck;
    }

    /**
     *
     * @param deck
     */

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }


    /**
     * Entrega el total de cartas en el mazo (Lista de Cartas)
     * @return (Integer) total de cartas.
     */

    public Integer size(){
        return deck.size();
    }

    /**
     * anade una carta (Card) al deck  (Lista de Cartas)
     * @param carta (Card). Corresponde a una carta.
     */

    public void anadir(Card carta){
        deck.add(carta);
    }

    /**
     * Entrega una Carta (Card) en el indice deseado
     * @param i (Integer). Corresponde al indice de la carta que se desea obtener.
     * @return Card, una carta en la posicion deseada.
     */

    public Card nthCard(Integer i){
        if( i < 0 ){
            return new Card();
        }
        return deck.get(i);
    }

    /**
     * Entrega el total de Cartas que pueden existir en un mazo, dada una carta de muestra.
     * @param carta (Card). Corresponde a una carta.
     * @return (Integer) corresponde al total de cartas de un deck, el cual se obtuvo de una carta de muestra.
     */

    public Integer findTotalCards(Card carta){
        if (carta.ElemRep()){
            return 0;
        }
        Dobble nD = new Dobble(carta.size(),0);
        if(!nD.isDobble()){
            return 0;
        }
        return nD.size();
    }

    /**
     * Modifica el deck, eliminando la carta entregada.
     * @param index (Card). Corresponde a la carta a Eliminar del deck.
     */

    public void eliminarCarta(Card index){
        deck.remove(index);
    }

    /**
     * Convierte las cartas (Card) del decK(Lista de cartas) a String, para luego ser mostradas por pantalla
     * @return salida (String). un String con las cartas del mazo.
     */

    @Override
    public String toString() {
        String salida = new String();
        salida = salida + "------ Cartas ------";
        for(int i = 0; i < getDeck().size(); i++){
            salida = salida + " \nCarta = " + nthCard(i);
        }
        salida = salida + "\n------------------";
        return salida;
    }

    /**
     * Convierte las cartas de un jugador a String, a diferencia del ToString este metodo las deja en una sola linea y no en diferentes.
     * @return salida (Salida). Un String con las cartas del jugador.
     */

    public String cartasJugadortoString() {
        String salida = new String();
        salida = salida + "-- Cartas --";
        for(int i = 0; i < getDeck().size(); i++){
            salida = salida + " \nCarta = " + nthCard(i);
        }
        salida = salida + "\n----------";
        return salida;
    }

    /**
     * Convierte las cartas que estan Mesa a String.
     * @return salida (String), un String con las cartas en Mesa.
     */

    public String mesatoString(){
        String salida = new String();
        for(int i = 0; i < getDeck().size(); i++){
            salida = salida + nthCard(i) + " ";
        }
        return salida;
    }

    /**
     * Entrega un boolean dependiendo si el deck cumple las condiciones impuestas para que este sirva para el juego Dobble.
     * @return (boolean), True si es un deck que permite jugar sin problemas y False si no.
     */


    public Boolean isDobble(){
        for(int i = 0; i < deck.size(); i++) {
           if(nthCard(i).ElemRep()){                                // Carta no tiene elementos en comun
               return false;
           }
           for (int j = 0; j < deck.size(); j++) {
               if (nthCard(i).equals(nthCard(j))  && i != j){       // No hay cartas iguales
                   return false;
               }
           }
           for(int p = 0; p < deck.size(); p++){
               if(nthCard(i).size() != nthCard(p).size()){          // Todas las cartas tienen la misma cantidad de elementos
                   return false;
               }
           }
           for(int k = 0; k < deck.size(); k++){
               int cont = 0;
               if(!nthCard(i).equals(nthCard(k))){                  // Todas las cartas tienen por lo menos 1 elemento en comun.
                   for(int v = 0; v < nthCard(i).size(); v++){
                       for(int f = 0; f < nthCard(k).size(); f++){
                           if(nthCard(i).get(v).equals(nthCard(k).get(f))){
                               cont = cont + 1;
                           }
                           if(cont != 1 && v == nthCard(i).size()-1 && f == nthCard(k).size()-1){
                               return false;
                           }
                       }
                   }
               }
               }

       }

       return true;
    }

    /**
     * Entrega las cartas faltantes de un deck, al cual se le entregan una cantidad de cartas.
     * @param cartas (Dobble). Corresponde a cartas (Dobble) para encontrar sus cartas faltantes.
     * @return (Dobble) con las cartas faltantes de las cartas inicialmentes dadas.
     */

    public Dobble missingCards( Dobble cartas ){
        if (!cartas.isDobble()){
            return new Dobble();
        }
        int n = cartas.nthCard(0).size();
        int ndobble = nthCard(0).size();
        int tdobble = deck.size();
        Dobble deck3 = new Dobble(ndobble, tdobble);
        Dobble deck2 = new Dobble();
        if(n == deck3.nthCard(0).size()){
            for(int i = 0; i < deck3.size(); i++){
                int cont = 0;
                for(int j = 0; j < cartas.size(); j++){
                    if(deck3.nthCard(i).equals(cartas.nthCard(j))){
                        cont = cont + 1;
                    }
                    if(cont == 0 && j == cartas.size()-1){
                        deck2.anadir(deck3.nthCard(i));
                    }
                }
            }
        }
        return deck2;
    }

    /**
     * Metodo que obtiene un boolean entre la comparacion de 2 Dobble.
     * @param o (Object) que posee el contenido de un Dobble.
     * @return boolean, dependiendo del resultado de la comparacion entre los 2 Dooble.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dobble dobble = (Dobble) o;
        if (getDeck().size() != dobble.size()){
            return false;
        }
        int cont = 0;
        for(int i = 0; i < deck.size(); i++){
            for(int j = 0; j < dobble.size(); j++){
                if(nthCard(i).equals(dobble.nthCard(j))){
                    cont= cont + 1;
                }
            }
        }
        return cont == deck.size();
    }

    @Override
    public int hashCode() {
        return Objects.hash(deck);
    }
}

