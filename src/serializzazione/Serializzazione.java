/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializzazione;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author galimberti.tommaso
 */
public class Serializzazione {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Studente s = new Studente("Alessandro", "Giussani", 2);
        
        try {  
            FileOutputStream fs = new FileOutputStream("test.ser");
            ObjectOutputStream OS = new ObjectOutputStream(fs);
                OS.writeObject(9);
                OS.writeObject("Ciao");
                float a = (float) 6.9;
                OS.writeObject(6.9);
                OS.flush();
                OS.close();
                fs.close();
            FileInputStream fi = new FileInputStream("test.ser");
            ObjectInputStream IS = new ObjectInputStream(fi);
            int v1 =(int)IS.readObject();
            System.out.println("v1: "+v1);
            String v2 =(String)IS.readObject();
            System.out.println("v2: "+v2);
            double v3 = (double)IS.readObject();
            System.out.println("v3: "+v3);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializzazione.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializzazione.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serializzazione.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
