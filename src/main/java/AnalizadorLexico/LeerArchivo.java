package AnalizadorLexico;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author felip
 */
public class LeerArchivo {

    public static final String PATH_COMPLETO = "C:/Users/felip/OneDrive/Escritorio/asdasdads.pz";
    int numero;

    /*
    public void leerTextoEnBytes() {

        TokenDirectivas tokenDirectivas = new TokenDirectivas();
        TokenPalabrasReservadas tokenPalabrasReservadas = new TokenPalabrasReservadas();
        TokenComandosIA tokenComandosIA = new TokenComandosIA();
        TokenConectores tokenConectores = new TokenConectores();
        TokenOperadores tokenOperadores = new TokenOperadores();
        TokenDelimitadores tokenDelimitadores = new TokenDelimitadores();
        ReporteHtml reporte = new ReporteHtml();
        File miArchivo = new File(PATH_COMPLETO);
        String palabra = "";

        reporte.crearReporte();

        try (FileInputStream inputStream = new FileInputStream(miArchivo)) {

            int byteEnArchivo = inputStream.read();
            while (byteEnArchivo != -1) {

                char caracter = (char) byteEnArchivo;

                if (esCaracter(caracter)) {

                    if (!palabra.isEmpty()) {

                        reconocerPalabra(palabra, tokenDirectivas, tokenPalabrasReservadas, tokenComandosIA, tokenConectores, reporte);
                        palabra = "";
                    }

                   

                    //tokenOperadores.reconocerToken(token);
                    //tokenDelimitadores.reconocerToken(token);

                } else if (Character.isWhitespace(caracter)) {

                    if (!palabra.isEmpty()) {

                        reconocerPalabra(palabra, tokenDirectivas, tokenPalabrasReservadas, tokenComandosIA, tokenConectores, reporte);

                        palabra = "";
                    }
                } else {
                    palabra = palabra + caracter;
                }

                byteEnArchivo = inputStream.read();
            }

            if (!palabra.isEmpty()) {
                reconocerPalabra(palabra, tokenDirectivas, tokenPalabrasReservadas, tokenComandosIA, tokenConectores, reporte);
                palabra = "";
            }
            reporte.cerrarReporte();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private boolean esCaracter(char caracter) {
        String[] listaCaracteres = {"+", "=", "{", "}", "(", ")", "\""};

        for (String delimitador : listaCaracteres) {
            if (String.valueOf(caracter).equals(delimitador)) {
                return true;
            }
        }
        return false;
    }

    private void reconocerPalabra(String palabra, TokenDirectivas tokenDirectivas,  tokenPalabrasReservadas, TokenComandosIA tokenComandosIA, TokenConectores tokenConectores, ReporteHtml reporte) {
        numero = tokenDirectivas.reconocerDirectivas(palabra, numero);
        //tokenPalabrasReservadas.reconocerToken(palabra);
        //tokenComandosIA.reconocerToken(palabra, reporte);
        //tokenConectores.reconocerToken(palabra);
    }
*/
}
