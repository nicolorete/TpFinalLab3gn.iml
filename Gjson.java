package com.company;
import java.time.LocalDateTime;
import java.util.*;
import com.company.DataBase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.UUID;

public class Gjson {

    private List<Client> clients;

    public Gjson() {
        List<Client> clients = new ArrayList<Client>();
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }



    public static Client LoadClient() {

        Client client = new Client();

        String name, lastName, email, type;
        String adress;
        String dni;
        int celphone;
        UUID uuid;
        Scanner keyboard = new Scanner(System.in);// create a new object with the word "new"

        try {
            client.setId(UUID.randomUUID());

            System.out.println("Introduce your name");

            client.setName(name = keyboard.nextLine());
            System.out.println("Lastaname:");

            client.setLastName(lastName = keyboard.nextLine());
            System.out.println("DNI");
            client.setDni(dni = keyboard.nextLine());
            System.out.println("Adress:");
            client.setAdress(adress = keyboard.nextLine());
            System.out.println("Email: ");
            client.setEmail(email = keyboard.next());
            System.out.println("Celphone: ");
            client.setCelphone(celphone = keyboard.nextInt());
            System.out.println("Type: ");
            client.setTypeClient(type = keyboard.next());
        } catch (IndexOutOfBoundsException e) {  // put an exception
            System.out.println("Se produjo un error " + e.getMessage());
        } catch (InputMismatchException e){
            System.out.println("Inserto mal los datos " + e.getMessage());
        }

        return client;

        ///TODO
        /*if (!existeDni(dni)){
            Client client = new Client(name, lastName, dni, adress, email, celphone);
            gson(client);
            flag = true;
        }
        return flag;
         }
          */

    }

    public static void loadTurno(){

        //// TODO INGRESAR CON NUMERO DOCUMENTO
        /// if existe dni
        System.out.println("Ingrese un dni");
        String dni3;

        Scanner myScanner= new Scanner(System.in);
        dni3=myScanner.next();
        Client client1 = new Client();

        client1 = DataBase.getOurInstance().searchClient(dni3);
        System.out.println("-----Client found------");
        System.out.println(client1);
        System.out.println("--------------------------------");
        int option4;
        int option5;
        int option6;
        int option7;

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


                                Turno turno2= new Turno(client1, LocalDateTime.of(2021, 6, 30, 14, 0), LocalDateTime.of(2021, 6, 30, 14, 0), TipoCancha.Papi, itemRent2);
                                DataBase.addListTurno(turno2);
                                System.out.println(turno2);

                                ///
                                break;

                            case 3:
                                /// TODO RESERVAR HORARIO
                                ItemRent itemRent3= new ItemRent("papi", 400, 2);


                                Turno turno3= new Turno(client1, LocalDateTime.of(2021, 6, 30, 20, 0), LocalDateTime.of(2021, 6, 30, 20, 0), TipoCancha.Papi, itemRent3);
                                DataBase.addListTurno(turno3);
                                System.out.println(turno3);
                                break;

                            case 0:
                                break;

                            default:
                                System.out.println("Incorrect option");
                                break;

                            /*if(option5==1)
                            {
                                return turno1;
                            }else if(option5==2)
                            {
                                return turno2;
                            }else if(option5==3)
                            {
                                return turno3;
                            }*/

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




    }


    public static List<Client> gson(Client client) {
        List<Client> clients = new ArrayList<Client>(100);


        /*Client client1 = new Client("German", "Oyarzo", "36384624", "Las heras", "german@hotmail.com", 22359393, "Eventual");
        Client client2 = new Client("Pepe", "Argento", "1034889348", "Mexico 1223", "pepeargento@gmail.com", 22233333, "Eventual");
        Client client3 = new Client("Homero", "Simpson", "111345455", "Calle Falsa 1234", "homero@gmail.com", 11434554, "Eventual");


        DataBase.addList(client1);
        DataBase.addList(client2);
        DataBase.addList(client3);*/


        clients=DataBase.addList(client);



        return clients;
    }



    ///----- safe in a file---------------------

    public static void writeFile(List<Client> clients) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); /// create a gson to print better
        BufferedWriter fWriter = null;

        try {
            /// open file

            fWriter = new BufferedWriter(new FileWriter(new File("personas.json")));

            String json= gson.toJson(clients, clients.getClass());

            System.out.println("--------------------------------------");
            System.out.println(json);
            System.out.println("--------------------------------------");

            fWriter.write(json);


        } catch (IOException e) {  // put an exception
            System.out.println("Se produjo un error " + e.getMessage());
        } finally {
            if (fWriter != null) {
                try {
                    fWriter.close();///we have to close the file to be sure that all information is going to be safe

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

        }


        //return clients;
    }

    ///TODO
    ///---------------------READ A FILE------------------------------------------------------------
    public static void readFile(String nameFile) {


        //if(!new File("personas.json").exists()){/// if doesnt exists the file it will go out the funtion

        if (!new File(nameFile).exists()) {/// if doesnt exists the file it will go out the funtion

            return;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader fReader = null;

        List<Client> clients;
        try {
            fReader = new BufferedReader(new FileReader(new File(nameFile)));
            clients = gson.fromJson(fReader, (new TypeToken<List<Client>>() {
            }.getType()));

            /*System.out.println("--------------------------");
            clients.forEach(System.out::println);
            System.out.println("--------------------------");*/
            ///== es lo mismo a lo de abajo
            for(var cli : clients)
            {


                System.out.println("--------------------------------------");
                System.out.println(cli);
                System.out.println("--------------------------------------");
            }


        } catch (IOException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            /// close the file
            try {
                if (fReader != null) {
                    fReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




}
