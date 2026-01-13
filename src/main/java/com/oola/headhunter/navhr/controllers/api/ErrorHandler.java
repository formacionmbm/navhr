package com.oola.headhunter.navhr.controllers.api;

import com.oola.headhunter.navhr.services.exceptions.ServicioException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {
    Logger log = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handlerException(){
        log.info("[handlerException]");
        return "Error General";
    }

    @ExceptionHandler(ServicioException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public String handlerServicioException(ServicioException se){
        log.info("[handlerServicioException]");
        return "Error de Servicio";
    }
}
