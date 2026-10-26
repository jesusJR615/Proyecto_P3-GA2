package p3g2.p3g2.controllers;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import p3g2.p3g2.excepciones.HauntedHouseClosedException;
import p3g2.p3g2.excepciones.MonsterNotFoundException;
import p3g2.p3g2.excepciones.PotionExpiredException;
import p3g2.p3g2.excepciones.TooScaryException;

/**
 * SorpresaController
 */
@RestController
public class SorpresaController {

    @GetMapping("/trickortreat")
    public String trickorTreat() {
        // Creo la variable suerte, para delvolver de forma aleatoria un mensaje o una
        // expecepción
        int suerte = ThreadLocalRandom.current().nextInt(5);
        switch (suerte) {
            case 0:
                return "¡Truco o trato!";
            case 1:
                throw new MonsterNotFoundException("Apareció un monstruo");
            case 2:
                throw new PotionExpiredException("Te has bebido una poción caducada");
            case 3:
                throw new HauntedHouseClosedException("La casa está cerrada");
            default:
                throw new TooScaryException("Tines demasiado miedo");

        }

    }
}