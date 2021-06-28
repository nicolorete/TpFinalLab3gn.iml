package com.company.clases;

public class Validaciones {

    public Validaciones() {
    }

    public static boolean isNumeric(String number){
        try{
            Integer.parseInt(number);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean sololetrasYnumeros(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (!Character.isDigit(pass.charAt(i)) && !Character.isLetter(pass.charAt(i)))
                return false;
        }

        return true;
    }

    public static boolean unNumero(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i)))
                return true;
        }
        return false;
    }

    public static boolean unaLetra(String pass) {
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isLetter(pass.charAt(i)))
                return true;
        }
        return false;
    }

    // nombres y apellidos
    public static boolean validarLetra(String name) throws Exception {
        if (!soloLetra(name))
            throw new Exception("Debe ingresar solo caracteres alfabeticos");
        if (name.length() < 4)
            throw new Exception("Debe ingresar al menos 4 caracteres");


        return true;

    }

    public static boolean soloLetra(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isLetter(cadena.charAt(i)))
                return false;
        }
        return true;
    }



    //  Dni
    public static boolean verificarDni(String dni)  {
        try
        {
            if (String.valueOf(dni).length() <= 7 || String.valueOf(dni).length() >=8 )

                return true;
        }catch (NumberFormatException e)
        {
            System.out.println("dni is incorrect");
        }

        return false;
    }
}
