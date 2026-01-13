package com.oola.headhunter.navhr.services.exceptions;

import com.oola.headhunter.navhr.services.exceptions.TipoExcepcion;

public class ServicioException extends Exception{

    private final TipoExcepcion tipo;
    private final String codigo;

    public ServicioException(String mensaje,TipoExcepcion tipo, String codigo){
        super(mensaje);
        this.tipo=tipo;
        this.codigo=codigo;
    }
    public TipoExcepcion getTipo(){
        return this.tipo;
    }
    public String getCodigo(){
        return this.codigo;
    }
}
