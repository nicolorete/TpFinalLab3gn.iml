package com.company;

import java.util.Arrays;
import java.util.UUID;

public class LocalCancha {
    private Client [] clients;
    private ItemRent []itemRents;
    private Turno [] turnos;

    public LocalCancha() {
    }

    public LocalCancha(Client[] clients, ItemRent[] itemRents, Turno [] turnos) {
        this.clients = clients;
        this.itemRents = itemRents;
        this.turnos = turnos;
    }

    ///region GETTERS AND SETTERS

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    public ItemRent[] getItemRents() {
        return itemRents;
    }

    public void setItemRents(ItemRent[] itemRents) {
        this.itemRents = itemRents;
    }

    public Turno[] getTurnos() {
        return turnos;
    }

    public void setTurnos(Turno[] turnos) {
        this.turnos = turnos;
    }
    ///endregion

   /* public Turno searchTurno(int id) {
        for (Turno turno: turnos) {
            if (turno != null && turno.getId() == id) {
                return turno;
            }
        }
        return null;
    }*/


   /* public ItemRent rentCancha(TipoCancha tipoCancha, String dniClient) {
        ItemRent itemRent= searchRent();
        Client client = DataBase.getOurInstance().searchClient(dniClient);
        if (itemRent != null && client != null) {
            itemRent.setStock(itemRent.getStock() - 1);
            return itemRent;
        }
        return null;
    }*/



    @Override
    public String toString() {
        return "LocalCancha{" +
                "clients:" + Arrays.toString(clients) +
                ", itemRents: " + Arrays.toString(itemRents) +
                '}';
    }
}
