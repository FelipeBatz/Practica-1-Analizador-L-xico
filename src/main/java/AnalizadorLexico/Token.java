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

        for (int i = 0; i < linea.length; i++) {

            if (linea[i] != null) {
                if (!linea[i].equals(" ")) {
                    palabra = palabra + linea[i];
                } else {
                    reconocerPalabraReservada(palabra, fila, reporte);
                    reconocerDirectivas(palabra, fila, reporte);
                    palabra = "";
                    columna++;

                }
            }
        }
        if (!palabra.isEmpty()) {
            reconocerPalabraReservada(palabra, fila, reporte);
            reconocerDirectivas(palabra, fila, reporte);
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

}
