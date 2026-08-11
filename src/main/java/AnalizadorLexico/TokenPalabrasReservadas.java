/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorLexico;

/**
 *
 * @author felip
 */
public class TokenPalabrasReservadas {
    
    String[] palbrasReservadas = {"AGENTE", "contexto", "variable", "EJECUTAR", "EXPORTAR"};
    
    public void reconocerToken(String palabra) {
       
        for (int i = 0; i < palbrasReservadas.length; i++) {
            if (palabra.equals(palbrasReservadas[i])) {
                añadirTokenPalabrasReservas(palabra);
                break;
            }
        }
    }
    
    public void añadirTokenPalabrasReservas(String palabraReconocida) {
       System.out.println("+---------------------------------------------------------------+");
       System.out.printf("| %-4d | %-14s | %-20s | %-4d | %-7d |%n",
        1, palabraReconocida, "Palabra Reservada", 2, 1);

       
    }
}
