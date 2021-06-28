package com.company.clases;

import com.company.database.DataBase;
import org.joda.time.DateTimeComparator;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class LocalDeCanchas {

    private  ArrayList<Cancha> listCancha;

    private  ArrayList<Turno> listTurno;

    public ArrayList<Cancha> getListCancha() {
        return listCancha;
    }

    public void setListCancha(ArrayList<Cancha> listCancha) {
        this.listCancha = listCancha;
    }
    public ArrayList<Turno> getListTurno() {

        listTurno =DataBase.getTurnos();
        return listTurno;
    }



    public void setListTurno(ArrayList<Turno> listTurno) {
        this.listTurno = listTurno;
    }

    public ArrayList<Cancha> listCanchaUnAvailable(){

        listCancha = DataBase.getListCancha();
        ArrayList<Cancha> listCanchas = new ArrayList<Cancha>();
        for (Cancha cancha : listCancha){

            if(!cancha.getStatus().isAvailable()){
                listCanchas.add(cancha);
            }

        }

        return listCanchas;

    }

    public ArrayList<Cancha> listCanchaAvailable(){

        listCancha = DataBase.getListCancha();
        ArrayList<Cancha> listCanchas = listCanchaAvailable();
        for (Cancha cancha : listCancha){

            if(cancha.getStatus().isAvailable()){
                listCanchas.add(cancha);
            }

        }
        return listCanchas;
    }

    //This mhetod execute in Booking
    public ArrayList<Cancha> listCanchaAvailableDates(Date _start, Date _end){

        ArrayList<Cancha> listCanchaUnvailable = new ArrayList<Cancha>();
        ArrayList<Cancha> listCanchaAvailable = new ArrayList<>();
        for (Turno turno :getListTurno()) { //recorro las listas de reservas

            if(turno.getStatus()== TurnoStatus.CONFIRM || turno.getStatus()== TurnoStatus.CHECKIN ){
                /// REALIZA CUATRO COMPARACIONES

            DateTimeComparator dateTimeComparator = DateTimeComparator.getDateOnlyInstance();

            int cmpStart = dateTimeComparator.compare(_start, turno.getStartDate());
            int cmpStartEnd = dateTimeComparator.compare(_start, turno.getEndDate());
            int cmpEnd = dateTimeComparator.compare(_end, turno.getStartDate());
            int cmpEndEnd =dateTimeComparator.compare(_end, turno.getEndDate());
            ///Compara fecha inicial con fecha final
                ///si la fecha inicial  da -1 si son iguales da 0, si es mayor da 1
            //Coincide con la reserva
            if( (cmpStart < 0 && cmpEndEnd > 0) || (cmpStart >=0 && cmpStartEnd<0) ||( cmpEnd>0 && cmpEndEnd<=0) ){
///si da true quiere decir que esa reserva esta comprometida
                for (Cancha cancha :turno.getCanchaList()) {
                    listCanchaUnvailable.add(cancha);///pongo en una lista las que estan ocupadas
                    ///la volvemos a pasar a la lista original de reservas
                }
            }

            }

        }

        //// REMOVEMOS DUPLICADOS
        /// HASHSET LO Q HACE ES PARA REMOVER DUPLICADOS DE UNA LSITA
        ///Remuevo de la lista que no le voy a mostar al usuario

        HashSet<Cancha> hSetNumbers = new HashSet(listCanchaUnvailable);
        listCanchaUnvailable.clear();
        listCanchaUnvailable.addAll(hSetNumbers);//remove duplicates
///luego vamos a la lista original y le borramos todas las habitaciones de list room unVailable
        listCanchaAvailable.removeAll(listCanchaUnvailable);

        return listCanchaAvailable;
    }




    public ArrayList<Turno> searchTurno(String param){

        ArrayList<Turno> search = new ArrayList<Turno>();
        for (Turno turno:getListTurno()) {
            if ( turno.getClient().getName().toLowerCase().contains(param.toLowerCase()) || turno.getClient().getLastName().toLowerCase().contains(param.toLowerCase()) ||
                    turno.getClient().getDni().toLowerCase().contains(param.toLowerCase())){
                search.add(turno);

            }

        }
        return search;
    }
}
