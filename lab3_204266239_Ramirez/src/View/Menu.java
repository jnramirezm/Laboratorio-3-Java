package View;

import Controller.Controller;
import java.util.Scanner;

/**
 * Clase que simula un menu con el que el usuario puede interactuar, contiene un controlador.
 * @version 11.0.15
 * @autor Juan Ramirez Montero
 */

public class Menu {
    private Controller controller;

    public Menu(Controller controller){
        this.controller = controller;
    }

    /**
     * Obtiene el controlador
     * @return Controller, si es que se obtiene el controlador.
     */

    public Controller getController() {
        return controller;
    }

    /**
     * Modifica el controlador del menu.
     * @param controller (Controller), corresponde a un controlador que controla todo el contenido del menu y clases.
     */

    public void setController(Controller controller) {
        this.controller = controller;
    }

    /**
     * Metodo que inicia el menu con el cual el usuario interactua.
     */

    public void menu(){
        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        int select;
        String name;
        Controller controller = getController();
        while(!salir){
            if(!controller.estaRegistrado()){                   // Verificacion si hay un user registado
                System.out.println(" -------- DOBBLE --------");
                System.out.println("Usted no esta registrado");
                System.out.println("1. Registrarse");
                System.out.println("2. Salir");
                try{
                    System.out.println("Ingrese la opcion: ");
                    select = scan.nextInt();
                    switch (select){
                        case 1:                 // Registro de usuario
                            System.out.println("\n -------- Registro ---------");
                            System.out.println("Ingrese su nombre: ");
                            scan.nextLine();
                            name = scan.nextLine();
                            controller.register(name);
                            break;
                        case 2:             // Salir de la aplicacion
                            salir = true;
                            System.out.println("\n   ---   Has salido con exito!:c    ---   \n");
                            break;
                    }
                } catch (Exception e){
                    System.out.println("   ---   Solo es valido el ingreso de numeros y de las opciones indicadas   ---   \n");
                    scan.next();
                }
            }
            else{                                           // Existe un usuario registado
                int selectRegister;
                System.out.println("    ---    DOBBLE    ---   ");
                System.out.println("Usted esta registrado con el nombre: " + controller.getUserRegistrado());
                System.out.println("1. Crear Juego");
                System.out.println("2. Registrar nuevo usuario");
                System.out.println("3. Cambiar de usuario");
                System.out.println("4. Salir");
                try{
                    System.out.println("Ingrese la opcion: ");
                    selectRegister = scan.nextInt();
                    switch (selectRegister){
                        case 1:                     // CREAR JUEGO  Y SE PIDEN LOS DATOS AL USUARIO PARA LA CREACION
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
                          //  System.out.println("2. EmptyHand ");
                          //  System.out.println("3. EmptyStack ");
                            try{
                                System.out.println("\nIngrese la opcion: ");
                                int selectModo = scan.nextInt();
                                switch (selectModo) {
                                    case 1:
                                        modo = "Stack";
                                        controller.crearGame(tPlayers, nMazo, modo);
                                        break;
                                 //   case 2:
                                 //       modo = "EmptyHand";
                                 //       controller.crearGame(tPlayers, nMazo, modo);
                                 //       break;
                                 //   case 3:
                                 //       modo = "EmptyStack";
                                 //       controller.crearGame(tPlayers, nMazo, modo);
                                 //       break;
                                }
                            } catch (Exception e) {
                                System.out.println("Solo es valido el ingreso de numeros y de las opciones indicadas");
                                scan.next();
                            }
                            while(controller.getGame().getGameCreado()) {                       // SELECCION DENTRO DEL JUEGO CREADO
                                boolean salirPartida = false;
                                System.out.println(" --------------  Juego creado por " + controller.getUserRegistrado() + "  -------------- ");
                                System.out.println("                Jugadores en partida  " + controller.sizePlayers() + "/" + controller.totalPlayers() + "\n");
                                if (controller.getEstadoGame() == 0) {
                                    System.out.println("1. Anadir jugador al juego");
                                    System.out.println("2. Empezar juego");
                                    System.out.println("3. Jugar vs la CPU");
                                    System.out.println("4. CPU vs CPU");
                                    System.out.println("5. Salir del Juego");
                                    try {
                                        System.out.println("\nIngrese la opcion: ");
                                        int selectGame = scan.nextInt();
                                        switch (selectGame) {
                                            case 1:                             // ANADIR JUGADORES AL JUEGO
                                                System.out.println(" -------- Registrando jugador a la partida ---------");
                                                System.out.println("Ingrese el nombre: ");
                                                scan.nextLine();
                                                name = scan.nextLine();
                                                controller.registerGame(name);
                                                break;
                                            case 2:                         // SE EMPIEZA EL JUEGO
                                                if(controller.sizePlayers() != controller.totalPlayers()){
                                                    System.out.println("  --- --  Aun no se registran todos los jugadores  -- ---\n");
                                                    break;
                                                }
                                                controller.setEstadoP(1);
                                                break;
                                            case 3:                         // SE CREA UN JUEGO DEL JUGADOR CONTRA UNA CPU
                                                controller.createPlayervCpu();
                                                break;
                                            case 4:                         // CPU vs CPU
                                                controller.createCpuvCpu();
                                                break;
                                            case 5:                         // SALIR DEL JUEGO
                                                controller.setGameC(false);
                                                break;
                                        }

                                    } catch (Exception e) {
                                        System.out.println("Solo es valido el ingreso de numeros y de las opciones indicadas");
                                        scan.next();
                                    }
                                }
                                if (controller.getEstadoGame() == 1){                   //PARTIDA EN JUEGO
                                    while(!salirPartida){
                                        int selectPartida;
                                        controller.nullGame(controller.getModoGame());
                                        if (controller.getEstadoGame() == 2){
                                            break;
                                        }
                                        if(controller.turnoJugador().equals("CPU") || controller.turnoJugador().equals("CPU1") ){
                                            System.out.println("------------------- Partida en Progreso -------------------");
                                            System.out.println(controller.VisibletoString());
                                            controller.playGame(controller.getModoGame(),"", controller.turnoJugador());
                                            break;
                                        }
                                        System.out.println("------------------- Partida en Progreso -------------------");
                                        System.out.println(controller.VisibletoString());
                                        System.out.println(" Puede elegir entre estas opciones: ");
                                        System.out.println("1. spotIt");
                                        System.out.println("2. Pasar de Turno");
                                        System.out.println("3. Finalizar el juego");
                                        try{
                                           System.out.println("Ingrese la opcion: ");
                                           selectPartida = scan.nextInt();
                                           switch (selectPartida){
                                               case 1:                  // SELECCIONA UN ELEMENTO EN COMUN
                                                   System.out.println("Ingrese el elemento en comun entre las cartas");
                                                   scan.nextLine();
                                                   String element = scan.nextLine();
                                                   controller.playGame(controller.getModoGame(), element, controller.turnoJugador());
                                                   break;
                                               case 2:              // PASA DE TURNO
                                                   controller.passGame(controller.turnoJugador());
                                                   System.out.println("\n          -------- Ha pasado de turno!  --------\n");
                                                   break;
                                               case 3:              // SE FINALIZA EL JUEGO
                                                   controller.setEstadoP(2);
                                                   break;
                                           }
                                       } catch(Exception e){
                                           System.out.println("Solo es valido el ingreso de numeros y de las opciones indicadas");
                                           scan.next();
                                       }
                                        break;
                                    }
                                }
                                if(controller.getEstadoGame() == 2) {           // PARTIDA FINALIZADA
                                    System.out.println(" ------------------- Partida Finalizada -------------------");
                                    System.out.println(controller.finishGame());
                                    System.out.println("1. Volver al Menu");
                                    System.out.println("2. Salir de la plataforma");
                                    try{
                                        System.out.println("Ingrese la opcion: " );
                                        int selectFinalizado = scan.nextInt();
                                        switch (selectFinalizado){
                                            case 1:             // VOLVER AL MENU
                                                controller.getGame().setGameCreado(false);
                                                break;
                                            case 2:             // SALIR DE LA APLICACION
                                                controller.getGame().setGameCreado(false);
                                                salir = true;
                                                System.out.println(" Ha salido con exito!\n");
                                                break;
                                        }

                                    } catch (Exception e) {
                                        System.out.println("Solo es valido el ingreso de numeros y de las opciones indicadas");
                                        scan.next();
                                    }
                                }
                            }
                            break;
                        case 2:             // REGISTRAR UN USUARIO A LA APLICACION
                            System.out.println(" -------- Registro ---------");
                            System.out.println("Ingrese el nombre a registrar: ");
                            scan.nextLine();
                            name = scan.nextLine();
                            controller.register(name);
                            break;
                        case 3:         // CAMBIAR DE USUARIO EN LA APLICACION
                            int nUser;
                            System.out.println(controller.userToString());
                            System.out.println("Ingrese el numero del usuario a cambiar.");
                            nUser = scan.nextInt();
                            controller.setUserR(controller.getUsern(nUser-1));
                            break;
                        case 4:         // SALIR DE LA APLICACION.
                            salir = true;
                            System.out.println("Ha salido con exito");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Solo es valido el ingreso de numeros y de las opciones indicadas");
                    scan.next();
                }
            }
        }
    }
}


