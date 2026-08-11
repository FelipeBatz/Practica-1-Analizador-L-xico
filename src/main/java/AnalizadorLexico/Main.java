/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorLexico;

/**
 *
 * @author felip
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("+------+----------------+-----------------------+------+--------+");
        System.out.printf("| %-4s | %-14s | %-20s | %-4s | %-7s |%n",
                "No.", "Lexema", "Tipo", "Fila", "Columna");
        

        LeerArchivo leer = new LeerArchivo();
        leer.leerTextoEnBytes();
    }
}
