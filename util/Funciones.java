/**
 * Clase de apoyo para el manejo de las 
 * funciones transversales del programa
 */
package co.com.projecto.monitorambiental.util;

import co.com.projecto.monitorambiental.Comuna;
import java.util.List;


public class Funciones {
    

    /**
     * Prevenir la instancia de la clase
     *
     * @throws IllegalAccessException
     */
    private Funciones() throws IllegalAccessException {
        throw new IllegalAccessException();
    }
    
    /**
     * Función de apoyo que permite clasificar el nivel
     * de calidad del aire. 
     * @param input El valor de calidad de aire a clasificar
     * @return Una posible clasificación o vacio si no es un valor definido
     */
    public static String clasificarICA(Object input) {
        int valor;
        try {
            valor = Integer.parseInt(String.valueOf(input));
        } catch (NumberFormatException e) {
            return "";
        }
        if (valor < 0) {
            return "";
        } else if (valor < 51) {
            return EnumeradoICA.BUENA_CALIDAD.getValor();
        } else if (valor < 101) {
            return EnumeradoICA.CALIDAD_MODERADA.getValor();
        } else if (valor < 151) {
            return EnumeradoICA.DANINO_VULNERABLES.getValor();
        } else if (valor < 201) {
            return EnumeradoICA.DANINO_MAYORIA.getValor();
        } else if (valor < 301) {
            return EnumeradoICA.MUY_DANINO.getValor();
        } else {
            return EnumeradoICA.PELIGROSO.getValor();
        }

    }
    /**
     * Función de apoyo que permite clasificar el nivel
     * de ruido. 
     * @param input El valor de ruido a clasificar
     * @return Una posible clasificación o vacio si no es un valor definido
     */
    public static String clasificarRuido(Object input) {
        int valor;
        try {
            valor = Integer.parseInt(String.valueOf(input));
        } catch (NumberFormatException e) {
            return "";
        }
        if (valor < 10) {
            return "";
        } else if (valor <= 55) {
            return EnumeradoNivelesRuido.RUIDO_BAJO.getValor();
        } else if (valor < 75) {
            return EnumeradoNivelesRuido.RUIDO_CONSIDERABLE.getValor();
        } else if (valor <= 100) {
            return EnumeradoNivelesRuido.RUIDO_ALTO.getValor();
        } else if (valor <= 120) {
            return EnumeradoNivelesRuido.DISCOTECAS.getValor();
        } else {
            return EnumeradoNivelesRuido.UMBRAL_DOLOR.getValor();
        }

    }
    
    /**
     * Agrega la comuna c a la lista si la lista no contiene
     * una comuna con un nombre igual a c. Si existe una comuna en 
     * la lista con el mismo nombre de la comuna c, la comuna c reemplaza
     * a la comuna de la lista
     * @param c
     * @param lista 
     */
    public static void agregarComuna(Comuna c, List<Comuna> lista){
        for(int i = 0; i< lista.size(); i++){
            Comuna actual = lista.get(i);
            if(actual.equals(c)) {
                lista.remove(i);
                lista.add(i, c);
                return;
            }
        }
            lista.add(c);
    }
    
    /**
     * Método de apoyo que valida si un 
     * String es vacio
     * @param o
     * @return 
     */
    public static boolean noNulo(String o){
        return o != null && !o.isEmpty() && !o.isBlank();
    }
    
    /**
     * Método de apoyo que permite validar si un 
     * String es un número
     * @param s
     * @return 
     */
    public static boolean esNumero(String s){
        if(!noNulo(s)) return false;
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    /**
     * Método de apoyo que retorna el nombre de
     * la comuna con el peor indice de calidad de aire 
     * @param comunas
     * @return 
     */
    public static String nombreComunaConMasIca(List<Comuna> comunas){
        Integer valor = 0;
        String nombre = "No definido";
        for(Comuna c: comunas){
            if(c.getIndiceCalidadAire() > valor) nombre = c.getNombre();
        }
        return nombre;
    }
    /**
     * Método de apoyo que retorna el número de habitantes
     * de la comuna con el peor nivel de ruido 
     * @param comunas
     * @return 
     */
    public static  String numHabComunaMasRuidosa(List<Comuna> comunas){
        Integer valor = 0;
        String hab = "No definido";
        for(Comuna c: comunas){
            if(c.getNivelRuido()> valor) hab = String.valueOf(c.getNumHabitantes());
        }
        return hab;
    }

}
