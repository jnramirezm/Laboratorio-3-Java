package Model;

import Interface.Elementos;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Collections;

/**
 * Clase que simula una carta, que contiene elementos, estos elementos son una lista de String
 * @version 11.0.15
 * @autor Juan Ramirez Montero
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

    /**
     *  Modifica los elementos (List de Strings) de la carta
     * @param elements (ArrauList<String>) los elementos de la carta.
     */

    public void setElements(ArrayList<String> elements) {
        this.elements = elements;
    }

    /**
     * anade un elemento (String) a la lista de Elementos
     * @param e (String). el elemento deseado a anadir a la carta.
     */

    public void anadirElement(String e){
        elements.add(e);
    }

    /**
     * Convierte el contenido (elementos) de la carta a string.
     * @return String, los elementos de la carta.
     */

    @Override
    public String toString() {
        return "" +
                elements
                ;
    }

    /**
     * obtiene el total de elementos que posee la carta (Integer)
     * @return (Integer) total de elementos de la carta.
     */
    public Integer size(){
        return elements.size();
    }

    /**
     * obtiene el elemento (String) de la posicion n (Integer) de la carta
     * @param n (Integer) indice del elemento que se desea obtener
     * @return el elemento (String) en la posicion n de la carta.
     */
    public String get(Integer n){
        return elements.get(n);
    }

    /**
     * obtiene el boolean dependiendo si se encuentra un elemento repetido en la carta este boolean sera verdadero, si no se encuentre el mismo elemento es false
     * @return (boolean) Dependiendo si encuentra un elemento repetido en la carta.
     */
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
        int cont = 0;
        for(int i = 0; i < elements.size(); i++){
            for(int j = 0; j < card.size(); j++){
                if(elements.get(i).equals(card.getElements().get(j))){
                    cont= cont + 1;
                }
            }
        }
        if(cont == elements.size()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }
}
