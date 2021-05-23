/**
 * Enumerado de los posibles valores de clasificación
 * de los niveles de ruido
 */
package co.com.projecto.monitorambiental.util;


public enum EnumeradoNivelesRuido {

    RUIDO_BAJO("Ruido bajo"),
    RUIDO_CONSIDERABLE("Ruido considerable"),
    RUIDO_ALTO("Ruido alto"),
    DISCOTECAS("Discotecas y conciertos"),
    UMBRAL_DOLOR("Umbral de dolor, daño irreversible");

    private final String valor;

    EnumeradoNivelesRuido(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

}
