/**
 * Clase de apoyo para definir los métodos 
 * que manipulan archivos del sistema
 */
package co.com.projecto.monitorambiental.util;

import co.com.projecto.monitorambiental.Comuna;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;


public class GestorArchivos {
    // Instancia del logger para control en consola
    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    /**
     * Método leer comunas, que busca un archivo en el sistema, 
     * lo crea si no existe y retorna la información de las comunas
     * que puede extraer si el archivo no está vacio. 
     * @param ruta La ruta del archivo
     * @return 
     */
    public List<Comuna> leerComunas(String ruta) {
        List<Comuna> comunas = new ArrayList<>();
        File f = new File(ruta);

        try {
            if (f.exists()) {
                List<String> lines = Files.readAllLines(Paths.get(ruta), StandardCharsets.UTF_8);
                for (String line : lines) {
                    String[] infoComuna = line.split(",");
                    String nombre = infoComuna[0].trim();
                    Integer numHabitantes = Integer.parseInt(infoComuna[1].trim());
                    Integer indiceCalidadAire = Integer.parseInt(infoComuna[2].trim());
                    Integer nivelRuido = Integer.parseInt(infoComuna[3].trim());
                    boolean basuras = Boolean.parseBoolean(infoComuna[4].trim());
                    String img = null;
                    if(infoComuna.length == 6){
                        img = infoComuna[5].trim();
                    }
                    comunas.add(new Comuna(nombre, numHabitantes, indiceCalidadAire, nivelRuido, basuras, img));
                }
            } else {
                boolean creado = f.createNewFile();
                String estado = "Se crea el archivo con estado " + creado;
                LOG.info(estado);
            }
        } catch (IOException | NumberFormatException e) {
            LOG.log(Level.SEVERE, "Error leyendo el archivo, por favor valide que el archivo exista y que tenga el formato correcto", e);
        }

        return comunas;

    }

    /**
     * Método de apoyo que permite editar un 
     * archivo del sistema con las comunas enviadas 
     * es decir almacena las comunas enviadas en el sistema, en el
     * archivo enviado
     * @param ruta La ruta del archivo
     * @param comunas 
     */
    public void agregarEditar(String ruta,
            List<Comuna> comunas) {

        try (BufferedWriter out = new BufferedWriter(
                new FileWriter(ruta, false))) {
            for(Comuna comuna: comunas){
                out.write(comuna.toString());
                out.write(System.lineSeparator());
            }
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Error escribiendo el archivo,"
                    + " por favor valide que el archivo exista y que tenga el formato correcto", e);
        }
    }

}
