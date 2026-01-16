package com.oola.headhunter.navhr.controllers.common;

public enum CodigoMensajes {
    CREAR_PAIS_OK("MSG_05_001");

    String codigo;

    private CodigoMensajes(String codigo){
        this.codigo=codigo;
    }

    public String getCodigo(){
        return this.codigo;
    }
}
