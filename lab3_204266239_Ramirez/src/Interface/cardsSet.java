package Interface;

import Model.Card;
import Model.Dobble;

public interface cardsSet {

    public Boolean isDobble();

    public Card nthCard(Integer n);

    public Integer findTotalCards();

    public Dobble missingCards(Dobble cartas);

    public Integer size();

    public void eliminarCarta(Card index);
}
