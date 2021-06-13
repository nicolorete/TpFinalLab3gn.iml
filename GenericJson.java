package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.List;

public class GenericJson <T>{

    public void writeFileGeneric(List<T> list, String nameFile) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); /// create a gson to print better
        BufferedWriter fWriter = null;

        try {
            /// open file

            fWriter = new BufferedWriter(new FileWriter(new File(nameFile)));

            String json= gson.toJson(list, list.getClass());

            System.out.println("--------------------------------------");
            System.out.println(json);
            System.out.println("--------------------------------------");
            fWriter.write(json);


        } catch (IOException e) {  // put an exception
            System.out.println("Se produjo un error " + e.getMessage());
        } finally {
            if (fWriter != null) {
                try {
                    fWriter.close();///we have to close the file to be sure that all information is going to be safe

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

        }


        //return clients;
    }

    ///TODO
    ///---------------------READ A FILE------------------------------------------------------------
    public void readFile(String nameFile) {


        //if(!new File("personas.json").exists()){/// if doesnt exists the file it will go out the funtion

        if (!new File(nameFile).exists()) {/// if doesnt exists the file it will go out the funtion

            return;
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader fReader = null;

        List<T> list;
        try {
            fReader = new BufferedReader(new FileReader(new File(nameFile)));
            list = gson.fromJson(fReader, (new TypeToken<List<T>>() {
            }.getType()));

            /*System.out.println("--------------------------");
            clients.forEach(System.out::println);
            System.out.println("--------------------------");*/
            ///== es lo mismo a lo de abajo
            for(var li : list)
            {


                System.out.println("--------------------------------------");
                System.out.println(li);
                System.out.println("--------------------------------------");
            }


        } catch (IOException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            /// close the file
            try {
                if (fReader != null) {
                    fReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
