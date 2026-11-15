package cl.duoc.llanquihuetour.data;

import cl.duoc.llanquihuetour.model.Tour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class GestorDatos {

    /**
     * Lee registros con el formato nombre;ubicación;valor;categoría.
     * Las líneas en blanco se ignoran; los registros con una cantidad de campos
     * distinta de cuatro o un valor no entero se omiten y se resumen en consola.
     *
     * @param rutaArchivo ruta del archivo de tours
     * @return tours válidos en el orden del archivo, incluidos posibles duplicados
     * @throws IOException si no se puede abrir, leer o cerrar el archivo;
     *                     no se devuelve una lista parcial
     */
    public ArrayList<Tour> cargarDatos(Path rutaArchivo) throws IOException {
        ArrayList<Tour> tours = new ArrayList<>();

        int registrosConCamposInvalidos = 0;
        int registrosConValorInvalido = 0;

        // Lee el archivo línea por línea y garantiza su cierre incluso si ocurre una excepción.
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo.toFile()))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Las líneas en blanco no representan registros y no se cuentan como errores.
                if (linea.isBlank()) {
                    continue;
                }

                // Separa los campos por punto y coma y comprueba la estructura antes de acceder a ellos.
                String[] campos = linea.split(";");
                if (campos.length != 4) {
                    registrosConCamposInvalidos++;
                    continue;
                }

                try {
                    // Interpreta los campos en el orden del archivo; el precio debe ser un entero.
                    String nombre = campos[0];
                    String ubicacion = campos[1];
                    int valor = Integer.parseInt(campos[2]);
                    String categoria = campos[3];

                    // Incorpora cada registro aceptado como objeto Tour al ArrayList, en orden de lectura.
                    Tour tour = new Tour(nombre, ubicacion, valor, categoria);
                    tours.add(tour);
                } catch (NumberFormatException e) {
                    // Omite el registro con precio no convertible y permite continuar con los siguientes.
                    registrosConValorInvalido++;
                }
            }
        }
        // Agrupa los problemas de formato en un único aviso al terminar la lectura.
        if (registrosConCamposInvalidos > 0 || registrosConValorInvalido > 0) {
            System.out.printf("[WARN] En %s se omitieron %d registros: "
                            + "%d con cantidad de campos distinta de cuatro y %d con valor no entero.%n",
                    rutaArchivo, registrosConCamposInvalidos + registrosConValorInvalido,
                    registrosConCamposInvalidos, registrosConValorInvalido);
        }
        return tours;
    }

}
