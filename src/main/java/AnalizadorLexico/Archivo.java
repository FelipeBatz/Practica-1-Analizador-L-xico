/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorLexico;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author felip
 */
public class Archivo {

    private int fila;
    private String[] linea = new String[500];
    private Token token = new Token();
    private int contadorLetras;

    public void leerTextoEnBytes(ReporteHtml reporte) {
        File miArchivo = new File("C:/Users/felip/OneDrive/Escritorio/Prueba.pz");

        try (FileInputStream inputStream = new FileInputStream(miArchivo)) {

            int byteEnArchivo = inputStream.read();

            while (byteEnArchivo != -1) {

                char letra = (char) byteEnArchivo;

                if (letra == '\n') {
                    fila++;
                    token.reconocer(linea, fila, reporte);
                    linea = new String[500];
                    contadorLetras = 0;

                } else if (letra != '\r') {
                    linea[contadorLetras] = String.valueOf(letra);
                    contadorLetras++;
                }

                byteEnArchivo = inputStream.read();
            }

            if (contadorLetras > 0) {
                fila++;
                token.reconocer(linea, fila, reporte);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
    }
}
