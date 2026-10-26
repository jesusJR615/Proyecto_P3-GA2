package p3g2.p3g2.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import p3g2.p3g2.excepciones.HauntedHouseClosedException;
import p3g2.p3g2.excepciones.TooScaryException;
import p3g2.p3g2.models.HauntedHouse;
import p3g2.p3g2.service.IHauntedHouseService;

/**
 * HauntedHouseController
 */
@RestController
public class HauntedHouseController {
    private final IHauntedHouseService hauntedhousesService;

    public HauntedHouseController(IHauntedHouseService hauntedhousesService) {
        this.hauntedhousesService = hauntedhousesService;
    }

    @GetMapping("/enter/{id}")
    public HauntedHouse findById(@PathVariable int id) {
    HauntedHouse house = hauntedhousesService.findById(id);
    // Compruebo si la casa es igual a nulo
    if (house == null) {
        throw new HauntedHouseClosedException("Casa encantada no encontrada con id: " + id);
    }
    // Compruebo si la casa esta abierta
    if (!house.isOpen()) {
        throw new HauntedHouseClosedException("La casa esta cerrada");
    }
    // Compruebo el nivel de miedo de la casa
    if (house.getScareLevel() >= 8) {
        throw new TooScaryException("La casa da mucho miedo");
    }

    return house;

}
}
