package p3g2.p3g2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import p3g2.p3g2.excepciones.HauntedHouseClosedException;
import p3g2.p3g2.excepciones.MonsterNotFoundException;
import p3g2.p3g2.excepciones.PotionExpiredException;
import p3g2.p3g2.excepciones.TooScaryException;
import p3g2.p3g2.models.Error;


import java.util.Date;

/**
 * HandlerExceptionController
 */
@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(MonsterNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleNotFoundError(MonsterNotFoundException ex) {
        return new Error(ex.getMessage(), "El monstruo no existe",
                HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());
    }

    @ExceptionHandler(PotionExpiredException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleExpiredError(PotionExpiredException ex) {
        return new Error(ex.getMessage(), "La pocion esta caducada",
                HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());
    }

    @ExceptionHandler(HauntedHouseClosedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleCloseError(HauntedHouseClosedException ex) {
        return new Error(ex.getMessage(), "La casa del terror se encuentra cerrada",
                HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());
    }

    @ExceptionHandler(TooScaryException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleScaryError(TooScaryException ex) {
        return new Error(ex.getMessage(), "La casa da mucho miedo",
                HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());
    }
}