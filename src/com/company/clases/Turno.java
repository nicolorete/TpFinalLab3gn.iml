package com.company.clases;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDateTime;

import java.util.List;

public class Turno {

    private Admin admin; //Login--> en la bd(txt) guarda el usuario actual.
    private Client client; //Client that make the reserve.
    private Date startDate;
    private Date endDate;
    private Date checkIn;
    private Date checkOut;
    private List<Cancha> canchaList; //esto es con un comboBox
    private List<Client> listClient;
    private TurnoStatus status; //Reserve, confirm, cancel

    public Turno(Admin admin, Client client, Date startDate, Date endDate, List<Cancha> canchaList, List<Client> listClient) {
        this.admin = admin;
        this.client = client;
        this.startDate = startDate;
        this.endDate= Date.from(startDate.toInstant().plus(Duration.ofHours(2)));/// agrega 2 hora a la fecha de salida
        //this.endDate = (Date.getTime() + (1000*60*60*2));
        this.canchaList = canchaList;
        this.listClient = listClient;
        this.status = TurnoStatus.CONFIRM;
    }


    public Admin getUser() {
        return admin;
    }

    public void setUser(Admin admin) {
        this.admin = admin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public List<Cancha> getCanchaList() {
        return canchaList;
    }

    public void setCanchaList(List<Cancha> canchaList) {
        this.canchaList = canchaList;
    }

    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }


    public TurnoStatus getStatus() {
        return status;
    }

    public void setStatus(TurnoStatus status) {
        this.status = status;
    }

    public String getDni() {
        return getClient().getDni();

    }

    @Override
    public String toString() {
        return "Turno{" +
                "admin=" + admin +
                ", client=" + client +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", canchaList=" + canchaList +
                ", listClient=" + listClient +
                ", status=" + status +
                '}';
    }
}


