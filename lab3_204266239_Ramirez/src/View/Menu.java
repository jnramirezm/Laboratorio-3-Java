package View;

import java.util.ArrayList;
import Controller.Controller;

import javax.annotation.processing.SupportedSourceVersion;
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
                            System.out.println("Has salido con exito!:c");
                            break;
                    }
                } catch (Exception e){
                    System.out.println("Solo es valido el ingreso de numeros");
                    scan.next();
                }
            }
            else{
                int selectRegister;
                System.out.println(" ##### DOBBLE ######");
                System.out.println("Usted esta registrado con el nombre: " + controller.getGame().getRegistrado());
                System.out.println("1. Crear Juego");
                System.out.println("2. Registrar nuevo usuario");
                System.out.println("3. Salir");
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
                            System.out.println("Ingrese modo de Juego: Stack , EmptyStack, EmptyHand");
                            scan.nextLine();
                            modo = scan.nextLine();
                            controller.crearGame(tPlayers, nMazo, modo);

                            while(controller.getGame().getGameCreado()) {
                                boolean salirPartida = false;
                                System.out.println(" ---------  Juego creado por " + controller.getGame().getRegistrado() + "  --------- ");
                                System.out.println("Jugadores en partida  " + controller.getGame().getDobbleGame().getPlayers().size() + "/" + controller.getGame().getDobbleGame().getTotalPlayers());
                                if (controller.getGame().getDobbleGame().getEstadoPartida() == 0) {
                                    System.out.println("1. Anadir jugador al juego");
                                    System.out.println("2. Empezar juego");
                                    System.out.println("3. Salir del Juego");
                                    try {
                                        System.out.println("Ingrese la opcion: ");
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
                                        controller.nullGame(modo);
                                        if (controller.getGame().getDobbleGame().getEstadoPartida() == 2){
                                            break;
                                        }
                                        System.out.println("-------- Partida en Progreso --------");
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
                                                    controller.playGame(modo,element, controller.getGame().getDobbleGame().whoseTurnIsIt());
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
                                    System.out.println(" -------- Partida Finalizada --------");
                                    System.out.println(controller.finishGame());
                                    System.out.println("1. Crear un nuevo Juego");
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
                            System.out.println(" Se ha registrado!");
                            controller.register(name);
                            break;
                        case 3:
                            salir = true;
                            System.out.println("Ha salido con exito");
                    }
                } catch (Exception e) {
                    System.out.println("Solo es valido el ingreso de numeros");
                    scan.next();
                }
            }
        }
    }
}


