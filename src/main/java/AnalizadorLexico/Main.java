/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorLexico;

/**
 * d
 *
 * @author felip
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("+------+----------------+----------------------+------+---------+");
        System.out.printf("| %-4s | %-14s | %-20s | %-4s | %-7s |%n",
                "No.", "Lexema", "Tipo", "Fila", "Columna");

        ReporteHtml reporte = new ReporteHtml();
        reporte.crearReporte();

        Archivo archivo = new Archivo();
        archivo.leerTextoEnBytes(reporte);

        reporte.cerrarReporte();
    }
}
