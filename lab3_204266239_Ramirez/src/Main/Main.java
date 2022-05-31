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