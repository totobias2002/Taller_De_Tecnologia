package com.example.demo;

public class Trigo {
    private int indice_tiempo;
    private int superficie_sembrada_trigo_ha;
    private int superficie_cosechada_trigo_ha;
    private int produccion_trigo_t;
    private int rendimiento_trigo_kgxha;

    public Trigo(int indice_tiempo, int superficie_sembrada_trigo_ha, int superficie_cosechada_trigo_ha, int produccion_trigo_t, int rendimiento_trigo_kgxha) {
        this.indice_tiempo = indice_tiempo;
        this.superficie_sembrada_trigo_ha = superficie_sembrada_trigo_ha;
        this.superficie_cosechada_trigo_ha = superficie_cosechada_trigo_ha;
        this.produccion_trigo_t = produccion_trigo_t;
        this.rendimiento_trigo_kgxha = rendimiento_trigo_kgxha;
    }

    public int getindice_tiempo() {
        return indice_tiempo;
    }

    public void setindice_tiempo(int indice_tiempo)  {
        this.indice_tiempo = indice_tiempo;
    }

    public int getSuperficie_sembrada_trigo_ha() {
        return superficie_sembrada_trigo_ha;
    }

    public void setSuperficie_sembrada_trigo_ha(int superficie_sembrada_trigo_ha) {
        this.superficie_sembrada_trigo_ha = superficie_sembrada_trigo_ha;
    }

    public int getSuperficie_cosechada_trigo_ha() {
        return superficie_cosechada_trigo_ha;
    }

    public void setSuperficie_cosechada_trigo_ha(int superficie_cosechada_trigo_ha) {
        this.superficie_cosechada_trigo_ha = superficie_cosechada_trigo_ha;
    }

    public int getProduccion_trigo_t() {
        return produccion_trigo_t;
    }

    public void setProduccion_trigo_t(int produccion_trigo_t) {
        this.produccion_trigo_t = produccion_trigo_t;
    }

    public int getRendimiento_trigo_kgxha() {
        return rendimiento_trigo_kgxha;
    }

    public void setRendimiento_trigo_kgxha(int rendimiento_trigo_kgxha) {
        this.rendimiento_trigo_kgxha = rendimiento_trigo_kgxha;
    }

}
