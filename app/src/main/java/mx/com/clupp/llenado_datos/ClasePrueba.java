package mx.com.clupp.llenado_datos;

/**
 * Created by omartronco on 29/12/17.
 */

public class ClasePrueba {
    public static boolean isVerificadorFecha() {
        return verificadorFecha;
    }

    public static void setVerificadorFecha(boolean verificadorFecha) {
        ClasePrueba.verificadorFecha = verificadorFecha;
    }

     public static boolean isVerificadorNombre() {
        return verificadorNombre;
    }

    public static void setVerificadorNombre(boolean verificadorNombre) {
        ClasePrueba.verificadorNombre = verificadorNombre;
    }

    public static boolean isVerificadorTelefono() {
        return verificadorTelefono;
    }

    public static void setVerificadorTelefono(boolean verificadorTelefono) {
        ClasePrueba.verificadorTelefono = verificadorTelefono;
    }

    public static boolean isVerificadorCorreo() {
        return verificadorCorreo;
    }

    public static void setVerificadorCorreo(boolean verificadorCorreo) {
        ClasePrueba.verificadorCorreo = verificadorCorreo;
    }

    public static String getFecha() {
        return fecha;
    }

    public static void setFecha(String fecha) {
        ClasePrueba.fecha = fecha;
    }

    private static boolean verificadorCorreo = false;
    private static boolean verificadorFecha = false;
    private static boolean verificadorNombre = false;
    private static boolean verificadorTelefono = false;
    private static String fecha ="";
}
