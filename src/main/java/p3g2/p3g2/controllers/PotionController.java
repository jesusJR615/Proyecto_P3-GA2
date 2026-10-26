package p3g2.p3g2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import p3g2.p3g2.excepciones.PotionNotFoundException;
import p3g2.p3g2.models.Monster;
import p3g2.p3g2.models.Potion;
import p3g2.p3g2.service.IMonsterService;
import p3g2.p3g2.service.IPotionService;

/**
 * PotionController
 */
@RestController
public class PotionController {
        private final IPotionService potionService;

        // Constructor
        public PotionController(IPotionService potionService) {
                this.potionService = potionService;
        }

        @GetMapping("/potion/{id}")
        public Potion findById(@PathVariable int id) {
                Potion potion = potionService.findById(id);
                // Compruebo si el potion es igual a nulo
                if (potion == null) {
                        throw new PotionNotFoundException("Poción no encontrada con id " + id);
                }
                return potion;
        }
}
