package Main;

import Model.*;
import Controller.Controller;

public class Main {
    public static void main(String[] args){
        Dobble d = new Dobble(4,0);
        Dobble c = new Dobble(4,5);
        System.out.println(d.getDeck());
    }
}
