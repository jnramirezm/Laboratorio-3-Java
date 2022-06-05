package View;

import java.util.ArrayList;
import Controller.Controller;
import Model.Player;

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
                System.out.println(" -------- DOBBLE --------");
                System.out.println("Usted no esta registrado");
                System.out.println("1. Registrarse");
                System.out.println("2. Salir");
                try{
                    System.out.println("Ingrese la opcion: ");
                    select = scan.nextInt();
                    switch (select){
                        case 1:
                            System.out.println("\n -------- Registro ---------");
                            System.out.println("Ingrese su nombre: ");
                            scan.nextLine();
                            name = scan.nextLine();
                            controller.register(name);
                            break;
                        case 2:
                            salir = true;
                            System.out.println("\n   ---   Has salido con exito!:c    ---   \n");
                            break;
                    }
                } catch (Exception e){
                    System.out.println("   ---   Solo es valido el ingreso de numeros   ---   \n");
                    scan.next();
                }
            }
            else{
                int selectRegister;
                System.out.println("    ---    DOBBLE    ---   ");
                System.out.println("Usted esta registrado con el nombre: " + controller.getGame().getRegistrado());
                System.out.println("1. Crear Juego");
                System.out.println("2. Registrar nuevo usuario");
                System.out.println("3. Cambiar de usuario");
                System.out.println("4. Salir");
                try{
                    System.out.println("Ingrese la opcion: ");
                    selectRegister = scan.nextInt();
                    switch (selectRegister){
                        case 1:
                            int tPlayers;
                            int nMazo;
                            String modo;
                            System.out.println(" ------ Creando juego ------");
                            System.out.println("Ingrese total de jugadores de la partida: ");
                            //scan.nextInt();
                            tPlayers = scan.nextInt();
                            System.out.println("Ingrese cantidad de elementos por carta: ");
                            //scan.nextInt();
                            nMazo = scan.nextInt();
                            System.out.println("Ingrese el modo que desea jugar: ");
                            System.out.println("1. Stack ");
                            System.out.println("2. EmptyHand ");
                            System.out.println("3. EmptyStack ");
                            try{
                                System.out.println("\nIngrese la opcion: ");
                                int selectModo = scan.nextInt();
                                switch (selectModo) {
                                    case 1:
                                        modo = "Stack";
                                        controller.crearGame(tPlayers, nMazo, modo);
                                        break;
                                    case 2:
                                        modo = "EmptyHand";
                                        controller.crearGame(tPlayers, nMazo, modo);
                                        break;
                                    case 3:
                                        modo = "EmptyStack";
                                        controller.crearGame(tPlayers, nMazo, modo);
                                        break;
                                }
                            } catch (Exception e) {
                                System.out.println("Solo es valido el ingreso de numeros");
                                scan.next();}
                            while(controller.getGame().getGameCreado()) {
                                boolean salirPartida = false;
                                System.out.println(" --------------  Juego creado por " + controller.getGame().getRegistrado() + "  -------------- ");
                                System.out.println("                Jugadores en partida  " + controller.getGame().getDobbleGame().getPlayers().size() + "/" + controller.getGame().getDobbleGame().getTotalPlayers() + "\n");
                                if (controller.getGame().getDobbleGame().getEstadoPartida() == 0) {
                                    System.out.println("1. Anadir jugador al juego");
                                    System.out.println("2. Empezar juego");
                                    System.out.println("3. Jugar vs la CPU");
                                    System.out.println("4. Salir del Juego");
                                    try {
                                        System.out.println("\nIngrese la opcion: ");
                                        int selectGame = scan.nextInt();
                                        switch (selectGame) {
                                            case 1:

                                                System.out.println(" -------- Registrando jugador a la partida ---------");
                                                System.out.println("Ingrese el nombre: ");
                                                scan.nextLine();
                                                name = scan.nextLine();
                                                controller.registerGame(name);
                                                break;
                                            case 2:
                                                controller.getGame().getDobbleGame().setEstadoPartida(1);
                                                break;
                                            case 3:
                                                controller.getGame().getDobbleGame().setTotalPlayers(2);
                                                Player cpu = new Player("CPU");
                                                controller.getGame().getDobbleGame().getPlayers().add(cpu);
                                                controller.getGame().getDobbleGame().setEstadoPartida(1);
                                                break;
                                            case 4:
                                                controller.getGame().setGameCreado(false);
                                                break;
                                        }

                                    } catch (Exception e) {
                                        System.out.println("Solo es valido el ingreso de numeros");
                                        scan.next();
                                    }
                                }
                                if (controller.getGame().getDobbleGame().getEstadoPartida() == 1){
                                    while(!salirPartida){
                                        int selectPartida;
                                        controller.nullGame(controller.getGame().getDobbleGame().getModo());
                                        if (controller.getGame().getDobbleGame().getEstadoPartida() == 2){
                                            break;
                                        }
                                        if(controller.getGame().getDobbleGame().whoseTurnIsIt().equals("CPU")){
                                            controller.playGame(controller.getGame().getDobbleGame().getModo(),"", controller.getGame().getDobbleGame().whoseTurnIsIt());
                                            System.out.println("               La CPU ha hecho su Turno\n");
                                            break;
                                        }
                                        System.out.println("------------------- Partida en Progreso -------------------");
                                        System.out.println(controller.VisibletoString());
                                        System.out.println(" Puede elegir entre estas opciones: ");
                                        System.out.println("1. spotIt");
                                        System.out.println("2. Pasar de turno");
                                        System.out.println("3. Finalizar el juego");
                                        try{
                                            System.out.println("Ingrese la opcion: ");
                                            selectPartida = scan.nextInt();
                                            switch (selectPartida) {
                                                case 1:
                                                    System.out.println("Ingrese el elemento en comun entre las cartas");
                                                    scan.nextLine();
                                                    String element = scan.nextLine();
                                                    controller.playGame(controller.getGame().getDobbleGame().getModo(),element, controller.getGame().getDobbleGame().whoseTurnIsIt());
                                                    break;
                                                case 2:
                                                    controller.passGame(controller.getGame().getDobbleGame().whoseTurnIsIt());
                                                    System.out.println("Ha pasado de turno!\n");
                                                    break;
                                                case 3:
                                                    controller.getGame().getDobbleGame().setEstadoPartida(2);
                                                    break;
                                            }
                                        } catch (Exception e) {
                                            System.out.println("Solo es valido el ingreso de numeros");
                                            scan.next();
                                        }
                                        break;
                                    }
                                }
                                if(controller.getGame().getDobbleGame().getEstadoPartida() == 2) {
                                    System.out.println(" ------------------- Partida Finalizada -------------------");
                                    System.out.println(controller.finishGame());
                                    System.out.println("1. Volver al Menu");
                                    System.out.println("2. Salir de la plataforma");
                                    try{
                                        System.out.println("Ingrese la opcion: " );
                                        int selectFinalizado = scan.nextInt();
                                        switch (selectFinalizado){
                                            case 1:
                                                controller.getGame().setGameCreado(false);
                                                break;
                                            case 2:
                                                controller.getGame().setGameCreado(false);
                                                salir = true;
                                                System.out.println(" Ha salido con exito!\n");
                                                break;
                                        }

                                    } catch (Exception e) {
                                        System.out.println("Solo es valido el ingreso de numeros");
                                        scan.next();
                                    }
                                }
                            }
                            break;
                        case 2:
                            System.out.println(" -------- Registro ---------");
                            System.out.println("Ingrese el nombre a registrar: ");
                            scan.nextLine();
                            name = scan.nextLine();
                            controller.register(name);
                            break;
                        case 3:
                            int nUser;
                            System.out.println(controller.userToString());
                            System.out.println("Ingrese el numero del usuario a cambiar.");
                            nUser = scan.nextInt();
                            controller.getGame().setRegistrado(controller.getGame().getUsuarios().get(nUser-1));
                            break;
                        case 4:
                            salir = true;
                            System.out.println("Ha salido con exito");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Solo es valido el ingreso de numeros");
                    scan.next();
                }
            }
        }
    }
}


