package com.company;

public abstract class Person {

    private String name;
    private String lastName;
    private String dni;
    private String adress;
    private String email;
    private int celphone;


    public Person() {
    }

    public Person(String name, String lastName, String dni, String adress, String email, int celphone) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.adress = adress;
        this.email = email;
        this.celphone = celphone;
    }

    ///region GETTERS AND SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCelphone() {
        return celphone;
    }

    public void setCelphone(int celphone) {
        this.celphone = celphone;
    }
    ///endregion






    ///TODO
    /*public void existeDni(int dni){
        if (equals(this.dni = dni)){
            System.out.println("El dni ya se encuentra cargado");
        }else
        {
            writeFile();
        }

    }*/


    @Override
    public String toString() {
        return "Persona{" +
                "\n name: " + name +
                "\n lastName: " + lastName +
                "\n  dni: " + dni +
                "\n adress: " + adress +
                "\n email: " + email +
                "\n celphone: " + celphone +
                '}';
    }
}
