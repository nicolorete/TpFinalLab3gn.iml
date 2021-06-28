package com.company.clases;

public class Cancha {
    private int canchaNumber;
    private CanchaTipo canchaTipo;
    private StatusCancha status;

    public Cancha(int canchaNumber,  CanchaTipo canchaTipo, StatusCancha status) {
        this.canchaNumber = canchaNumber;
        this.canchaTipo = canchaTipo;
        this.status = status;
    }

    public int getCanchaNumber() {
        return canchaNumber;
    }

    public void setCanchaNumber(int canchaNumber) {
        this.canchaNumber = canchaNumber;
    }



    public CanchaTipo getCanchaType() {
        return canchaTipo;
    }

    public void setCanchaType(CanchaTipo canchaTipo) {
        this.canchaTipo = canchaTipo;
    }

    public StatusCancha getStatus() {
        return status;
    }

    public void setStatus(StatusCancha status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object anObject) {
        if (!(anObject instanceof Cancha)) {
            return false;
        }

        Cancha otherMember = (Cancha)anObject;
        if(otherMember.getCanchaNumber()== this.getCanchaNumber() ){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return
                "Number=" + canchaNumber +
                " Cancha Type=" + canchaTipo.getDescription();
    }
}
