package com.company.database;

import com.company.clases.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataBase {

    private static DataBase ourInstance = new DataBase();

    private static ArrayList<Client> listClient = new ArrayList<>();
    private static ArrayList<Admin> listAdmin = new ArrayList<>();
    private static ArrayList<Cancha> listCancha = new ArrayList<>();
    private static ArrayList<Turno> turnos = new ArrayList<>();
    private static Admin adminLoggin; //store the user that was loggin

    public static void setUserLoggin(Admin adminLoggin) {
        DataBase.adminLoggin = adminLoggin;
    }

    public static DataBase getInstance() {
        return ourInstance;
    }


    public static Admin getUserLoggin() {
        return adminLoggin;
    }

    public static ArrayList<Admin> getListUser() {
        return listAdmin;
    }

    public static ArrayList<Client> getListClient() {
        return listClient;
    }

    public static ArrayList<Cancha> getListCancha() {
        return listCancha;
    }

    public static ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public static void setTurnos(ArrayList<Turno> turnos) {
        DataBase.turnos = turnos;
    }

    public static void setListUser(ArrayList<Admin> listAdmin) {
        DataBase.listAdmin = listAdmin;
    }

    public static void iniciar() {
        readClient();
        readUser();
        readCancha();
        readTurno();

    }


    private static void readTurno() {
        try {
            Type userListType = new TypeToken<ArrayList<Turno>>() {
            }.getType();
            turnos = new WriterJson<Turno>().read("Turno.json", userListType);
//

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static boolean turnoSave(Turno turno) {
        if (turnos == null) {
            turnos = new ArrayList<Turno>();
            turnos.add(turno);
        } else {
            turnos.add(turno);
        }
        try {
            new WriterJson<Turno>().write(turnos, "Turno.json");
            return true;
        } catch (Exception ex) {
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }





    public static boolean clientSave(Client customer) {
        if (listClient == null) {
            listClient = new ArrayList<Client>();
            listClient.add(customer);
        } else {
            listClient.add(customer);
        }
        try {
            new WriterJson<Client>().write(listClient, "Client.json");
            return true;
        } catch (Exception ex) {
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }

    private static void readClient() {
        try {
            Type userListType = new TypeToken<ArrayList<Client>>() {
            }.getType();
            listClient = new WriterJson<Client>().read("Client.json", userListType);
//            for (Client cust:listClient) {
//                System.out.println(cust.toString());
//            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static boolean canchaSave(Cancha cancha) {
        if (listCancha == null) {
            listCancha = new ArrayList<Cancha>();
            listCancha.add(cancha);
        } else {
            listCancha.add(cancha);
        }

        try {
            new WriterJson<Cancha>().write(listCancha, "Cancha.json");

            return true;
        } catch (Exception ex) {
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }
    public static boolean turnoUpdate(ArrayList<Turno> turno) {

        try{
            new WriterJson<Turno>().write(turnos,"Turno.json");
            return true;
        }catch(Exception ex){
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }
    public static boolean adminUpdate(ArrayList<Admin> admin) {

        try{
            new WriterJson<Admin>().write(listAdmin,"User.json");
            return true;
        }catch(Exception ex){
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }
    public static boolean clientUpdate(ArrayList<Client> Client) {

        try{
            new WriterJson<Client>().write(listClient,"Client.json");
            return true;
        }catch(Exception ex){
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }
    public static boolean canchaUpdate(ArrayList<Cancha> cancha) {

        try{
            new WriterJson<Cancha>().write(listCancha,"Cancha.json");
            return true;
        }catch(Exception ex){
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }

    private static void readCancha() {

        try {

            Type canchaListType = new TypeToken<ArrayList<Cancha>>() {
            }.getType();
            listCancha = new WriterJson<Cancha>().read("Cancha.json", canchaListType);
            for (Cancha cancha1 : listCancha) {
                System.out.println(cancha1.toString());
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public static boolean saveUser(Admin admin) {
        if (listAdmin == null) {
            listAdmin = new ArrayList<Admin>();
            listAdmin.add(admin);
        } else {
            listAdmin.add(admin);
        }
        try {
            new WriterJson<Admin>().write(listAdmin, "User.json");

            return true;
        } catch (Exception ex) {
            //Logger.logMsg("");
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }

    }

    private static void readUser() {

        try {
            Type userListType = new TypeToken<ArrayList<Admin>>() {
            }.getType();
            listAdmin = new WriterJson<Admin>().read("User.json", userListType);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }


    private static void adminCreate() throws Exception {
        Permit permiso = new Permit("RESERVATION");// permissions to turnos
        Permit permiso1 = new Permit("CUSTOMER");//has permission to client`s module
        ArrayList<Permit> permitsADmin = new ArrayList<Permit>();
        permitsADmin.add(permiso);
        permitsADmin.add(permiso1);
        Rol rolAdmin = new Rol("ADMIN", permitsADmin);
        Rol rolEmpl = new Rol("EMPLEADO", permitsADmin);
        Admin adminAdmin = new Admin("german", "oyarzo", "36384624", "1234", "german", rolAdmin);
        saveUser(adminAdmin);


    }

    public static boolean userCancha(Cancha cancha) {
        listCancha.add(cancha);
        try {

            return true;
        } catch (Exception ex) {
            System.out.print("Error to save the file" + ex.toString());
            return false;
        }
    }

    private DataBase() {
    }

}
