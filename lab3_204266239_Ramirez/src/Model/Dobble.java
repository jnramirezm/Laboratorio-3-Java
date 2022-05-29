package Model;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Dobble {
    private ArrayList<Card> deck;
    private ArrayList<String> card;
    private Integer numE;

    public Dobble(){
        this.deck = new ArrayList<>();
    }

    public Dobble(ArrayList<Card> deck){
        this.deck = deck;
    }

    public Dobble(Integer num, Integer maxC){
        this.numE = num - 1;
        this.card = new ArrayList<>();
        deck = new ArrayList<>();
        for(int i=1; i<= numE+1; i++){
            card.add(Integer.toString(i));
        }
        deck.add(new Card(card));
        for(int j = 1; j<= numE; j++){
            this.card = new ArrayList<>();
            card.add(Integer.toString(1));
            for(int k = 1; k<= numE; k++){
                card.add(Integer.toString((numE * j + (k+1))));
            }
            deck.add(new Card (card));
        }
        for (int u = 1; u <= numE; u++){
            for(int l = 1; l <= numE; l++){
                card = new ArrayList<>();
                card.add(Integer.toString((u+1)));
                for(int p = 1; p <= numE; p++){
                    card.add(Integer.toString((numE+2+numE*(p-1)+(((u-1)*(p-1)+l-1)%numE))));
                }
                deck.add(new Card(card));
            }
        }
        if(maxC > 1){
            ArrayList<Card> deck2 = new ArrayList<>();
            for(int y = 0; y < maxC; y++){
                deck2.add(deck.get(y));
            }
            this.deck = deck2;
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
    public ArrayList<String> getCard() {
        return card;
    }

    public void setCard(ArrayList<String> card) {
        this.card = card;
    }

    public Integer getNumE() {
        return numE;
    }

    public void setNumE(Integer numE) {
        this.numE = numE;
    }

    public Card get(Integer n){
        return deck.get(n);
    }

    public Integer size(){
        return deck.size();
    }

    public void anadir(Card carta){
        deck.add(carta);
    }

    public void eliminarCarta(Integer index){
        deck.remove(index);
    }

    @Override
    public String toString() {
        return
                "deck=" + deck
                ;
    }



    public Boolean isDobble(){
        for(int i = 0; i < deck.size()-1; i++) {
           for(int u = 0; u < deck.get(i).size()-1; u++){
               for(int y = 1; y < deck.get(i).size(); y++){
                   if(deck.get(i).get(u).equals(deck.get(i).get(y)) && u != y){
                       return false;
                   }
               }
           }
           for (int j = 1; j < deck.size(); j++) {
               if (deck.get(i).equals(deck.get(j))  && i != j){
                   return false;
               }
           }
           for(int k = 1; k < deck.size(); k++){
               int cont = 0;
               for(int v = 0; v < deck.get(i).size(); v++){
                   for(int f = 0; f < deck.get(k).size(); f++){
                       if(deck.get(i).get(v).equals(deck.get(k).get(f)) && i != k){
                           cont = cont + 1;
                       }
                       if(cont > 1){
                           return false;
                       }
                   }
               }
           }
       }

       return true;
    }

    public Dobble missingCards( Dobble cartas ){
        int n = cartas.get(0).size();
        int ndobble = deck.get(0).size();
        int tdobble = deck.size();
        Dobble deck3 = new Dobble(ndobble, tdobble);
        Dobble deck2 = new Dobble();
        if(n == deck3.get(0).size()){
            for(int i = 0; i < deck3.size(); i++){
                int cont = 0;
                for(int j = 0; j < cartas.size(); j++){
                    if(deck3.get(i).equals(cartas.get(j))){
                        cont = cont + 1;
                    }
                    if(cont == 0 && j == cartas.size()-1){
                        deck2.anadir(deck3.get(i));
                    }
                }
            }
        }
        return deck2;
    }
}

