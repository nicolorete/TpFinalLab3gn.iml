package com.company;

import com.company.DataBase;
import com.google.gson.Gson;
import com.company.DataBase;
import java.io.*;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Login {

    List<Client> clients;


    public static void menuLogin() {

        /*String[] options = {"ADMIN", "CLIENT"};
        ImageIcon icon = new ImageIcon("D:/2 º año 1º cuatrimestre Programacion/TPFINAL/src/images.png");
        String n = (String) JOptionPane.showInputDialog(null, "Ingrese una opcion",
                "TURNOS ", JOptionPane.QUESTION_MESSAGE, icon, options, options[1]);
        System.out.println(n);*/


        int option;
        int option2;
        int option3;
        int option4;
        int option5;
        int option6;
        int option7;

        Scanner myScanner = new Scanner(System.in);

        do {


            System.out.println("Choose an option (0 to exit)");
            System.out.println("1: Admin");
            System.out.println("2: Client");


            option = myScanner.nextInt();



            switch (option) {

                case 1:

                    do {
                        Administrador admin = new Administrador();

                        System.out.println("1: show all clients");
                        System.out.println("2: eliminate a client");
                        System.out.println("3: show a client");
                        System.out.println("4: show all turnos");
                        System.out.println("5: show a turno");

                        System.out.println("0 to exit");
                        option2 = myScanner.nextInt();

                        switch (option2) {
                            case 1:
                                admin.showClients("personas.json");
                                break;
                            case 2:

                                DataBase dataBase = new DataBase();
                                System.out.println("Ingrese un dni");
                                String dniBuscar;

                                dniBuscar=myScanner.next();
                                dataBase.deleteClient(dniBuscar);
                                System.out.println("Client deleted");

                                break;

                            case 3:


                                System.out.println("Ingrese un dni");
                                String dni;

                                dni=myScanner.next();
                                Client clientEncontrado = new Client();

                                clientEncontrado = DataBase.getOurInstance().searchClient(dni);
                                System.out.println("-----Client found------");
                                System.out.println(clientEncontrado);
                                System.out.println("--------------------------------");

                                break;

                            case 4:

                                try{
                                    admin.showTurnos("turnos.json");
                                }catch (NullPointerException e)
                                {
                                    System.out.println("Doesn't exist id");
                                }


                                break;

                            case 5:

                                System.out.println("Ingrese id a buscar");
                                int id;

                                id=myScanner.nextInt();
                                Turno turno = new Turno();

                                turno = DataBase.getOurInstance().searchTurno(id);
                                System.out.println("-----Turno found------");
                                System.out.println(turno);
                                System.out.println("--------------------------------");
                                break;
                        }
                    } while (option2 != 0);
                    break;


                case 2:
                    do {

                        Client client = new Client();
                        System.out.println("Choose an option (0 to exit)");
                        System.out.println("1: First Time?, LOAD CLIENT");
                        System.out.println("2: Modify Client");
                        System.out.println("3: Login");
                        System.out.println("4: Modify turno");
                        System.out.println("5: Delete turno");
                        System.out.println("6: Show my turno");


                        option3 = myScanner.nextInt();

                        switch (option3) {
                            case 1:
                                /// CARGAR CLIENTES
                                Gjson gson= new Gjson();
                                Client client3= new Client();
                                client3= Gjson.LoadClient();
                                List<Client> list= new ArrayList<Client>();
                                Gjson.gson(client3);

                                //Gjson.writeFile(list);

                                //Gjson.writeFile( gson.gson(Gjson.LoadClient()));



                                break;
                            case 2:
                                /// MODIFICAR CLIENTE
                                System.out.println("Ingrese un dni");
                                String dni;

                                dni=myScanner.next();
                                Client clientmod = new Client();

                                clientmod = DataBase.getOurInstance().modifyClient(dni);
                                System.out.println("-----Client modify------");
                                System.out.println(clientmod);
                                System.out.println("--------------------------------");
                                break;

                            case 3:
                                System.out.println("Ingrese un dni");
                                String dni3;

                                dni3=myScanner.next();
                                Client client1 = new Client();

                                client1 = DataBase.getOurInstance().searchClient(dni3);
                                System.out.println("-----Client found------");
                                System.out.println(client1);
                                System.out.println("--------------------------------");



                                do
                                {
                                    System.out.println("Choose an option (0 to exit)");
                                    System.out.println("Select the sport");
                                    System.out.println("1: Papi");
                                    System.out.println("2: Tenis");
                                    System.out.println("3: Paddel");

                                    ///TODO BORRAR UN TURNO


                                    option4 = myScanner.nextInt();


                                    switch (option4)
                                    {
                                        case 1:
                                            do{
                                                System.out.println("Choose an option (0 to exit)");
                                                System.out.println("PAPI");
                                                System.out.println("Select the time");
                                                System.out.println("1: 08:00 AM");
                                                System.out.println("2: 14:00 PM");
                                                System.out.println("3: 20:00 PM");

                                                option5= myScanner.nextInt();

                                                switch (option5)
                                                {
                                                    case 1:
                                                        /// TODO RESERVAR HORARIO
                                                        ItemRent itemRent1= new ItemRent("papi", 400, 2);


                                                        Turno turno1= new Turno(client1, LocalDateTime.of(2021, 6, 30, 8, 0), LocalDateTime.of(2021, 6, 30, 8, 0), TipoCancha.Papi, itemRent1);
                                                        DataBase.addListTurno(turno1);
                                                        System.out.println(turno1);

                                                        break;

                                                    case 2:
                                                        ItemRent itemRent2= new ItemRent("papi", 400, 2);


                                                        Turno turno2= new Turno(client1, LocalDateTime.of(2021, 6, 30, 10, 0), LocalDateTime.of(2021, 6, 30, 8, 0), TipoCancha.Papi, itemRent2);
                                                        DataBase.addListTurno(turno2);
                                                        System.out.println(turno2);

                                                        ///
                                                        break;

                                                    case 3:
                                                        /// TODO RESERVAR HORARIO
                                                        break;

                                                    case 0:
                                                        break;

                                                    default:
                                                        System.out.println("Incorrect option");
                                                        break;

                                                }
                                            }while(option5!=0);

                                            break;

                                        case 2:
                                            do{
                                                System.out.println("Choose an option (0 to exit)");
                                                System.out.println("TENIS");
                                                System.out.println("Select the time");
                                                System.out.println("1: 09:00 AM");
                                                System.out.println("2: 15:00 PM");
                                                System.out.println("3: 21:00 PM");

                                                option6= myScanner.nextInt();

                                                switch (option6)
                                                {
                                                    case 1:
                                                        /// TODO RESERVAR HORARIO

                                                        break;

                                                    case 2:
                                                        /// TODO RESERVAR HORARIO
                                                        System.out.println("RESERVANDO HORARIO...");
                                                        break;

                                                    case 3:
                                                        /// TODO RESERVAR HORARIO
                                                        System.out.println("FALTA RESERVANDO HORARIO...");
                                                        break;

                                                    case 0:
                                                        break;

                                                    default:
                                                        System.out.println("Incorrect option");
                                                        break;

                                                }


                                            }while(option6!=0);

                                            break;

                                        case 3:
                                            do{
                                                System.out.println("Choose an option (0 to exit)");
                                                System.out.println("PADDEL");
                                                System.out.println("Select the time");
                                                System.out.println("1: 10:00 AM");
                                                System.out.println("2: 16:00 PM");
                                                System.out.println("3: 22:00 PM");

                                                option7= myScanner.nextInt();

                                                switch (option7)
                                                {
                                                    case 1:
                                                        /// TODO RESERVAR HORARIO
                                                        break;

                                                    case 2:
                                                        /// TODO RESERVAR HORARIO
                                                        break;

                                                    case 3:
                                                        /// TODO RESERVAR HORARIO
                                                        break;

                                                    case 0:
                                                        break;

                                                    default:
                                                        System.out.println("Incorrect option");
                                                        break;

                                                }
                                            }while(option7!=0);

                                            break;


                                    }
                                }while(option4 !=0);

                            case 4:
                                try
                                {
                                    System.out.println("Ingrese el id del turno");
                                    int id;
                                    id=myScanner.nextInt();

                                    Turno turno3= new Turno();

                                    turno3 = DataBase.getOurInstance().searchTurno(id);
                                    System.out.println("-----Turno found------");
                                    System.out.println(turno3);
                                    System.out.println("--------------------------------");


                                    DataBase.getOurInstance().modifyTurno(id);
                                    //DataBase.addListTurno(turno3);


                                    System.out.println("Turno modified");
                                }catch (Exception e)
                                {
                                    System.out.println("You have to insert a number" + e.getMessage());
                                }


                                break;
                            case 5:

                                try
                                {
                                    System.out.println("Ingrese el id del turno");
                                    int id1;
                                    id1=myScanner.nextInt();

                                    Turno turno4= new Turno();

                                    turno4 = DataBase.getOurInstance().searchTurno(id1);
                                    System.out.println("-----Turno found------");
                                    System.out.println(turno4);
                                    System.out.println("--------------------------------");


                                    DataBase.getOurInstance().deleteTurno(id1);
                                    System.out.println("Turno deleted");

                                }catch (Exception e){
                                    System.out.println("You have to insert a number" + e.getMessage());
                                }


                                break;

                            case 6:
                                try{
                                    System.out.println("Ingrese el id del turno");
                                    int id2;
                                    id2=myScanner.nextInt();

                                    Turno turno5= new Turno();

                                    turno5 = DataBase.getOurInstance().searchTurno(id2);
                                    System.out.println("-----Turno found------");
                                    System.out.println(turno5);
                                    System.out.println("--------------------------------");

                                }catch (InputMismatchException e)
                                {
                                    System.out.println("You have to insert a number " + e.getMessage());
                                }






                                break;

                        }
                    } while (option3 != 0);
                    break;


                case 0:
                    break;

                default:
                    System.out.println("Incorrect option");
                    break;

            }


        } while (option != 0);
    }
}

