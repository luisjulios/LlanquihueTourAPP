package cl.duoc.llanquihuetour.ui;

import cl.duoc.llanquihuetour.model.Tour;

/** Presentación de datos y mensajes operativos de la aplicación. */
public final class Consola {
    private static final String SEPARADOR = "----------------------------------------";
    private static final String FORMATO_MENSAJE = "%-7s%s%n";

    private Consola() {
    }

    public static void info(String mensaje) {
        System.out.printf(FORMATO_MENSAJE, "[INFO]", mensaje);
    }

    public static void exito(String mensaje) {
        System.out.printf(FORMATO_MENSAJE, "[OK]", mensaje);
    }

    public static void advertencia(String mensaje) {
        System.out.printf(FORMATO_MENSAJE, "[WARN]", mensaje);
    }

    public static void error(String mensaje) {
        System.err.printf(FORMATO_MENSAJE, "[ERROR]", mensaje);
    }

    public static void encabezado(String titulo) {
        System.out.printf("%n%s%n %s%n%s%n%n", SEPARADOR, titulo, SEPARADOR);
    }

    /**
     * @param numero posición del tour en el listado mostrado, empezando en uno
     * @param tour tour que se presenta
     */
    public static void mostrarTour(int numero, Tour tour) {
        System.out.printf("%02d. %s%n    Ubicación : %s%n    Valor     : $%d CLP%n"
                        + "    Categoría : %s%n%n",
                numero, tour.getNombre(), tour.getUbicacion(), tour.getValor(), tour.getCategoria());
    }
}
