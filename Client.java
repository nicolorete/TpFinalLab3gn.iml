package com.company;
import com.google.gson.Gson;

import java.io.*;
import java.util.List;
import java.util.UUID;

public class Client extends Person {

    private UUID uuid;
    private String typeClient; /// eventual or habitual

    public Client() {
        super();
    }

    public  Client(String name, String lastName, String dni, String adress, String email, int celphone) {
        super(name, lastName, dni, adress, email, celphone);
    }

    public Client(String name, String lastName, String dni, String adress, String email, int celphone, String typeClient) {
        super(name, lastName, dni, adress, email, celphone);
        this.uuid = UUID.randomUUID();
        this.typeClient = typeClient;

    }

    ///region GETTERS AND SETTERS

    public UUID getId() {
        return uuid;
    }

    public void setId(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(String typeClient) {
        this.typeClient = typeClient;
    }



    ///endregion


    @Override
    public String toString() {
        return super.toString()+
                "\n Client{" +
                "\n ID: " + uuid.toString().substring(0,10) + /// id between 0 and 10
                "\n type: " + typeClient +
                '}'+
                ',';
    }








}
