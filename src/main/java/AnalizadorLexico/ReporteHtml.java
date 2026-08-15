package AnalizadorLexico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReporteHtml {

    private static final String TITULO_LOG = "REPORTE DE TOKENS Y ERRORES";
    private static final String TITULO_COLUMNA1 = "No.";
    private static final String TITULO_COLUMNA2 = "Lexema";
    private static final String TITULO_COLUMNA3 = "Tipo";
    private static final String TITULO_COLUMNA4 = "Fila";
    private static final String TITULO_COLUMNA5 = "Columna";

    private FileWriter escribir;

    public void crearReporte() {

        try {
            File pathArchivo = new File("C:/Users/felip/OneDrive/Escritorio/reporteTokensYErrores.html");

            escribir = new FileWriter(pathArchivo);
            escribir.write("<html>");
            escribir.write("<head>");
            escribir.write("<title>" + TITULO_LOG + "</title>");

            escribir.write("<style>");
            escribir.write("body {font-family: Tahoma, Geneva, sans-serif; font-weight: bold;}");
            escribir.write("table {border-collapse: collapse; width: 100%;}");
            escribir.write("tr:nth-child(even) {background-color: #f2f2f2;}");
            escribir.write("tr:hover {background-color: lightblue;}");
            escribir.write("th, td {padding: 10px; text-align: left;}");
            escribir.write("th {background-color: #000080; color: white;}");
            escribir.write("h1 {text-align: center;}");
            escribir.write("</style>");

            escribir.write("</head>");
            escribir.write("<body>");
            escribir.write("<h1>" + TITULO_LOG + "</h1>");
            escribir.write("<table border='1'>");
            escribir.write("<tr>");
            escribir.write("<th>" + TITULO_COLUMNA1 + "</th>");
            escribir.write("<th>" + TITULO_COLUMNA2 + "</th>");
            escribir.write("<th>" + TITULO_COLUMNA3 + "</th>");
            escribir.write("<th>" + TITULO_COLUMNA4 + "</th>");
            escribir.write("<th>" + TITULO_COLUMNA5 + "</th>");
            escribir.write("</tr>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void agregarDato(int numero, String lexema, String tipo, int fila, int columna) {
        try {
            escribir.write("<tr>");
            escribir.write("<td>" + numero + "</td>");
            escribir.write("<td>" + lexema + "</td>");
            escribir.write("<td>" + tipo + "</td>");
            escribir.write("<td>" + fila + "</td>");
            escribir.write("<td>" + columna + "</td>");
            escribir.write("</tr>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cerrarReporte() {
        try {

            escribir.write("</table>");
            escribir.write("</body>");
            escribir.write("</html>");
            escribir.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
