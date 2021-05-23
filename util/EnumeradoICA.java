/**
 * Enumerado de los posibles valores de clasificación
 * de calidad del aire
 */
package co.com.projecto.monitorambiental.util;


public enum EnumeradoICA {

    BUENA_CALIDAD("Buena calidad"),
    CALIDAD_MODERADA("Calidad moderada"),
    DANINO_VULNERABLES("Dañino para grupos vulnerables"),
    DANINO_MAYORIA("Dañino para la mayoría de la población"),
    MUY_DANINO("Muy dañino"),
    PELIGROSO("Peligroso");

    private final String valor;

    EnumeradoICA(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
