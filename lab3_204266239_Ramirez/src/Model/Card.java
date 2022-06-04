package Model;

import Interface.Elementos;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Collections;

/**
 * Clase que simula una carta, que contiene elementos, estos elementos son una lista de String
 * @version 11.0.15
 * @autos Juan Ramirez Montero
 */

public class Card implements Elementos {
    private ArrayList<String> num;


    public Card(){
        this.num = new ArrayList<String>();
    }

    public Card(ArrayList<String> num){

        this.num = num;
        Collections.shuffle(num);
    }

    /**
     * obtiene los elementos (Lista de string) de una carta
     * @return un ArrayList de tipo String al obtener la lista de elementos
     */

    public ArrayList<String> getNum() {
        return num;
    }

    public void setNum(ArrayList<String> num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "" +
                num
                ;
    }
    public Integer size(){
        return num.size();
    }

    public String get(Integer n){
        return num.get(n);
    }

    public boolean ElemRep(){
        ArrayList<String> eCard = getNum();
        for(int i = 0; i < eCard.size()-1; i++){
            if(eCard.get(i).equals(eCard.get(i+1))){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(num, card.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
