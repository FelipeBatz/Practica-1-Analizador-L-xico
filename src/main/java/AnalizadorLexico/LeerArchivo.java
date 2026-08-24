/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorLexico;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author felip
 */
public class LeerArchivo {

    public String[] leerTextoConScanner() {

        File miArchivo = new File("C:/Users/felip/OneDrive/Escritorio/Prueba.pz");
        String textoEnFilas[] = new String[7];
        int indiceLinea = 0;
        try (InputStream inputStream = new FileInputStream(miArchivo)) {
            Scanner scanner = new Scanner(inputStream);
            String linea = scanner.nextLine();
            while (true) {
              
                textoEnFilas[indiceLinea] = linea + "\n";
                indiceLinea++;
                linea = scanner.nextLine();
            }
        } catch (NoSuchElementException e) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        return textoEnFilas;
    }

}
