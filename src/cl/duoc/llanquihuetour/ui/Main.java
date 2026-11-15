package cl.duoc.llanquihuetour.ui;

import cl.duoc.llanquihuetour.data.GestorDatos;
import cl.duoc.llanquihuetour.model.Tour;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Consola.encabezado("LLANQUIHUE TOUR");
        Consola.info("Iniciando aplicación Llanquihue Tour...");

        Path archivo = Path.of("resources/tours.txt");
        GestorDatos gestor = new GestorDatos();

        try {
            Consola.info("Cargando tours desde " + archivo + "...");
            ArrayList<Tour> tours = gestor.cargarDatos(archivo);
            Consola.exito("Lectura completada. Tours cargados: " + tours.size() + ".");

            Consola.encabezado("LISTADO DE TOURS");
            int numeroTour = 0;
            for (Tour tour : tours) {
                Consola.mostrarTour(++numeroTour, tour);
            }
            if (tours.isEmpty()) {
                Consola.advertencia("No hay tours disponibles.");
            }

            String categoriaAFiltrar = "Aventura";
            Consola.encabezado("FILTRO POR CATEGORÍA");
            Consola.info("Filtrando tours por categoría: " + categoriaAFiltrar);
            int coincidencias = 0;
            for (Tour tour : tours) {
                if (tour.getCategoria().equalsIgnoreCase(categoriaAFiltrar)) {
                    categoriaAFiltrar = tour.getCategoria();
                    Consola.mostrarTour(++coincidencias, tour);
                }
            }
            if (coincidencias == 0) {
                Consola.advertencia("No se encontraron tours para la categoría indicada.");
            } else {
                Consola.exito("Tours encontrados: " + coincidencias + ".");
            }
        } catch (IOException e) {
            Consola.error("No fue posible completar la lectura de " + archivo.toAbsolutePath()
                    + ". Compruebe que el archivo exista y tenga permisos de lectura.");
        }

        Consola.encabezado("FIN DEL PROGRAMA");
    }
}
