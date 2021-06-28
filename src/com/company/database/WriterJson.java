package com.company.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files
//Esto es una clase generica

public class WriterJson<T> {

    public void write(ArrayList<T> list, String file) throws IOException {

       String json = new Gson().toJson(list);
       // Gson gson = new GsonBuilder().setPrettyPrinting().create(); /// create a gson to print better
        try {
            FileWriter myWriter = new FileWriter(file);
           // String json= gson.toJson(list, list.getClass());
            myWriter.write(json);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("ERROR.");
            e.printStackTrace();
        }
    }

    public ArrayList<T> read(String file, Type type) throws IOException {
        String data = "";
        ArrayList<T> objectsList = new ArrayList<>();

        try {
            File myObj = new File(file);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                //System.out.println(data);
            }
            objectsList = new Gson().fromJson(data, type);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR.");
            e.printStackTrace();
        }

        return objectsList;

    }
}
