package Interface;

public interface Elementos {

    /**
     * obtiene el total de elementos que posee la carta (Integer)
     * @return (Integer) total de elementos de la carta.
     */
    public Integer size();

    /**
     * obtiene el boolean dependiendo si se encuentra un elemento repetido en la carta este boolean sera verdadero, si no se encuentre el mismo elemento es false
     * @return (boolean) Dependiendo si encuentra un elemento repetido en la carta.
     */
    public boolean ElemRep();

    /**
     * anade un elemento (String) a la lista de Elementos
     * @param e (String). el elemento deseado a anadir a la carta.
     */
    public void anadirElement(String e);

    /**
     * Metodo que obtiene un boolean entre la comparacion de las cartas.
     * @param o (Object), corresponde a un objecto con el contenido de una carta (ArrayList de String)
     * @return boolean, True si las cartas comparadas son iguales, false si no.
     */
    public boolean equals(Object o);

    /**
     * Convierte el contenido (elementos) de la carta a string.
     * @return String, los elementos de la carta.
     */
    public String toString();
}
