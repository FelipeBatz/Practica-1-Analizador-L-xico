/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorLexico;

/**
 *
 * @author felip
 */
public class Token {

    private String palabra = "";
    private int numero = 0;
    private int columna;

    public void reconocer(String[] linea, int fila, ReporteHtml reporte) {
        columna = 0;
        String palabra = "";

        boolean dentroCadena = false;
        String cadena = "";

        for (int i = 0; i < linea.length; i++) {

            if (linea[i] != null) {

                // Detectar comilla
                if (linea[i].equals("\"") || linea[i].equals("/") || linea[i].equals("/")) {

                    if (!dentroCadena) {
                        // Comienza la cadena
                        dentroCadena = true;
                        cadena = "\"";

                    } else {
                        // Termina la cadena
                        cadena = cadena + "\"";

                        reconocerLiteral(cadena, fila, reporte);
                        reconocerCometario(cadena, fila, reporte);

                        cadena = "";
                        dentroCadena = false;
                    }

                } else if (dentroCadena) {

                    // Estamos dentro de las comillas
                    cadena = cadena + linea[i];

                } else if (!linea[i].equals(" ")) {

                    if (esCaracter(linea[i])) {

                        //reconocerOperadores(linea[i], fila, reporte);
                        //reconocerDelimitador(linea[i], fila, reporte);
                        palabra = "";

                    } else {

                        palabra = palabra + linea[i];
                    }

                } else {

                    if (!palabra.isEmpty()) {
                        //reconocerPalabraReservada(palabra, fila, reporte);
                        //reconocerDirectivas(palabra, fila, reporte);
                        //reconocerComandosIA(palabra, fila, reporte);
                        //reconocerConectores(palabra, fila, reporte);

                        palabra = "";
                    }

                    columna++;
                }
            }
        }

        if (!palabra.isEmpty()) {
            reconocerPalabraReservada(palabra, fila, reporte);
            reconocerDirectivas(palabra, fila, reporte);
            reconocerComandosIA(palabra, fila, reporte);
            reconocerConectores(palabra, fila, reporte);
        }

    }

    public void reconocerCometario(String palabra, int fila, ReporteHtml reporte) {
        String[] delimitadores = {"//", "/", "/"};
        if (palabra.startsWith(delimitadores[1]) && palabra.endsWith(delimitadores[2])) {
            numero++;
            columna++;
            añadirToken(numero, palabra, "Comentario", fila, columna, reporte);
        }
    }
    
    public void reconocerLiteral(String palabra, int fila, ReporteHtml reporte) {
        String[] delimitadores = {"\""};
        if (palabra.startsWith(delimitadores[0]) && palabra.endsWith(delimitadores[0])) {
            numero++;
            columna++;
            añadirToken(numero, palabra, "Literal", fila, columna, reporte);
        } 
    }

    public void reconocerDelimitador(String palabra, int fila, ReporteHtml reporte) {
        String[] delimitadores = {"{", "}", "(", ")", "\""};
        for (int i = 0; i < delimitadores.length; i++) {
            if (palabra.equals(delimitadores[i])) {
                numero++;
                columna++;
                añadirToken(numero, palabra, "Delimitador", fila, columna, reporte);
                break;
            }
        }
    }

    public void reconocerOperadores(String palabra, int fila, ReporteHtml reporte) {
        String[] Operadores = {"=", "+"};
        for (int i = 0; i < Operadores.length; i++) {
            if (palabra.equals(Operadores[i])) {
                numero++;
                columna++;
                añadirToken(numero, palabra, "Operador", fila, columna, reporte);
                break;
            }
        }
    }

    public void reconocerConectores(String palabra, int fila, ReporteHtml reporte) {
        String[] conectores = {"SOBRE", "DESDE", "EN", "COMO", "->"};
        for (int i = 0; i < conectores.length; i++) {
            if (palabra.equals(conectores[i])) {
                numero++;
                columna++;
                añadirToken(numero, palabra, "Conector", fila, columna, reporte);
                break;
            }
        }
    }

    public void reconocerComandosIA(String palabra, int fila, ReporteHtml reporte) {
        String[] comandosIA = {"PREGUNTAR", "GENERAR", "RESUMIR", "ANALIZAR", "TRADUCIR", "CLASIFICAR", "EXTRAER"};
        for (int i = 0; i < comandosIA.length; i++) {
            if (palabra.equals(comandosIA[i])) {
                numero++;
                columna++;
                añadirToken(numero, palabra, "Comando IA", fila, columna, reporte);
                break;
            }
        }
    }

    public void reconocerPalabraReservada(String palabra, int fila, ReporteHtml reporte) {
        String[] palbrasReservadas = {"AGENTE", "contexto", "variable", "EJECUTAR", "EXPORTAR"};
        for (int i = 0; i < palbrasReservadas.length; i++) {
            if (palabra.equals(palbrasReservadas[i])) {
                numero++;
                columna++;
                añadirToken(numero, palabra, "Palabra Reservada", fila, columna, reporte);
                break;
            }
        }
    }

    public void reconocerDirectivas(String palabra, int fila, ReporteHtml reporte) {
        String[] Directivas = {"@modelo", "@rol", "@formato"};
        for (int i = 0; i < Directivas.length; i++) {
            if (palabra.equals(Directivas[i])) {
                numero++;
                columna++;
                añadirToken(numero, palabra, "Directiva", fila, columna, reporte);
                break;
            }
        }
    }

    public void añadirToken(int numero, String palabraReconocida, String tipo, int fila, int columna, ReporteHtml reporte) {
        System.out.println("+---------------------------------------------------------------+");
        System.out.printf("| %-4d | %-14s | %-20s | %-4d | %-7d |%n", numero, palabraReconocida, tipo, fila, columna);
        reporte.agregarDato(numero, palabraReconocida, tipo, fila, columna);

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
