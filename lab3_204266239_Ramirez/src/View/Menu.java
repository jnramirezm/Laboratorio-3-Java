package View;

import java.util.ArrayList;
import Controller.Controller;
import java.util.Scanner;


public class Menu {
    private Controller controller;

    public Menu(Controller controller){
        this.controller = controller;
    }
    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void menu(){
        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        int select;
        String name;
        Controller controller = getController();
        while(!salir){
            if(!controller.estaRegistrado()){
                System.out.println(" ##### DOBBLE ######");
                System.out.println("Usted no esta registrado");
                System.out.println("1. Registrarse");
                System.out.println("2. Salir");
                try{
                    System.out.println("Ingrese la opcion: ");
                    select = scan.nextInt();
                    switch (select){
                        case 1:
                            System.out.println(" -------- Registro ---------");
                            System.out.println("Ingrese su nombre: ");
                            scan.nextLine();
                            name = scan.nextLine();
                            System.out.println(" Se ha registrado!");
                            controller.register(name);
                            controller.registradoconexito();
                            break;
                        case 2:
                            salir = true;
                            break;
                    }
                } catch (Exception e){
                    System.out.println("Solo es valido el ingreso de numeros");
                    scan.next();
                }
            }
        }
    }
}


