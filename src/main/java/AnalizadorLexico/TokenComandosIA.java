/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorLexico;

/**
 *
 * @author felip
 */
public class TokenComandosIA {

    String[] comandosIA = {"PREGUNTAR", "GENERAR", "RESUMIR", "ANALIZAR", "TRADUCIR", "CLASIFICAR", "EXTRAER"};
    
    

    public void reconocerToken(String token, ReporteHtml reporte) {

        for (int i = 0; i < comandosIA.length; i++) {
            if (token.equals(comandosIA[i])) {
                añadirTokenDirectivas(token, reporte);
                break;
            }
        }
    }

    public void añadirTokenDirectivas(String palabraReconocida, ReporteHtml reporte) {
        System.out.println("+------+----------------+-----------------------+------+--------+");
        System.out.printf("| %-4d | %-14s | %-20s | %-4d | %-7d |%n", 1, palabraReconocida, "Comando de IA", 2, 1);
        reporte.agregarDato(0, palabraReconocida, "Comando de IA", 0, 0);
    }

}
