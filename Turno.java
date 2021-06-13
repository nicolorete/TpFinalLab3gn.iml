package com.company;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.UUID;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;



public class Turno {

    private static int i = 1;

    private int id;
    //private UUID uuid;
    private Client client;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private TipoCancha TipodeCancha ;
    //private boolean isOcupado;
    private ItemRent item;

    public Turno() {
    }

    public Turno( Client client, LocalDateTime checkIn, LocalDateTime checkOut,TipoCancha tipodeCancha,  ItemRent item) {
        //this.uuid = uuid.randomUUID();
        this.id = i++;
        this.client = client;
        this.checkIn = checkIn;
        this.checkOut = checkOut.plusHours(2);/// add 2 hours.
        TipodeCancha = tipodeCancha;
        //this.isOcupado = isOcupado;
        this.item = item;
    }

    ///region GETTERS AND SETTERS


    public int getId() {
        return id;
    }

    public void setUuid(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public TipoCancha getTipodeCancha() {
        return TipodeCancha;
    }

    public void setTipodeCancha(TipoCancha tipodeCancha) {
        TipodeCancha = tipodeCancha;
    }

  /*public boolean isOcupado() {
        return isOcupado;
    }

    public void setOcupado(boolean ocupado) {
        isOcupado = ocupado;
    }*/

    public ItemRent getItem() {
        return item;
    }

    public void setItem(ItemRent item) {
        this.item = item;
    }

    ///endregion


    /// create a new format with patron

    DateTimeFormatter formatterOfPatters= DateTimeFormatter.ofPattern(" d/M/u  hh:mm a");



    @Override
    public String toString() {
        return "Turno{" +
                "\n ID: " + id +
                "\n Client: " + client +
                "\n CheckIn: " + checkIn.format(formatterOfPatters) +
                "\n CheckOut:" + checkOut.format(formatterOfPatters) +
                "\n TipodeCancha: " + TipodeCancha +
                //"\n isOcupado=" + isOcupado +
                "\n item: " + item +
                '}';
    }
}
