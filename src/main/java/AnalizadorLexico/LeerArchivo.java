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
public class LeerArchivo {

    public static final String PATH_COMPLETO
            = "C:/Users/felip/OneDrive/Escritorio/asdasdads.pz";

    public static void leerTextoEnBytes() {

        TokenDirectivas tokenDirectivas = new TokenDirectivas();
        TokenPalabrasReservadas tokenPalabrasReservadas = new TokenPalabrasReservadas();

        File miArchivo = new File(PATH_COMPLETO);
        String palabra = "";

        try (FileInputStream inputStream2 = new FileInputStream(miArchivo)) {

            int byteEnArchivo = inputStream2.read();

            while (byteEnArchivo != -1) {

                char caracter = (char) byteEnArchivo;

                // Si NO es espacio, salto de línea, tabulación, etc.
                if (!Character.isWhitespace(caracter)) {

                    palabra = palabra + caracter;

                } else {

                    // Si encontramos un separador y hay una palabra
                    if (!palabra.isEmpty()) {

                        tokenDirectivas.reconocerToken(palabra);
                        tokenPalabrasReservadas.reconocerToken(palabra);

                        palabra = "";
                    }
                }

                byteEnArchivo = inputStream2.read();
            }

            // Reconocer la última palabra del archivo
            if (!palabra.isEmpty()) {
                tokenDirectivas.reconocerToken(palabra);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
