package com.ebobalo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileWriter {

    public static void writeClientFile(String fileName, List<Client> clList){

        // Serialization
        try
        {
            //Saving of object in a file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
//            FileOutputStream file = new FileOutputStream(fileName);
//            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
//            for (Client cl: clList){
//                out.writeObject(cl);
//            }

            out.writeObject(clList);

            out.close();
            //file.close();

            System.out.println("Object has been serialized");

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught: ");
            System.out.printf(ex.getMessage());
        }
    }

} // end of FileWriter
