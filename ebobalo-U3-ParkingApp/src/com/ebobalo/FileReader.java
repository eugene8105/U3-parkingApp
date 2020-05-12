package com.ebobalo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<Client> readClientFile(String fileName){
        List<Client> cln = new ArrayList<Client>();
        // Deserialization
        try
        {
            // Reading the object from a file
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            try {
                cln = (List<Client>)in.readObject();
            } catch (IOException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
            in.close();
            //file.close();

            System.out.println("Object has been deserialized ");
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught" + ex.getMessage());
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        return cln;
    } // end of readClientFile method

} // end of FileReader class
