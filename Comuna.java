/*
 * Clase que modela el objeto del mundo real "Comuna"
 */
package co.com.projecto.monitorambiental;

import co.com.projecto.monitorambiental.util.Funciones;
import java.util.Objects;


public class Comuna {

    private String nombre;
    private Integer numHabitantes;
    private Integer indiceCalidadAire;
    private Integer nivelRuido;
    private boolean basuras = false;
    private String rutaImagen;

    public Comuna() {
        super();
    }

    public Comuna(String nombre, Integer numHabitantes, Integer indiceCalidadAire, Integer nivelRuido, boolean basuras, String img) {
        this.nombre = nombre;
        this.numHabitantes = numHabitantes;
        this.indiceCalidadAire = indiceCalidadAire;
        this.nivelRuido = nivelRuido;
        this.basuras = basuras;
        this.rutaImagen = img;
    }

    @Override
    public String toString() {
        String str = nombre + "," + numHabitantes + "," + indiceCalidadAire + "," + nivelRuido + "," + basuras;
        if(Funciones.noNulo(rutaImagen)){
            str = str + "," + rutaImagen;
        }
        return str;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumHabitantes() {
        return numHabitantes;
    }

    public void setNumHabitantes(Integer numHabitantes) {
        this.numHabitantes = numHabitantes;
    }

    public Integer getIndiceCalidadAire() {
        return indiceCalidadAire;
    }

    public void setIndiceCalidadAire(Integer indiceCalidadAire) {
        this.indiceCalidadAire = indiceCalidadAire;
    }

    public Integer getNivelRuido() {
        return nivelRuido;
    }

    public void setNivelRuido(Integer nivelRuido) {
        this.nivelRuido = nivelRuido;
    }

    public boolean isBasuras() {
        return basuras;
    }

    public void setBasuras(boolean basuras) {
        this.basuras = basuras;
    }

    /**
     * Implementación del método equals para comparar dos comunas mediante su
     * nombre
     *
     * @param obj Objeto sujeto a comparar
     * @return Verdadero si la comuna obj es igual
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        return Objects.equals(this.nombre, ((Comuna) obj).getNombre());
    }

}
