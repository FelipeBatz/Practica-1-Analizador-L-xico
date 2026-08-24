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
    private String[] errores;
    private int contadorErrores;

    public Token() {
        errores = new String[10000];
        contadorErrores = 0;
    }

    public void imprimirErrores(ReporteHtml reporte) {
        for (int i = 0; i < errores.length; i++) {
            if (errores[i] != null) {
                System.out.println(errores[i]);
                reporte.agreagarError(errores[i]);

            }
        }

    }

    public void reportarError(String palabra, int fila, ReporteHtml reporte, int columna) {
        errores[contadorErrores] = "Error  lexico en la palabra: " + palabra + ", " + "Fila: " + fila + " Columna: " + (columna);
        contadorErrores++;

    }

    public boolean reconocerCometario(String palabra, int fila, ReporteHtml reporte, boolean tokenReconocido, int columna) {
        if (tokenReconocido) {
            return true;
        }
        String[] delimitadores = {"//", "/",};
        if (palabra.startsWith(delimitadores[1]) && palabra.endsWith(delimitadores[1])) {
            numero++;
            añadirToken(numero, palabra, "Comentario", fila, columna, reporte);
            return true;
        } else {
            return false;
        }

    }

    public boolean reconocerNumeros(String palabra, int fila, ReporteHtml reporte, boolean tokenReconocido, int columna) {
        if (tokenReconocido) {
            return true;
        }

        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < numeros.length; i++) {

            if (palabra.indexOf(numeros[i]) != -1 || palabra.indexOf(".") != -1) {
                numero++;
                añadirToken(numero, palabra, "Literal", fila, columna, reporte);
                return true;
            }
        }

        return false;
    }

    public boolean reconocerLiteral(String palabra, int fila, ReporteHtml reporte, boolean tokenReconocido, int columna) {
        if (tokenReconocido) {
            return true;
        }

        String[] delimitadores = {"\""};
        if (palabra.startsWith(delimitadores[0]) && palabra.endsWith(delimitadores[0])) {
            numero++;
            añadirToken(numero, palabra, "Literal", fila, columna, reporte);
            return true;
        }
        return false;
    }

    public boolean reconocerDelimitador(String palabra, int fila, ReporteHtml reporte, boolean tokenReconocido, int columna) {
        if (tokenReconocido) {
            return true;
        }

        String[] delimitadores = {"{", "}", "(", ")", "\"", ";"};
        for (int i = 0; i < delimitadores.length; i++) {
            if (palabra.equals(delimitadores[i])) {
                numero++;

                añadirToken(numero, palabra, "Delimitador", fila, columna, reporte);
                return true;
            }
        }
        return false;

    }

    public boolean reconocerOperadores(String palabra, int fila, ReporteHtml reporte, boolean tokenReconocido, int columna) {
        if (tokenReconocido) {
            return true;
        }

        String[] Operadores = {"=", "+"};
        for (int i = 0; i < Operadores.length; i++) {
            if (palabra.equals(Operadores[i])) {
                numero++;

                añadirToken(numero, palabra, "Operador", fila, columna, reporte);
                return true;
            }
        }
        return false;
    }

    public boolean reconocerFuncion(String palabra, int fila, ReporteHtml reporte, boolean tokenReconocido, int columna) {
        if (tokenReconocido) {
            return true;
        }

        String[] funciones = {"CARGAR"};
        for (int i = 0; i < funciones.length; i++) {
            if (palabra.equals(funciones[i])) {
                numero++;

                añadirToken(numero, palabra, "Funcion", fila, columna, reporte);
                return true;
            }
        }
        return false;
    }

    public boolean reconocerConectores(String palabra, int fila, ReporteHtml reporte, boolean tokenReconocido, int columna) {
        if (tokenReconocido) {
            return true;
        }

        String[] conectores = {"SOBRE", "DESDE", "EN", "COMO", "->"};
        for (int i = 0; i < conectores.length; i++) {
            if (palabra.equals(conectores[i])) {
                numero++;

                añadirToken(numero, palabra, "Conector", fila, columna, reporte);
                return true;
            }
        }
        return false;
    }

    public boolean reconocerComandosIA(String palabra, int fila, ReporteHtml reporte, boolean tokenReconocido, int columna) {
        if (tokenReconocido) {
            return true;
        }

        String[] comandosIA = {"PREGUNTAR", "GENERAR", "RESUMIR", "ANALIZAR", "TRADUCIR", "CLASIFICAR", "EXTRAER", "CODIFICAR"};
        for (int i = 0; i < comandosIA.length; i++) {
            if (palabra.equals(comandosIA[i])) {
                numero++;

                añadirToken(numero, palabra, "Comando IA", fila, columna, reporte);
                return true;
            }
        }
        return false;
    }

    public boolean reconocerPalabraReservada(String palabra, int fila, ReporteHtml reporte, boolean tokenReconocido, int columna) {
        if (tokenReconocido) {
            return true;
        }

        String[] palbrasReservadas = {"AGENTE", "contexto", "variable", "EJECUTAR", "EXPORTAR"};
        for (int i = 0; i < palbrasReservadas.length; i++) {
            if (palabra.equals(palbrasReservadas[i])) {
                numero++;

                añadirToken(numero, palabra, "Palabra Reservada", fila, columna, reporte);
                return true;

            }
        }
        return false;
    }

    public boolean reconocerDirectivas(String palabra, int fila, ReporteHtml reporte, boolean tokenReconocido, int columna) {
        if (tokenReconocido) {
            return true;
        }

        String[] Directivas = {"@modelo", "@rol", "@formato"};
        for (int i = 0; i < Directivas.length; i++) {
            if (palabra.equals(Directivas[i])) {
                numero++;

                añadirToken(numero, palabra, "Directiva", fila, columna, reporte);
                return true;
            }
        }
        return false;
    }

    public void añadirToken(int numero, String palabraReconocida, String tipo, int fila, int columna, ReporteHtml reporte) {
        System.out.println("+------+-------------------------------------------------------------------------------------+----------------------+------+---------+");
        System.out.printf("| %-4d | %-83s | %-20s | %-4d | %-7d |%n", numero, palabraReconocida, tipo, fila, columna);
        reporte.agregarDato(numero, palabraReconocida, tipo, fila, columna);

    }

}
