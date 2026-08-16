/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorLexico;

/**
 *
 * @author felip
 */
public class LeerTokens {

    private int columna;
    private Token token = new Token();

    public void reconocer(String[] linea, int fila, ReporteHtml reporte) {
        columna = 0;
        String palabra = "";

        boolean dentroCadena = false;
        boolean dentroComentario = false;

        String cadena = "";

        for (int i = 0; i < linea.length; i++) {

            if (linea[i] != null) {

                String comentario = linea[i] + linea[i + 1];
                if (comentario.equals("/*") || dentroComentario) {
                    dentroComentario = true;
                    if (dentroComentario) {
                        cadena = cadena + linea[i];
                        if (comentario.equals("*/")) {
                            dentroComentario = false;
                            cadena = cadena + "/";
                            token.reconocerCometario(cadena, fila, reporte);
                        }
                    }
                }
                comentario = "";

                // Detectar comilla
                if (linea[i].equals("\"")) {

                    if (!dentroCadena) {
                        // Comienza la cadena
                        dentroCadena = true;
                        cadena = "\"";

                    } else {
                        // Termina la cadena
                        cadena = cadena + "\"";

                        token.reconocerLiteral(cadena, fila, reporte);

                        cadena = "";
                        dentroCadena = false;
                    }

                } else if (dentroCadena) {

                    // Estamos dentro de las comillas
                    cadena = cadena + linea[i];

                }
                if (!linea[i].equals(" ")) {

                    if (esCaracter(linea[i])) {

                        token.reconocerOperadores(linea[i], fila, reporte);
                        token.reconocerDelimitador(linea[i], fila, reporte);
                        palabra = "";

                    } else {

                        palabra = palabra + linea[i];
                    }

                } else {

                    if (!palabra.isEmpty()) {
                        token.reconocerPalabraReservada(palabra, fila, reporte);
                        token.reconocerDirectivas(palabra, fila, reporte);
                        token.reconocerComandosIA(palabra, fila, reporte);
                        token.reconocerConectores(palabra, fila, reporte);

                        palabra = "";
                    }

                    columna++;
                }
            }
        }

        if (!palabra.isEmpty()) {
            token.reconocerPalabraReservada(palabra, fila, reporte);
            token.reconocerDirectivas(palabra, fila, reporte);
            token.reconocerComandosIA(palabra, fila, reporte);
            token.reconocerConectores(palabra, fila, reporte);
        }

    }

    private boolean esCaracter(String caracter) {
        String[] listaCaracteres = {"+", "=", "{", "}", "(", ")"};

        for (String delimitador : listaCaracteres) {
            if (caracter.equals(delimitador)) {
                return true;
            }
        }
        return false;
    }
}
