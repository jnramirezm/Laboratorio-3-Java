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
    private ArrayList<String> elements;


    public Card(){
        this.elements = new ArrayList<String>();
    }

    public Card(ArrayList<String> elements){

        this.elements = elements;
        Collections.shuffle(elements);
    }

    /**
     * obtiene los elementos (Lista de string) de una carta
     * @return un ArrayList de tipo String al obtener la lista de elementos
     */

    public ArrayList<String> getElements() {
        return elements;
    }

    public void setElements(ArrayList<String> elements) {
        this.elements = elements;
    }

    public void anadirElement(String e){
        elements.add(e);
    }

    @Override
    public String toString() {
        return "" +
                elements
                ;
    }
    public Integer size(){
        return elements.size();
    }

    public String get(Integer n){
        return elements.get(n);
    }

    public boolean ElemRep(){
        ArrayList<String> eCard = getElements();
        for(int i = 0; i < eCard.size(); i++){
            for(int j = 0; j < eCard.size(); j++){
                if(eCard.get(i).equals(eCard.get(j)) && j != i){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(elements, card.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
