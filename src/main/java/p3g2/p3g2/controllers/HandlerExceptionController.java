package p3g2.p3g2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

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
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleNotFoundError(MonsterNotFoundException ex) {
        return new Error(ex.getMessage(), "El monstruo no existe",
                HttpStatus.NOT_FOUND.value(), new Date());
    }

    @ExceptionHandler(PotionExpiredException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleExpiredError(PotionExpiredException ex) {
        return new Error(ex.getMessage(), "La pocion esta caducada",
                HttpStatus.BAD_REQUEST.value(), new Date());
    }

    @ExceptionHandler(HauntedHouseClosedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Error handleCloseError(HauntedHouseClosedException ex) {
        return new Error(ex.getMessage(), "La casa del terror se encuentra cerrada",
                HttpStatus.FORBIDDEN.value(), new Date());
    }

    @ExceptionHandler(TooScaryException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public Error handleScaryError(TooScaryException ex) {
        return new Error(ex.getMessage(), "La casa da mucho miedo",
                HttpStatus.UNPROCESSABLE_ENTITY.value(), new Date());
    }

    // Otras excepciones
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleGeneric(Exception ex) {
        return new Error(ex.getMessage(), "Error interno del servidor",
                HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> handleNotFound(NoHandlerFoundException ex) {
        Error error = new Error(ex.getMessage(), "Recurso no encontrado",
                HttpStatus.NOT_FOUND.value(), new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleNoResourceFound(NoResourceFoundException ex) {
        return new Error(ex.getMessage(), "Ruta no encontrada",
                HttpStatus.NOT_FOUND.value(), new Date());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return new Error("Parámetro inválido: " + ex.getName(), "El id debe de ser un número entero",
                HttpStatus.BAD_REQUEST.value(), new Date());
    }

}