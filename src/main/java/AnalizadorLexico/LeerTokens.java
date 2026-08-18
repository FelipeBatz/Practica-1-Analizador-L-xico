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

    private boolean tokenReconocido;

    public void reconocer(String[] linea, int fila, ReporteHtml reporte, Token token) {
        columna = 0;
        String palabra = "";
        String cadena = "";
        tokenReconocido = false;

        boolean dentroCadena = false;
        boolean dentroComentario = false;

        for (int i = 0; i < linea.length; i++) {
            columna++;
            tokenReconocido = false;
            if (linea[i] != null) {
//--------------------------------------------------------------------------------------------------------------------------------------------------------
                String comentario = linea[i] + linea[i + 1];
                if (comentario.equals("/*") || dentroComentario) {
                    dentroComentario = true;
                    if (dentroComentario) {
                        cadena = cadena + linea[i];
                        if (comentario.equals("*/")) {
                            dentroComentario = false;
                            cadena = cadena + "/";
                            tokenReconocido = token.reconocerCometario(cadena, fila, reporte, tokenReconocido, columna);

                            if (!tokenReconocido) {
                                token.reportarError(cadena, fila, reporte, columna);
                            }
                            cadena = "";

                            dentroCadena = false;
                        }
                    }
                }
                comentario = "";
//--------------------------------------------------------------------------------------------------------------------------------------------------------
                // Detectar comilla
                if (linea[i].equals("\"")) {

                    if (!dentroCadena) {
                        // Comienza la cadena
                        dentroCadena = true;
                        cadena = "\"";

                    } else {
                        // Termina la cadena
                        cadena = cadena + "\"";

                        tokenReconocido = token.reconocerLiteral(cadena, fila, reporte, tokenReconocido, columna);

                        if (tokenReconocido == false) {
                            token.reportarError(cadena, fila, reporte, columna);
                        }

                        cadena = "";
                        dentroCadena = false;
                    }

                } else if (dentroCadena) {
                    // Estamos dentro de las comillas
                    cadena = cadena + linea[i];
                    //--------------------------------------------------------------------------------------------------------------------------------------------------------

                } else if (!linea[i].equals(" ")) {

                    if (esCaracter(linea[i])) {

                        tokenReconocido = token.reconocerOperadores(linea[i], fila, reporte, tokenReconocido, columna);
                        tokenReconocido = token.reconocerDelimitador(linea[i], fila, reporte, tokenReconocido, columna);

                        if (!tokenReconocido) {
                            token.reportarError(palabra, fila, reporte, columna);
                        }
                        palabra = "";
                        tokenReconocido = false;

                    } else {
                        palabra = palabra + linea[i];
                    }

                } else {

                    if (!palabra.isEmpty()) {
                        tokenReconocido = token.reconocerPalabraReservada(palabra, fila, reporte, tokenReconocido, columna);
                        tokenReconocido = token.reconocerDirectivas(palabra, fila, reporte, tokenReconocido, columna);
                        tokenReconocido = token.reconocerComandosIA(palabra, fila, reporte, tokenReconocido, columna);
                        tokenReconocido = token.reconocerConectores(palabra, fila, reporte, tokenReconocido, columna);
                        tokenReconocido = token.reconocerFuncion(palabra, fila, reporte, tokenReconocido, columna);
                        tokenReconocido = token.reconocerNumeros(palabra, fila, reporte, tokenReconocido, columna);

                        if (!tokenReconocido) {
                            token.reportarError(palabra, fila, reporte, columna);
                        }

                        palabra = "";
                        tokenReconocido = false;
                    }

                }
            }

        }
        if (!cadena.isEmpty()) {

            if (!tokenReconocido) {
                token.reportarError(cadena, fila, reporte, columna);
            }
        }

        if (!palabra.isEmpty()) {
            tokenReconocido = token.reconocerPalabraReservada(palabra, fila, reporte, tokenReconocido, columna);
            tokenReconocido = token.reconocerDirectivas(palabra, fila, reporte, tokenReconocido, columna);
            tokenReconocido = token.reconocerComandosIA(palabra, fila, reporte, tokenReconocido, columna);
            tokenReconocido = token.reconocerConectores(palabra, fila, reporte, tokenReconocido, columna);
            tokenReconocido = token.reconocerFuncion(palabra, fila, reporte, tokenReconocido, columna);
            tokenReconocido = token.reconocerNumeros(palabra, fila, reporte, tokenReconocido, columna);
            if (!tokenReconocido) {
                token.reportarError(palabra, fila, reporte, columna);
            }
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
