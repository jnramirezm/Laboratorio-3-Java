package Interface;

import Model.Card;
import Model.Dobble;

public interface cardsSet {

    /**
     * Entrega un boolean dependiendo si el deck cumple las condiciones impuestas para que este sirva para el juego Dobble.
     * @return (boolean), True si es un deck que permite jugar sin problemas y False si no.
     */
    public Boolean isDobble();

    /**
     * Entrega una Carta (Card) en el indice deseado
     * @param n (Integer). Corresponde al indice de la carta que se desea obtener.
     * @return Card, una carta en la posicion deseada.
     */
    public Card nthCard(Integer n);

    /**
     * Entrega el total de Cartas que pueden existir en un mazo.
     * @return (Integer) corresponde al total de cartas de un deck.
     */

    public Integer findTotalCards();

    /**
     * Entrega las cartas faltantes de un deck, al cual se le entregan una cantidad de cartas.
     * @param cartas (Dobble). Corresponde a cartas (Dobble) para encontrar sus cartas faltantes.
     * @return (Dobble) con las cartas faltantes de las cartas inicialmentes dadas.
     */
    public Dobble missingCards(Dobble cartas);

    /**
     * Entrega el total de cartas en el mazo (Lista de Cartas)
     * @return (Integer) total de cartas.
     */

    public Integer size();

    /**
     * Modifica el deck, eliminando la carta entregada.
     * @param index (Card). Corresponde a la carta a Eliminar del deck.
     */
    public void eliminarCarta(Card index);

    /**
     * Metodo que obtiene un boolean entre la comparacion de 2 Dobble.
     * @param o (Object) que posee el contenido de un Dobble.
     * @return boolean, dependiendo del resultado de la comparacion entre los 2 Dooble.
     */
    public boolean equals(Object o);
}
