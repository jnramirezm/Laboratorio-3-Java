package Main;

import Model.*;
import Controller.Controller;
import View.Menu;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
       Dobble d1 =  new Dobble(4,11);
       Dobble d2 = new Dobble(4,12);
       System.out.println(d1.equals(d2));

      //  Game game = new Game();
      //  Controller controller = new Controller(game);
      //  Menu menu = new Menu(controller);
      //  menu.menu();
      //  return;
    }
}