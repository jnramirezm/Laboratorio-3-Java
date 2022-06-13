package Main;

import Model.*;
import Controller.Controller;
import View.Menu;

public class Main {
    public static void main(String[] args){
        Game game = new Game();
        Controller controller = new Controller(game);
        Menu menu = new Menu(controller);
        menu.menu();
        return;
    }
}

/*
    Ejemplos

    ArrayList<String> elementos = new ArrayList<>();
    elementos.add("a");
    elementos.add("b");
    elementos.add("c");
    Card carta1 = new Card(elementos);
    ArrayList<String> elementos2 = new ArrayList<>();
    elementos2.add("a");
    elementos2.add("c");
    elementos2.add("d");
    Card carta2 = new Card(elementos2);
    System.out.println(carta1.equals(carta2));
    System.out.println(carta1.ElemRep());
    carta1.anadirElement("a");
    System.out.println(carta1.ElemRep());
    System.out.println(carta1);

     Dobble d1 = new Dobble(4,5);
        Dobble d2 = new Dobble(4,0);
        Dobble d3 = new Dobble(5,0);

        System.out.println(d2.nthCard(4));

        System.out.println(d1.findTotalCards());
        System.out.println(d1.missingCards(d1));

        System.out.println(d1.isDobble());
        System.out.println(d3.isDobble());

        System.out.println(d1.toString());

        DobbleGame g1 = new DobbleGame(3,4,"Stack");
        System.out.println(g1);

        Otros metodos se pueden probar dentro del menu--
*/