/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AnalizadorLexico;

/**
 *
 * @author felip
 */
public class TokenConectores {

    String[] conectores = {"SOBRE", "DESDE", "EN", "COMO", "->"};

    public void reconocerToken(String token) {

        for (int i = 0; i < conectores.length; i++) {
            if (token.equals(conectores[i])) {
                añadirTokenDirectivas(token);
                break;
            }
        }
    }

    public void añadirTokenDirectivas(String palabraReconocida) {
        System.out.println("+------+----------------+-----------------------+------+--------+");
        System.out.printf("| %-4d | %-14s | %-20s | %-4d | %-7d |%n",
                1, palabraReconocida, "Conectores", 2, 1);

    }
}
