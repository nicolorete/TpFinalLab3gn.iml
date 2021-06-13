package com.company;

import com.google.gson.Gson;

import javax.swing.*;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.util.*;


public class DataBase  {
    private static DataBase ourInstance = new DataBase();

    private static List<Client> listClient = new ArrayList<>(100);

    private static List<Turno> listTurno= new ArrayList<>(100);

    private static List<ItemRent> listItemRent= new ArrayList<>(100);

    public DataBase() {
    }

    ///region GETTERS AND SETTERS

    public static DataBase getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(DataBase ourInstance) {
        DataBase.ourInstance = ourInstance;
    }

    public static List<Client> getListClient() {
        return listClient;
    }

    public static void setListClient(List<Client> listClient) {
        DataBase.listClient = listClient;
    }

    public static List<Turno> getListTurno() {
        return listTurno;
    }

    public static void setListTurno(List<Turno> listTurno) {
        DataBase.listTurno = listTurno;
    }

    public static List<ItemRent> getListItemRent() {
        return listItemRent;
    }

    public static void setListItemRent(List<ItemRent> listItemRent) {
        DataBase.listItemRent = listItemRent;
    }


    /// endregion

//    private static void readClient() {
//        try{
//            List<Client> listClient = new ArrayList<Client>();
//
//             Gjson.readFile("personas.json");
//           /* for (Client cust:listClient) {
//                System.out.println(cust.toString());
//            }*/
//
//        }catch(Exception ex){
//            System.out.println(ex.toString());
//        }
//    }
//
//    public static void init(){
//        System.out.println("Init DB");
//        readClient();
//        System.out.println("-----------------------------------");
//    }




    public static List<Client> addList(Client client) {

        /*listClient = new ArrayList<Client>();

        listClient.add(client);
        try {
            Gjson.writeFile(listClient);


        } catch (Exception e) {
            System.out.print("Error to save the file" + e.toString());
        }
        return listClient;*/



        if (listClient == null) {

            listClient = new ArrayList<Client>();
            listClient.add(client);
        } else {
            //exist(client);
            listClient.add(client);

        }
        try {
            Gjson.writeFile(listClient);


        } catch (Exception e) {
            System.out.print("Error to save the file" + e.toString());
        }
        return listClient;
    }


    public static List<Turno> addListTurno(Turno turno) {


        if (listTurno == null) {
            listTurno = new ArrayList<Turno>();

            listTurno.add(turno);
        } else {
            //exist(client);
            listTurno.add(turno);

        }
        try {

            new GenericJson<Turno>().writeFileGeneric(listTurno,"turnos.json");

        } catch (Exception e) {
            System.out.print("Error to save the file" + e.toString());
        }
        return listTurno;
    }

    public static List<ItemRent> addListItemRent(ItemRent itemRent) {


        if (listItemRent == null) {
            listItemRent = new ArrayList<ItemRent>();

            listItemRent.add(itemRent);
        } else {
            //exist(client);
            listItemRent.add(itemRent);

        }
        try {

            new GenericJson<ItemRent>().writeFileGeneric(listItemRent,"itemrent.json");

        } catch (Exception e) {
            System.out.print("Error to save the file" + e.toString());
        }
        return listItemRent;
    }


    ///------------------------------------CLIENTE---------------------------------------
    public Client searchClient(String dni) {
        Gjson.readFile("personas.json");
        for (Client client : listClient) {
            if (dni.equals(client.getDni())) {

                return client;


            }
        }
        return null;
    }


    public void deleteClient(String dni) {
        try{
            listClient.removeIf(client -> dni.equals(client.getDni()));

        }catch (Exception e){
            System.out.println("No existe dni" +e.getMessage());
        }finally {
            Gjson.writeFile(listClient);
        }



    }



    public Client modifyClient(String dni) {

        Gjson.readFile("personas.json");
        for (Client client : listClient) {
            if (dni.equals(client.getDni())) {

                try {
                    deleteClient(dni);
                    Gjson.gson(Gjson.LoadClient());

                } catch (IndexOutOfBoundsException e) {  // put an exception
                    System.out.println("Se produjo un error " + e.getMessage());
                } catch (InputMismatchException e){
                    System.out.println("Inserto mal los datos " + e.getMessage());
                }finally {
                    Gjson.writeFile(listClient);
                }

                return client;
            }
        }
        return null;
    }


    /// ---------------------------------TURNO-------------------------------------------------
    public Turno searchTurno(int id) {
        new GenericJson<Turno>().readFile("turnos.json");
        for (Turno turno : listTurno) {
            if (id == turno.getId()) {

                return turno;

            }
        }
        return null;
    }

    public Turno modifyTurno(int id) {

        new GenericJson<Turno>().readFile("turnos.json");
        for (Turno turno : listTurno) {
            if (id==(turno.getId())) {

                try {
                    deleteTurno(id);
                    DataBase.addListTurno(turno);
                    Gjson.loadTurno();


                } catch (IndexOutOfBoundsException e) {  // put an exception
                    System.out.println("Se produjo un error " + e.getMessage());
                } catch (InputMismatchException e){
                    System.out.println("Inserto mal los datos " + e.getMessage());
                }finally {
                    new GenericJson<Turno>().writeFileGeneric(listTurno,"turnos.json");
                }

                return turno;
            }
        }
        return null;
    }

    public void deleteTurno(int id) {
        try{
            listTurno.removeIf(ids -> id== (ids.getId()));

        }catch (Exception e){
            System.out.println("No existe id" +e.getMessage());
        }finally {
            new GenericJson<Turno>().writeFileGeneric(listTurno,"turnos.json");
        }



    }



    /*public Turno rentCancha(String titulo, String dniClient, LocalDateTime checkIn, LocalDateTime checkOut) {
        ItemRent itemRent = searchItemRent(titulo);
        Client client = searchClient(dniClient);
        if (itemRent != null && client != null) {
            itemRent.setStock(itemRent.getStock() - 1);
            Turno turno = new Turno(client, checkIn, checkOut);

            for (int i = 0; i < turno.length ; i++) {
                if (turno[i] == null) {
                    turno[i] = alquiler;
                    break;
                }
            }
            return alquiler;
        }
        return null;
    }*/

    ///---------------------------ITEMRENT----------------------------------------------
    public ItemRent searchItemRent(String name) {
        new GenericJson<ItemRent>().readFile("itemrent.json");
        for (ItemRent itemRent : listItemRent) {
            if (name.equals(itemRent.getName()) ) {

                return itemRent;

            }
        }
        return null;
    }

    public void devolverTurno(int id) {
        Turno turno = searchTurno(id);
        if (turno != null) {
            String turnoName = turno.getItem().getName();
            ItemRent itemRent = searchItemRent(turnoName);
            itemRent.setStock(itemRent.getStock() + 1);
            deleteTurno(id);
        }
    }


}
